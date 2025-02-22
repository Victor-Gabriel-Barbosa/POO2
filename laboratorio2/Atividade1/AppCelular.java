public class AppCelular {
  public static void main(String[] args) {
    // Testando celulares Samsung
    FabricanteCelular samsung = Samsung.getInstance();

    Celular galaxyS8 = samsung.constroiCelular("galaxyS8");
    Celular galaxy20 = samsung.constroiCelular("galaxy20");

    System.out.println("=== Testando Samsung Galaxy S8 ===");
    galaxyS8.fazLigacao();
    galaxyS8.tiraFoto();

    System.out.println("\n=== Testando Samsung Galaxy 20 ===");
    galaxy20.fazLigacao();
    galaxy20.tiraFoto();

    // Testando celulares Apple
    FabricanteCelular apple = Apple.getInstance();

    Celular iPhoneX = apple.constroiCelular("iphoneX");
    Celular iPhoneS = apple.constroiCelular("iPhoneS");

    System.out.println("\n=== Testando iPhone X ===");
    iPhoneX.fazLigacao();
    iPhoneX.tiraFoto();

    System.out.println("\n=== Testando iPhone S ===");
    iPhoneS.fazLigacao();
    iPhoneS.tiraFoto();

    // Testando padrão de projeto Factory para a classe 'Samsung'
    System.out.println("\n=== Testando Factory: Samsung ===");
    try {
      samsung.constroiCelular("iphoneX");
    } catch (IllegalArgumentException e) {
      System.out.println("Erro esperado: " + e.getMessage());
    }

    // Testando padrão de projeto Factory para a classe 'Apple'
    System.out.println("\n=== Testando Factory: Apple ===");
    try {
      apple.constroiCelular("galaxy20");
    } catch (IllegalArgumentException e) {
      System.out.println("Erro esperado: " + e.getMessage());
    }

    // Testando padrão de projeto Singleton
    FabricanteCelular samsung2 = Samsung.getInstance();
    FabricanteCelular apple2 = Apple.getInstance();

    System.out.println("\n=== Testando Singleton ===");
    System.out.println("Samsung singleton funciona: " + (samsung == samsung2));
    System.out.println("Apple singleton funciona: " + (apple == apple2));
  }
}
