public class Pavao {
  public void canta() {
    System.out.println("Pavão emitindo som");
  }
}

class PavaoAdapter implements Ave {
  private Pavao pavao;

  public PavaoAdapter(Pavao pavao) {
    this.pavao = pavao; 
  }

  @Override
  public void voar() {
    System.out.println("Pavão não voa");
  }

  @Override
  public void emitirSom() {
    pavao.canta();
  }
}