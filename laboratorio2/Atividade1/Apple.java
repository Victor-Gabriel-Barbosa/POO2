// Classe concreta 'Apple' que implementa a interface 'FabricanteCelular'
public class Apple implements FabricanteCelular {
  // Instância única para a classe 'Apple'
  private static Apple instancia;

  // Construtor privado para garantir a unicidade da instância da classe 'Apple'
  private Apple() {}

  // Método estático para obtenção da instância única da classe 'Apple'
  public static Apple getInstance() {
    if (instancia == null) instancia = new Apple();
    return instancia;
  }

  // Método que retorna um objeto de um tipo específico de celular, conforme o modelo informado
  @Override
  public Celular constroiCelular(String modelo) {
    switch (modelo.toLowerCase()) {
      case "iphonex": return new IPhoneX();
      case "iphones": return new IPhoneS();
      default: throw new IllegalArgumentException("Modelo de iPhone não reconhecido: " + modelo);
    }
  }
}