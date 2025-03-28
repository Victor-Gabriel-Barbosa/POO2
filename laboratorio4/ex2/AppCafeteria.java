public class AppCafeteria {
  public static void main(String[] args) {
    // Cria um café Espresso com leite e canela
    Bebida bebida1 = new Espresso();
    bebida1 = new Leite(bebida1);
    bebida1 = new Canela(bebida1);

    System.out.println(bebida1.getDescricao() + " - Custo: R$" + bebida1.calculaCusto());

    // Cria um café Descafeinado com chocolate
    Bebida bebida2 = new Decaf();
    bebida2 = new Chocolate(bebida2);

    System.out.println(bebida2.getDescricao() + " - Custo: R$" + bebida2.calculaCusto());
  }
}