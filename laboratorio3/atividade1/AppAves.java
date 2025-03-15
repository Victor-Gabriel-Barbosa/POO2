public class AppAves {
  public static void main(String[] args) {
    System.out.println("=== Teste Adapter Pato ===");
    Pato pato = new Pato();
    PatoAdapter patoAdapter = new PatoAdapter(pato);
    patoAdapter.voar();
    patoAdapter.emitirSom();

    System.out.println("=== Teste Adapter Pato Doméstico ===");
    PatoDomestico patoDomestico = new PatoDomestico();
    PatoDomesticoAdapter patoDomesticoAdapter = new PatoDomesticoAdapter(patoDomestico);
    patoDomesticoAdapter.voar();
    patoDomesticoAdapter.emitirSom();

    System.out.println("=== Teste Adapter Pavão ===");
    Pavao pavao = new Pavao();
    PavaoAdapter pavaoAdapter = new PavaoAdapter(pavao);
    pavaoAdapter.voar();
    pavaoAdapter.emitirSom();

    System.out.println("=== Teste Adapter Pavão Azul ===");
    PavaoAzul pavaoAzul = new PavaoAzul();
    PavaoAzulAdapter pavaoAzulAdapter = new PavaoAzulAdapter(pavaoAzul);
    pavaoAzulAdapter.voar();
    pavaoAzulAdapter.emitirSom();
  }
}