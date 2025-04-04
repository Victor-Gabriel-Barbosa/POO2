
// Interface que define o contrato para processamento de pagamentos
public interface ProcessadorPagamento {
  void processarPagamento(double valor);
}

// Implementação do processador de pagamentos
class ProcessadorPagamentoReal implements ProcessadorPagamento {
  @Override
  public void processarPagamento(double valor) {
    System.out.println("Processando pagamento real de R$ " + valor);
    System.out.println("Pagamento processado com sucesso!");
  }
}