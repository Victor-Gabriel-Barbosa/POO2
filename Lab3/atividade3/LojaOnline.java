// Cliente que utiliza o sistema de pagamento
public class LojaOnline {
  private ProcessadorPagamento processadorPagamento;
  
  public LojaOnline(ProcessadorPagamento processadorPagamento) {
    this.processadorPagamento = processadorPagamento;
  }
  
  // Permite alterar o processador de pagamento
  public void definirProcessadorPagamento(ProcessadorPagamento processadorPagamento) {
    this.processadorPagamento = processadorPagamento;
  }
  
  public void finalizarCompra(double valor, String moeda, String infoCliente) {
    System.out.println("\nProcessando pagamento de " + valor + " " + moeda);
    boolean sucesso = processadorPagamento.processarPagamento(valor, moeda, infoCliente);
    
    if (sucesso) System.out.println("Pagamento processado com sucesso!");
    else System.out.println("Falha ao processar pagamento.");
  }
}