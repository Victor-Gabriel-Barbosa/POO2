// Classe concreta 'Toyota' que implementa a interface 'IVehicleMaker'
public class Toyota implements IVehicleMaker {
  // Instância única para a classe 'Toyota'
  private static Toyota instancia;

  // Construtor privado para garantir a unicidade da instância da classe 'Toyota'
  private Toyota() {} 

  // Método estático para obtenção da instância única da classe 'Toyota'
  // Isso evita a criação excessiva de objetos que podem consumir muita memória e processamento
  public static Toyota getInstance() {
    if (instancia == null) instancia = new Toyota();
    return instancia;
  }
  
  // Método que retorna um objeto de um tipo específico de veículo, conforme o modelo informado
  // Isso garante encapsulamento e reduz o acoplamento entre a criação de objetos e seu uso
  @Override
  public IVehicle makeVehicle(String modelo) {
    switch (modelo) {
      case "Corola": return new Corola();
      case "Hilux": return new Hilux();
      case "Etios": return new Etios();
      default: throw new IllegalArgumentException("Veículo Toyota não reconhecido: " + modelo);
    }
  }
}