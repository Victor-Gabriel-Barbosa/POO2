
public class AppPagamentoProxy {
  public static void main(String[] args) {
    // Testa o proxy ProcessadorPagamento

    // Caso 1: Usuário com permissão e valor válido
    ProcessadorPagamento proxyAdmin = new ProcessadorPagamentoProxy("ADMIN");
    System.out.println("\nCaso 1 - Admin com valor válido:");
    proxyAdmin.processarPagamento(500.0);

    // Caso 2: Usuário sem permissão
    ProcessadorPagamento proxyUsuario = new ProcessadorPagamentoProxy("USER");
    System.out.println("\nCaso 2 - Usuário sem permissão:");
    proxyUsuario.processarPagamento(100.0);

    // Caso 3: Valor inválido
    System.out.println("\nCaso 3 - Valor inválido:");
    proxyAdmin.processarPagamento(15000.0);
  }
}