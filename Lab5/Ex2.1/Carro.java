/* Um carro possui os seguintes objetos:
● motor
● cinto de segurança
● porta
● farol
● rádio
Toda vez que o carro é dirigido, o motorista deve ligar o motor, trancar as portas, travar o
cinto de segurança, acender o farol, ligar o rádio e sintonizar o rádio em sua estação
preferida.
Para finalizar uma corrida e desligar o carro, deve-se desligar o motor, destrancar as portas,
destravar o cinto de segurança, apagar o farol e desligar o rádio.
*/

// Classe que representa um carro
class Motor {
  public void ligar() {
    System.out.println("Motor ligado");
  }

  public void desligar() {
    System.out.println("Motor desligado");
  }
}

// Classe que representa um cinto de segurança
class CintoDeSeguranca {
  public void trancar() {
    System.out.println("Cinto de segurança trancou");
  }

  public void destrancar() {
    System.out.println("Cinto de segurança destrancou");
  }
}

// Classe que representa uma porta
class Porta {
  public void abrir() {
    System.out.println("Porta abriu");
  }

  public void fechar() {
    System.out.println("Porta fechou");
  }
}

// Classe que representa um farol
class Farol {
  public void acender() {
    System.out.println("Farol aceso");
  }

  public void apagar() {
    System.out.println("Farol apagado");
  }
}

// Classe que representa um rádio
class Radio {
  public void ligar() {
    System.out.println("Radio ligado");
  }

  public void desligar() {
    System.out.println("Radio desligado");
  }

  public void sintonizar(String estacao) {
    System.out.println("Sintonizando em " + estacao);
  }
}

// Classe de fachada para as funcionalidades do carro
public class Carro {
  private Motor motor;
  private CintoDeSeguranca cintoDeSeguranca;
  private Porta porta;
  private Farol farol;
  private Radio radio;

  // Construtor da classe de fachada
  public Carro(Motor motor, CintoDeSeguranca cintoDeSeguranca, Porta porta, Farol farol, Radio radio) {
    this.motor = motor;
    this.cintoDeSeguranca = cintoDeSeguranca;
    this.porta = porta;
    this.farol = farol;
    this.radio = radio;
  }

  // Método para dirigir o carro
  public void dirigir() {
    motor.ligar();
    porta.abrir();
    cintoDeSeguranca.trancar();
    farol.acender();
    radio.ligar();
    radio.sintonizar("Estação preferida");
  }

  // Método para finalizar a corrida e desligar o carro
  public void finalizarCorrida() {
    radio.desligar();
    farol.apagar();
    cintoDeSeguranca.destrancar();
    porta.fechar();
    motor.desligar();
  }
}