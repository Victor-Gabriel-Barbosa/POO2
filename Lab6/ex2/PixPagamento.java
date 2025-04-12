public class PixPagamento implements PagamentoStrategy {
  private String chavePix;

  public PixPagamento(String chavePix) {
    this.chavePix = chavePix;
  }

  @Override
  public boolean pagar(double valor) {
    // Implementa o processamento de pagamento via Pix
    System.out.println("Pagamento via PIX no valor de R$ " + valor + " realizado com sucesso para a chave: " + chavePix);
    return true;
  }
}