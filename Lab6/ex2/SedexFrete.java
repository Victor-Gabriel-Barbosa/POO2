public class SedexFrete implements FreteStrategy {
  private static final double TAXA_BASE = 15.0;
  private static final double PERCENTUAL = 0.03; // 3% do valor da compra

  @Override
  public double calcular(double valorCompra) {
    // SEDEX tem um valor base mais um percentual sobre o valor da compra
    return TAXA_BASE + (valorCompra * PERCENTUAL);
  }

  @Override
  public String getNome() {
    return "SEDEX";
  }
}