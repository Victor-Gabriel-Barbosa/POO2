/* Imagine que você tenha um ritual para assistir filmes domingo à tarde utilizando seu home
theater em sua cinemateca. Você:
1. liga a pipoqueira
2. rebenta pipoca
3. desliga as luzes
4. abaixa o telão
5. liga o projetor
6. liga o amplificador
7. ajusta o volume do som para 10 no amplificador
8. liga o player
9. aperta o play indicando o filme que quer assistir
Considere um contexto em que existam os seguintes objetos e suas funcionalidades em sua
cinemateca:
● Amplificador (liga, ajuste de volume)
● Luzes (liga, desliga)
● Máquina de Pipoca (liga, desliga, arrebenta pipoca)
● Projetor (liga, desliga)
● Player de Streaming (liga, desliga, play em um filme)
● Telão (abaixa, sobe)
a) Implemente o problema utilizando o padrão de projeto Fachada.
b) Proponha e implemente um método em sua fachada chamado fimDoFilme().*/

// Classe que representa as luzes
class Luzes {
  public void ligar() {
    System.out.println("Ligando as luzes");
  }

  public void desligar() {
    System.out.println("Desligando as luzes");
  }
}

// Classe que representa a máquina de pipoca
class MaquinaPipoca {
  public void ligar() {
    System.out.println("Ligando a máquina de pipoca");
  }

  public void desligar() {
    System.out.println("Desligando a máquina de pipoca");
  }

  public void arrebentar() {
    System.out.println("Arrebentando a pipoca");
  }
}

// Classe que representa o projetor
class Projetor {
  public void ligar() {
    System.out.println("Ligando o projetor");
  }

  public void desligar() {
    System.out.println("Desligando o projetor");
  }
}

// Classe que representa o amplificador
class Amplificador {
  public void ligar() {
    System.out.println("Ligando o amplificador");
  }

  public void ajustarVolume() {
    System.out.println("Ajustando o volume do som");
  }

  public void desligar() {
    System.out.println("Desligando o amplificador");
  }
}

// Classe que representa o player
class Player {
  public void ligar() {
    System.out.println("Ligando o player");
  }

  public void desligar() {
    System.out.println("Desligando o player");
  }

  public void play(String filme) {
    System.out.println("Tocando o filme " + filme);
  }
}

// Classe para a implementação da fachada da cinemateca
public class Cinemateca {
  private final Luzes luzes;
  private final MaquinaPipoca maquinaPipoca;
  private final Projetor projetor;
  private final Amplificador amplificador;
  private final Player player;
  
  public Cinemateca(Luzes luzes, MaquinaPipoca maquinaPipoca, Projetor projetor, Amplificador amplificador, Player player) {
    this.luzes = luzes;
    this.maquinaPipoca = maquinaPipoca;
    this.projetor = projetor;
    this.amplificador = amplificador;
    this.player = player;
  }

  public void inicioDoFilme() {
    maquinaPipoca.ligar();
    maquinaPipoca.arrebentar();
    luzes.ligar();
    projetor.ligar();
    amplificador.ligar();
    amplificador.ajustarVolume();
    player.play("Filme 1");
    amplificador.desligar();
    projetor.desligar();
    luzes.desligar();
    maquinaPipoca.desligar();
  }

  public void fimDoFilme() {
    System.out.println("Fim do filme");
    luzes.desligar();
    maquinaPipoca.desligar();
    projetor.desligar();
    amplificador.desligar();
    player.desligar();
  }
}