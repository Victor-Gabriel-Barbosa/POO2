import java.util.Scanner;

public class AppPagamento {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    CarrinhoCompras carrinho = new CarrinhoComprasImpl();
    
    // Adiciona alguns itens ao carrinho
    carrinho.adicionaItem(new Item("Smartphone", 1999.90, 1));
    carrinho.adicionaItem(new Item("Fone de Ouvido Bluetooth", 299.90, 1));
    carrinho.adicionaItem(new Item("Carregador Portátil", 89.90, 2));
    
    // Mostra os itens no carrinho
    ((CarrinhoComprasImpl)carrinho).mostrarItens();
    
    // Seleciona a estratégia de pagamento
    System.out.println("\nSelecione o método de pagamento:");
    System.out.println("1 - Pix");
    System.out.println("2 - Cartão de Crédito");
    System.out.println("3 - Boleto Bancário");
    System.out.print("Opção: ");
    
    int opcao = scanner.nextInt();
    scanner.nextLine(); 
    
    PagamentoStrategy estrategia = null;
    
    switch (opcao) {
      case 1:
        System.out.print("Digite sua chave Pix: ");
        String chavePix = scanner.nextLine();
        estrategia = new PixPagamento(chavePix);
        break;
        
      case 2:
        System.out.print("Número do cartão: ");
        String numeroCartao = scanner.nextLine();
        System.out.print("Nome do titular: ");
        String nomeTitular = scanner.nextLine();
        System.out.print("CVV: ");
        String cvv = scanner.nextLine();
        System.out.print("Data de validade (MM/AA): ");
        String dataValidade = scanner.nextLine();
        estrategia = new CartaoPagamento(numeroCartao, nomeTitular, cvv, dataValidade);
        break;
        
      case 3:
        System.out.print("CPF do pagador: ");
        String cpf = scanner.nextLine();
        estrategia = new BoletoPagamento(cpf);
        break;
        
      default:
        System.out.println("Opção inválida!");
        scanner.close();
        return;
    }
    
    // Realiza o pagamento com a estratégia escolhida
    System.out.println("\nProcessando pagamento...");
    boolean pagamentoRealizado = carrinho.realizaPagamento(estrategia);
    
    if (pagamentoRealizado) System.out.println("\nCompra finalizada com sucesso!");
    else System.out.println("\nHouve um problema com o pagamento. Por favor, tente novamente.");
    
    scanner.close();
  }
}