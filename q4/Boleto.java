public class Boleto extends Pagamento {
    private static final double DESCONTO_PERCENTUAL = 0.10; // 10% de desconto

    @Override
    public void processar(double valor) {
        double desconto = valor * DESCONTO_PERCENTUAL;
        double valorTotal = valor - desconto;
        System.out.printf("Boleto Bancário   | Valor: R$ %.2f | Desconto: R$ %.2f | Total: R$ %.2f%n",
                valor, desconto, valorTotal);
    }
}