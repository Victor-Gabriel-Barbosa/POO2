public class NormalFrete implements FreteStrategy {
  private static final double TAXA_BASE = 8.0;
  private static final double VALOR_FRETE_GRATIS = 150.0; // Frete grátis para compras acima de R$ 150,00

  @Override
  public double calcular(double valorCompra) {
    // Frete grátis para compras acima do valor mínimo
    if (valorCompra >= VALOR_FRETE_GRATIS) return 0.0;
    return TAXA_BASE;
  }

  @Override
  public String getNome() {
    return "Normal";
  }
}