public class CartaoCredito extends Pagamento {
    private static final double TAXA_PERCENTUAL = 0.05; // 5% de taxa

    @Override
    public void processar(double valor) {
        double taxa = valor * TAXA_PERCENTUAL;
        double valorTotal = valor + taxa;
        System.out.printf("Cartão de Crédito | Valor: R$ %.2f | Taxa: R$ %.2f | Total: R$ %.2f%n",
                valor, taxa, valorTotal);
    }
}