import java.util.ArrayList;
import java.util.List;

public class MainPagamento {
    public static void main(String[] args) {
        double valorCompra = 1000.00;

        List<Pagamento> formasPagamento = new ArrayList<>();
        formasPagamento.add(new CartaoCredito());
        formasPagamento.add(new Boleto());
        formasPagamento.add(new Pix());

        System.out.println("=== PROCESSAMENTO POLIMÓRFICO DE PAGAMENTOS ===");
        for (Pagamento pagamento : formasPagamento) {
            pagamento.processar(valorCompra);
        }
    }
}
