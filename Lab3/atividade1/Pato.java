public class Pato {
  public void voar() {
    System.out.println("Pato voando");
  }

  public void grasnar() {
    System.out.println("Pato emitindo som");
  }
}

class PatoAdapter implements Ave {
  private final Pato pato;

  public PatoAdapter(Pato pato) {
    this.pato = pato;
  }

  @Override
  public void voar() {
    pato.voar();
  }

  @Override
  public void emitirSom() {
    pato.grasnar();
  }
}