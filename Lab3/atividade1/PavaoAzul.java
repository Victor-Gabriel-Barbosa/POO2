public class PavaoAzul extends Pavao {{/*...*/}}

class PavaoAzulAdapter implements Ave {
  private final PavaoAzul pavao;

  public PavaoAzulAdapter(PavaoAzul pavao) {
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