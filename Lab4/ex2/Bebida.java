// Interface para as bebidas
public interface Bebida {
  String getDescricao();
  double calculaCusto();
}

// Implementa bebida Espresso
class Espresso implements Bebida {
  @Override
  public String getDescricao() {
    return "Café Espresso";
  }

  @Override
  public double calculaCusto() {
    return 2.50;
  }
}

// Implementa bebida Decaf
class Decaf implements Bebida {
  @Override
  public String getDescricao() {
    return "Café Descafeinado";
  }

  @Override
  public double calculaCusto() {
    return 2.00;
  }
}

// Classe abstrata para os decoradores
abstract class ToppingDecorator implements Bebida {
  protected Bebida bebida;

  public ToppingDecorator(Bebida bebida) {
    this.bebida = bebida;
  }

  @Override
  public String getDescricao() {
    return bebida.getDescricao();
  }

  @Override
  public double calculaCusto() {
    return bebida.calculaCusto();
  }
}

// Decorador para Leite
class Leite extends ToppingDecorator {
  public Leite(Bebida bebida) {
    super(bebida);
  }

  @Override
  public String getDescricao() {
    return bebida.getDescricao() + ", Leite";
  }

  @Override
  public double calculaCusto() {
    return bebida.calculaCusto() + 0.50;
  }
}

// Decorador para Canela
class Canela extends ToppingDecorator {
  public Canela(Bebida bebida) {
    super(bebida);
  }

  @Override
  public String getDescricao() {
    return bebida.getDescricao() + ", Canela";
  }

  @Override
  public double calculaCusto() {
    return bebida.calculaCusto() + 0.30;
  }
}

// Decorador para Chocolate
class Chocolate extends ToppingDecorator {
  public Chocolate(Bebida bebida) {
    super(bebida);
  }

  @Override
  public String getDescricao() {
    return bebida.getDescricao() + ", Chocolate";
  }

  @Override
  public double calculaCusto() {
    return bebida.calculaCusto() + 0.70;
  }
}