// Interface base para a pizza
public interface Pizza {
  String getDescricao();
  double getPreco();
}

// Implementa pizza com massa fina
class MassaFinaPizza implements Pizza {
  @Override
  public String getDescricao() {
    return "Pizza de Massa Fina";
  }

  @Override
  public double getPreco() {
    return 10.0;
  }
}

// Implementa pizza com massa espessa
class MassaEspessaPizza implements Pizza {
  @Override
  public String getDescricao() {
    return "Pizza de Massa Espessa";
  }

  @Override
  public double getPreco() {
    return 12.0;
  }
}

// Classe abstrata para os decoradores
abstract class ToppingDecorator implements Pizza {
  protected Pizza pizza;

  public ToppingDecorator(Pizza pizza) {
    this.pizza = pizza;
  }

  @Override
  public String getDescricao() {
    return pizza.getDescricao();
  }

  @Override
  public double getPreco() {
    return pizza.getPreco();
  }
}

// Decorador para queijo
class Queijo extends ToppingDecorator {
  public Queijo(Pizza pizza) {
    super(pizza);
  }

  @Override
  public String getDescricao() {
    return pizza.getDescricao() + ", Queijo";
  }

  @Override
  public double getPreco() {
    return pizza.getPreco() + 2.0;
  }
}

// Decorador para tomate
class Tomate extends ToppingDecorator {
  public Tomate(Pizza pizza) {
    super(pizza);
  }

  @Override
  public String getDescricao() {
    return pizza.getDescricao() + ", Tomate";
  }

  @Override
  public double getPreco() {
    return pizza.getPreco() + 1.5;
  }
}

// Decorador para ovo
class Ovo extends ToppingDecorator {
  public Ovo(Pizza pizza) {
    super(pizza);
  }

  @Override
  public String getDescricao() {
    return pizza.getDescricao() + ", Ovo";
  }

  @Override
  public double getPreco() {
    return pizza.getPreco() + 1.0;
  }
}