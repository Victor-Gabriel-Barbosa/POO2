public class CartaoPagamento implements PagamentoStrategy {
  private String numero;
  private String nome;
  private String cvv;
  private String dataValidade;

  public CartaoPagamento(String numero, String nome, String cvv, String dataValidade) {
    this.numero = numero;
    this.nome = nome;
    this.cvv = cvv;
    this.dataValidade = dataValidade;
  }

  @Override
  public boolean pagar(double valor) {
    // Implementa o processamento de pagamento via cartão
    String ultimosDigitos = numero.length() > 4 ? numero.substring(numero.length() - 4) : numero;
    System.out.println("Pagamento via Cartão no valor de R$ " + valor + " processado com sucesso para o cartão: " + ultimosDigitos);
    return true;
  }
}
