// API externa do Stripe
public class APIStripe {
  public boolean criarCobranca(String token, int valorEmCentavos, String moeda) {
    // Código que simula a comunicação com a API real do Stripe
    System.out.println("Stripe: Cobrando " + valorEmCentavos/100.0 + " " + moeda);
    return true;
  }
  
  public String recuperarStatusCobranca(String idCobranca) {
    // Verifica status no Stripe
    System.out.println("Stripe: Consultando cobrança " + idCobranca);
    return "succeeded"; // Simula resposta
  }
  
  public boolean emitirReembolso(String idCobranca) {
    // Realiza reembolso no Stripe
    System.out.println("Stripe: Reembolsando cobrança " + idCobranca);
    return true;
  }
}