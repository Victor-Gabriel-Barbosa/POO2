public class AppVehicle {
  public static void main(String[] args) {
    // Testando veículos Toyota
    Toyota toyota = Toyota.getInstance();

    System.out.println("\n=== Testando Corola ===");
    IVehicle corola = toyota.makeVehicle("Corola");
    corola.start();
    corola.drive();
    corola.stop();

    System.out.println("\n=== Testando Hilux ===");
    IVehicle hilux = toyota.makeVehicle("Hilux");
    hilux.start();
    hilux.drive();
    hilux.stop();

    System.out.println("\n=== Testando Etios ===");
    IVehicle etios = toyota.makeVehicle("Etios");
    etios.start();
    etios.drive();
    etios.stop();

    // Testando veículos Honda
    Honda honda = Honda.getInstance();

    System.out.println("\n=== Testando City ===");
    IVehicle city = honda.makeVehicle("City");
    city.start();
    city.drive();
    city.stop();

    System.out.println("\n=== Testando Civic ===");
    IVehicle civic = honda.makeVehicle("Civic");
    civic.start();
    civic.drive();
    civic.stop();

    System.out.println("\n=== Testando Fit ===");
    IVehicle fit = honda.makeVehicle("Fit");
    fit.start();
    fit.drive();
    fit.stop();

    // Testando padrão de projeto Factory para a classe 'Toyota'
    System.out.println("\n=== Testando Factory: Toyota ===");
    try {
      toyota.makeVehicle("City");
    } catch (IllegalArgumentException e) {
      System.out.println("Erro esperado: " + e.getMessage());
    }

    // Testando padrão de projeto Factory para a classe 'Honda'
    System.out.println("\n=== Testando Factory: Honda ===");
    try {
      honda.makeVehicle("Hilux");
    } catch (IllegalArgumentException e) {
      System.out.println("Erro esperado: " + e.getMessage());
    }

    // Testando padrão de projeto Singleton
    Toyota toyota2 = Toyota.getInstance(); 
    Honda honda2 = Honda.getInstance();

    System.out.println("\n=== Testando Singleton ===");
    System.out.println("Toyota singleton funciona: " + ((toyota == toyota2) ? "Sim" : "Não"));
    System.out.println("Honda singleton funciona: " + ((honda == honda2) ? "Sim" : "Não"));
  }
}