// Adaptador para Stripe
public class AdaptadorStripe implements ProcessadorPagamento {
  private final APIStripe apiStripe;

  public AdaptadorStripe() {
    this.apiStripe = new APIStripe();
  }

  @Override
  public boolean processarPagamento(double valor, String moeda, String infoCliente) {
    // Converte o valor para centavos, como o Stripe espera
    int valorEmCentavos = (int) (valor * 100);
    return apiStripe.criarCobranca(infoCliente, valorEmCentavos, moeda);
  }

  @Override
  public StatusPagamento verificarStatus(String idTransacao) {
    String statusStripe = apiStripe.recuperarStatusCobranca(idTransacao);

    // Converte o status específico do Stripe para o status padronizado
    switch (statusStripe) {
      case "succeeded": return StatusPagamento.CONCLUIDO;
      case "pending": return StatusPagamento.PENDENTE;
      case "failed": return StatusPagamento.FALHA;
      case "refunded": return StatusPagamento.REEMBOLSADO;
      default: return StatusPagamento.PENDENTE;
    }
  }

  @Override
  public boolean reembolsarPagamento(String idTransacao) {
    return apiStripe.emitirReembolso(idTransacao);
  }
}