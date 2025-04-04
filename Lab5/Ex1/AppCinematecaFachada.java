public class AppCinematecaFachada {
  public static void main(String[] args) {
    // Testa a fachada Cinemateca
    Cinemateca cinema = new Cinemateca(new Luzes(), new MaquinaPipoca(), new Projetor(), new Amplificador(), new Player());
    cinema.inicioDoFilme();
    cinema.fimDoFilme();
  }
}