public class Pizzaria {
  public static void main(String[] args) {
    // Cria uma pizza Marguerita
    Pizza marguerita = new MassaFinaPizza();
    marguerita = new Queijo(marguerita);
    marguerita = new Tomate(marguerita);

    System.out.println(marguerita.getDescricao() + " - Preço: R$" + marguerita.getPreco());

    // Cria uma pizza Portuguesa
    Pizza portuguesa = new MassaEspessaPizza();
    portuguesa = new Queijo(portuguesa);
    portuguesa = new Ovo(portuguesa);
    portuguesa = new Tomate(portuguesa);

    System.out.println(portuguesa.getDescricao() + " - Preço: R$" + portuguesa.getPreco());
  }
}
