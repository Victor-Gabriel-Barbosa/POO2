// Adaptador para PIX
public class AdaptadorPix implements ProcessadorPagamento {
  private final APIPix apiPix;
  
  public AdaptadorPix() {
    this.apiPix = new APIPix();
  }
  
  @Override
  public boolean processarPagamento(double valor, String moeda, String infoCliente) {
    if (!"BRL".equals(moeda)) {
      System.out.println("PIX só aceita pagamentos em BRL (Real Brasileiro)");
      return false;
    }
    
    String idTx = apiPix.gerarCobranca(valor, infoCliente);
    return idTx != null && !idTx.isEmpty();
  }
  
  @Override
  public StatusPagamento verificarStatus(String idTransacao) {
    int codigoStatus = apiPix.verificarPagamento(idTransacao);
    
    // Converte o código de status do PIX para o status padronizado
    switch (codigoStatus) {
      case 1: return StatusPagamento.CONCLUIDO;
      case 0: return StatusPagamento.PENDENTE;
      case -1: return StatusPagamento.FALHA;
      case 2: return StatusPagamento.REEMBOLSADO;
      default: return StatusPagamento.PENDENTE;
    }
  }
  
  @Override
  public boolean reembolsarPagamento(String idTransacao) {
    return apiPix.estornarPagamento(idTransacao);
  }
}