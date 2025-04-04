// Classe concreta 'Honda' que implementa a interface 'IVehicleMaker'
public class Honda implements IVehicleMaker {
  // Instância única para a classe 'Honda'
  private static Honda instancia;

  // Construtor privado para garantir a unicidade da instância da classe 'Honda'
  private Honda() {}

  // Método estático para obtenção da instância única da classe 'Honda'
  // Isso evita a criação excessiva de objetos que podem consumir muita memória e processamento
  public static Honda getInstance() {
    if (instancia == null) instancia = new Honda();
    return instancia;
  }

  // Método que retorna um objeto de um tipo específico de veículo, conforme o modelo informado
  // Isso garante encapsulamento e reduz o acoplamento entre a criação de objetos e seu uso
  @Override
  public IVehicle makeVehicle(String modelo) {
    switch (modelo) {
      case "City": return new City();
      case "Civic": return new Civic();
      case "Fit": return new Fit();
      default: throw new IllegalArgumentException("Veículo Honda não reconhecido: " + modelo);
    }
  }
}