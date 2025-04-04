// Classe concreta 'Samsung' que implementa a interface 'FabricanteCelular'
public class Samsung implements FabricanteCelular {
  // Instância única para a classe 'Samsung'
  private static Samsung instancia;

  // Construtor privado para garantir a unicidade da instância da classe 'Samsung'
  private Samsung() {}

  // Método estático para obtenção da instância única da classe 'Samsung'
  public static Samsung getInstance() {
    if (instancia == null) instancia = new Samsung();
    return instancia;
  }

  // Método que retorna um objeto de um tipo específico de celular, conforme o modelo informado
  @Override
  public Celular constroiCelular(String modelo) {
    switch (modelo.toLowerCase()) {
      case "galaxys8": return new GalaxyS8();
      case "galaxy20": return new Galaxy20();
      default: throw new IllegalArgumentException("Modelo de Samsung não reconhecido: " + modelo);
    }
  }
}