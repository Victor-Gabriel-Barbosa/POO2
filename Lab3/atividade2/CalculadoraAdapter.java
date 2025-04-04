class CalculadoraAdapter implements Calculadora {
  private final CalculadoraBinaria calculadoraBinaria;

  public CalculadoraAdapter() {
    this.calculadoraBinaria = new CalculadoraBinaria();
  }

  @Override
  public int somar(int a, int b) {
    String binA = Integer.toBinaryString(a);
    String binB = Integer.toBinaryString(b);
    String resultado = calculadoraBinaria.somar(binA, binB);
    return Integer.parseInt(resultado, 2);
  }

  @Override
  public int subtrair(int a, int b) {
    String binA = Integer.toBinaryString(a);
    String binB = Integer.toBinaryString(b);
    String resultado = calculadoraBinaria.subtrair(binA, binB);
    return Integer.parseInt(resultado, 2);
  }

  @Override
  public int multiplicar(int a, int b) {
    int resultado = 0;
    for (int i = 0; i < b; i++)
      resultado = somar(resultado, a);
    return resultado;
  }

  public String somaBinaria(String a, String b) {
    return calculadoraBinaria.somar(a, b);
  }

  public String subtracaoBinaria(String a, String b) {
    return calculadoraBinaria.subtrair(a, b);
  }

  public String multiplicacaoBinaria(String a, String b) {
    int numA = Integer.parseInt(a, 2);
    int numB = Integer.parseInt(b, 2);
    int resultado = multiplicar(numA, numB);
    return Integer.toBinaryString(resultado);
  }
}