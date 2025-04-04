// API externa do PIX
public class APIPix {
  public String gerarCobranca(double valor, String chave) {
    // Gera uma cobrança PIX
    System.out.println("PIX: Gerando cobrança de R$ " + valor + " para chave " + chave);
    return "PIX" + System.currentTimeMillis(); // ID da transação
  }
  
  public int verificarPagamento(String idTx) {
    // Verifica se o pagamento foi realizado
    System.out.println("PIX: Verificando pagamento " + idTx);
    return 1; // 1=pago, 0=pendente, -1=cancelado
  }
  
  public boolean estornarPagamento(String idTx) {
    System.out.println("PIX: Estornando pagamento " + idTx);
    return true;
  }
}