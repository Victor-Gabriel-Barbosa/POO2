public class BoletoPagamento implements PagamentoStrategy {
  private String cpfCliente;
  
  public BoletoPagamento(String cpfCliente) {
    this.cpfCliente = cpfCliente;
  }
  
  @Override
  public boolean pagar(double valor) {
    // Implementa o processamento de pagamento via boleto
    String codigoBoleto = gerarCodigoBoleto();
    System.out.println("Boleto gerado no valor de R$ " + valor + "\nCódigo: " + codigoBoleto);
    System.out.println("Aguardando compensação do pagamento...");
    return true;
  }
  
  private String gerarCodigoBoleto() {
    // Gera um código de boleto aleatório
    return "34191.79001 01043.510047 91020.150008 3 " + (int)(Math.random() * 100000);
  }
}