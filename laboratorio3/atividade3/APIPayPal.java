// API externa do PayPal
public class APIPayPal {
  public String executarPagamento(double valor, String tipoMoeda, String contaUsuario) {
    // Código que simula a comunicação com a API real do PayPal
    System.out.println("PayPal: Processando pagamento de " + valor + " " + tipoMoeda);
    return "PP-" + Math.round(Math.random() * 1000000); // ID da transação
  }
  
  public String obterEstadoPagamento(String idPagamento) {
    // Verifica o status no PayPal
    System.out.println("PayPal: Verificando status do pagamento " + idPagamento);
    return "COMPLETED"; // Simula resposta
  }
  
  public boolean reverterPagamento(String idPagamento, String motivo) {
    // Estorna pagamento no PayPal
    System.out.println("PayPal: Estornando pagamento " + idPagamento + " por: " + motivo);
    return true;
  }
}