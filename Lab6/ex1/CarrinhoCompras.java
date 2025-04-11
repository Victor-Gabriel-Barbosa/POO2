public interface CarrinhoCompras {
  void adicionaItem(Item item);
  void removeItem(Item item);
  double calculaTotal();
  boolean realizaPagamento(PagamentoStrategy pagamentoStrategy);
}