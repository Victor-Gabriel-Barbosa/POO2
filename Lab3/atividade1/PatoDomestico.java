public class PatoDomestico extends Pato {/*...*/}

class PatoDomesticoAdapter implements Ave {
  private final PatoDomestico pato;

  public PatoDomesticoAdapter(PatoDomestico pato) {
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