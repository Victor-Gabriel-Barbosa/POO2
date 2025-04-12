public interface CarrinhoCompras {
  void adicionaItem(Item item);
  void removeItem(Item item);
  double calculaTotal();
  double calculaFrete(FreteStrategy estrategiaFrete);
  boolean realizaPagamento(PagamentoStrategy pagamentoStrategy);
}