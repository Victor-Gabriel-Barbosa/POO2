// Interface 'IVehicle' que define os métodos que um veículo deverá ter
public interface IVehicle {
  public void start();
  public void drive();
  public void stop();
}

// Classe concreta 'Corola' que implementa a interface 'IVehicle'
class Corola implements IVehicle {
  @Override
  public void start() {
    System.out.println("Iniciando o Corola");
  }

  @Override
  public void drive() {
    System.out.println("Dirigindo o Corola");
  }
  
  @Override
  public void stop() {
    System.out.println("Freando o Corola");
  }
}

// Classe concreta 'Hilux' que implementa a interface 'IVehicle'
class Hilux implements IVehicle {
  @Override
  public void start() {
    System.out.println("Iniciando o Hilux");
  }

  @Override
  public void drive() {
    System.out.println("Dirigindo o Hilux");
  }

  @Override
  public void stop() {
    System.out.println("Freando o Hilux");
  }
}

// Classe concreta 'Etios' que implementa a interface 'IVehicle'
class Etios implements IVehicle {
  @Override
  public void start() {
    System.out.println("Iniciando o Etios");
  }

  @Override
  public void drive() {
    System.out.println("Dirigindo o Etios");
  }
  
  @Override
  public void stop() {
    System.out.println("Freando o Etios");
  }
}

// Classe concreta 'City' que implementa a interface 'IVehicle'
class City implements IVehicle {
  @Override
  public void start() {
    System.out.println("Iniciando o City");
  }

  @Override
  public void drive() {
    System.out.println("Dirigindo o City");
  }

  @Override
  public void stop() {
    System.out.println("Freando City");
  }
}

// Classe concreta 'Civic' que implementa a interface 'IVehicle'
class Civic implements IVehicle {
  @Override
  public void start() {
    System.out.println("Iniciando o Civic");
  }

  @Override
  public void drive() {
    System.out.println("Dirigindo o Civic");
  }  

  @Override
  public void stop() {
    System.out.println("Freando o Civic");
  }
}

// Classe concreta 'Fit' que implementa a interface 'IVehicle'
class Fit implements IVehicle {
  @Override
  public void start() {
    System.out.println("Iniciando o Fit");
  }

  @Override
  public void drive() {
    System.out.println("Dirigindo o Fit");
  }

  @Override
  public void stop() {
    System.out.println("Freando o Fit");
  }
}