public class AppCalculadora {
  public static void main(String[] args) {
    CalculadoraAdapter calculadora = new CalculadoraAdapter();
    
    System.out.println("==== Operações com números decimais ====");
    System.out.println("5 + 3 = " + calculadora.somar(5, 3));
    System.out.println("10 - 4 = " + calculadora.subtrair(10, 4));
    System.out.println("6 * 7 = " + calculadora.multiplicar(6, 7));
    
    System.out.println("\n==== Operações com números binários ====");
    System.out.println("101 + 11 = " + calculadora.somaBinaria("101", "11") + " (em binário)");
    System.out.println("1010 - 100 = " + calculadora.subtracaoBinaria("1010", "100") + " (em binário)");
    System.out.println("110 * 111 = " + calculadora.multiplicacaoBinaria("110", "111") + " (em binário)");
    
    System.out.println("\n==== Convertendo entre representações ====");
    System.out.println("101 (binário) + 11 (binário) = " + Integer.parseInt(calculadora.somaBinaria("101", "11"), 2) + " (em decimal)");
    System.out.println("5 (decimal) + 3 (decimal) = " + calculadora.somaBinaria("101", "11") + " (em binário)");
  }
}