public class Pato {
  public void voar() {
    System.out.println("Pato voando");
  }

  public void grasnar() {
    System.out.println("Pato emitindo som");
  }
}

class PatoAdapter implements Ave {
  private Pato pato;

  public PatoAdapter(Pato pato) {
    this.pato = pato;
  }

  @Override
  public void voar() {
    System.out.println("Pato está voando");
  }

  @Override
  public void emitirSom() {
    System.out.println("Pato está emitindo som");
  }
}