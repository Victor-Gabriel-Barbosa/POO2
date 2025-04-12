public interface FreteStrategy {
  // Calcula o valor do frete baseado no valor total da compra
  double calcular(double valorCompra);
  
  // Retorna o nome do serviço de frete
  String getNome();
}