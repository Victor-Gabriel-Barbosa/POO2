public class AppCarroFachada {
  public static void main(String[] args) {
    // Testa a fachada Carro
    Carro carro = new Carro(new Motor(), new CintoDeSeguranca(), new Porta(), new Farol(), new Radio());
    carro.dirigir();
    carro.finalizarCorrida();
  }
}