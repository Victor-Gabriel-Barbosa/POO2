import java.util.ArrayList;
import java.util.List;

public class CarrinhoComprasImpl implements CarrinhoCompras {
    private List<Item> itens;
    
    public CarrinhoComprasImpl() {
        this.itens = new ArrayList<>();
    }
    
    @Override
    public void adicionaItem(Item item) {
        // Verificar se o item já existe no carrinho
        for (Item i : itens) {
            if (i.getNome().equals(item.getNome())) {
                i.setQuantidade(i.getQuantidade() + item.getQuantidade());
                return;
            }
        }
        // Se não existir, adiciona o novo item
        itens.add(item);
    }
    
    @Override
    public void removeItem(Item item) {
        itens.removeIf(i -> i.getNome().equals(item.getNome()));
    }
    
    @Override
    public double calculaTotal() {
        return itens.stream()
                    .mapToDouble(Item::getValorTotal)
                    .sum();
    }
    
    @Override
    public boolean realizaPagamento(PagamentoStrategy pagamentoStrategy) {
        double valorTotal = calculaTotal();
        if (valorTotal > 0) {
            return pagamentoStrategy.pagar(valorTotal);
        }
        System.out.println("Carrinho vazio, não é possível realizar o pagamento.");
        return false;
    }
    
    public void mostrarItens() {
        if (itens.isEmpty()) {
            System.out.println("Carrinho vazio");
            return;
        }
        
        System.out.println("==== ITENS NO CARRINHO ====");
        for (Item item : itens) {
            System.out.println(item);
        }
        System.out.println("==========================");
        System.out.println("Total: R$ " + calculaTotal());
    }
}