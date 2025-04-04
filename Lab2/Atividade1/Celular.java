// Interface 'Celular' que define os métodos que um celular deverá ter
public interface Celular {
  void fazLigacao();
  void tiraFoto();
}

// Classe concreta 'GalaxyS8' que implementa a interface 'Celular'
class GalaxyS8 implements Celular {
  @Override
  public void fazLigacao() {
    System.out.println("Galaxy S8 fazendo ligação...");
  }

  @Override
  public void tiraFoto() {
    System.out.println("Galaxy S8 tirando foto...");
  }
}

// Classe concreta 'Galaxy20' que implementa a interface 'Celular'
class Galaxy20 implements Celular {
  @Override
  public void fazLigacao() {
    System.out.println("Galaxy 20 fazendo ligação...");
  }

  @Override
  public void tiraFoto() {
    System.out.println("Galaxy 20 tirando foto...");
  }
}

// Classe concreta 'IPhoneX' que implementa a interface 'Celular'
class IPhoneX implements Celular {
  @Override
  public void fazLigacao() {
    System.out.println("iPhone X fazendo ligação...");
  }

  @Override
  public void tiraFoto() {
    System.out.println("iPhone X tirando foto...");
  }
}

// Classe concreta 'IPhoneS' que implementa a interface 'Celular'
class IPhoneS implements Celular {
  @Override
  public void fazLigacao() {
    System.out.println("iPhone S fazendo ligação...");
  }

  @Override
  public void tiraFoto() {
    System.out.println("iPhone S tirando foto...");
  }
}