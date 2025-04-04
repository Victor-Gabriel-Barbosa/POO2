// Proxy de Proteção para o processador de pagamentos
public class ProcessadorPagamentoProxy implements ProcessadorPagamento {
  private final ProcessadorPagamentoReal processadorReal;
  private final String funcaoUsuario;

  public ProcessadorPagamentoProxy(String funcaoUsuario) {
    this.funcaoUsuario = funcaoUsuario;
    this.processadorReal = new ProcessadorPagamentoReal();
  }

  @Override
  public void processarPagamento(double valor) {
    // Verifica autorizações antes de processar o pagamento
    if (!temPermissao()) {
      System.out.println("Acesso negado! Usuário não tem permissão para processar pagamentos.");
      return;
    }

    // Valida o valor do pagamento
    if (!valorValido(valor)) {
      System.out.println("Valor de pagamento inválido! O valor deve estar entre R$ 1,00 e R$ 10000,00");
      return;
    }

    // Registra a tentativa de pagamento
    registrarTentativaPagamento(valor);

    // Se passar por todas as validações, processa o pagamento
    processadorReal.processarPagamento(valor);
  }

  // Valida se um usuário tem permissão de acesso
  private boolean temPermissao() {
    return "ADMIN".equals(funcaoUsuario) || "FINANCE".equals(funcaoUsuario);
  }

  // Valida se um valor é válido
  private boolean valorValido(double valor) {
    return valor >= 1.0 && valor <= 10000.0;
  }

  // Registra um log para a tentativa de pagamento
  private void registrarTentativaPagamento(double valor) {
    System.out.println("Log: Tentativa de pagamento - Valor: R$ " + valor + " | Usuário: " + funcaoUsuario);
  }
}