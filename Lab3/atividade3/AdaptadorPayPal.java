// Adaptador para PayPal
public class AdaptadorPayPal implements ProcessadorPagamento {
  private APIPayPal apiPayPal;

  public AdaptadorPayPal() {
    this.apiPayPal = new APIPayPal();
  }

  @Override
  public boolean processarPagamento(double valor, String moeda, String infoCliente) {
    String idTransacao = apiPayPal.executarPagamento(valor, moeda, infoCliente);
    return idTransacao != null && !idTransacao.isEmpty();
  }

  @Override
  public StatusPagamento verificarStatus(String idTransacao) {
    String statusPayPal = apiPayPal.obterEstadoPagamento(idTransacao);

    // Converte o status específico do PayPal para o status padronizado
    switch (statusPayPal) {
      case "COMPLETED": return StatusPagamento.CONCLUIDO;
      case "PENDING": return StatusPagamento.PENDENTE;
      case "FAILED": return StatusPagamento.FALHA;
      case "REFUNDED": return StatusPagamento.REEMBOLSADO;
      default: return StatusPagamento.PENDENTE;
    }
  }

  @Override
  public boolean reembolsarPagamento(String idTransacao) {
    return apiPayPal.reverterPagamento(idTransacao, "Cliente solicitou reembolso");
  }
}