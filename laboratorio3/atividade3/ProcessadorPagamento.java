// Interface que o cliente irá utilizar
public interface ProcessadorPagamento {
  boolean processarPagamento(double valor, String moeda, String infoCliente);
  StatusPagamento verificarStatus(String idTransacao);
  boolean reembolsarPagamento(String idTransacao);
}