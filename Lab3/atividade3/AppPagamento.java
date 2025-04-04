// Classe principal para demonstração
public class AppPagamento {
  public static void main(String[] args) {
    // Cria os adaptadores para diferentes portais
    ProcessadorPagamento processadorPayPal = new AdaptadorPayPal();
    ProcessadorPagamento processadorStripe = new AdaptadorStripe();
    ProcessadorPagamento processadorPix = new AdaptadorPix();
    
    // Cria a loja online
    LojaOnline loja = new LojaOnline(processadorPayPal);
    
    // Processa pagamentos com diferentes portais
    loja.finalizarCompra(99.99, "USD", "cliente@exemplo.com");
    
    // Troca para Stripe
    loja.definirProcessadorPagamento(processadorStripe);
    loja.finalizarCompra(149.99, "EUR", "tok_visa_4242");
    
    // Troca para PIX
    loja.definirProcessadorPagamento(processadorPix);
    loja.finalizarCompra(499.99, "BRL", "11999999999");
  }
}