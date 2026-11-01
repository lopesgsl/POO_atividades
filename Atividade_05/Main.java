import java.util.ArrayList;
import java.util.List;
import questao_03.Smartphone;
import questao_04.OperacaoMatematica;
import questao_05.Contrato;
import questao_05.DocumentoProcessavel;
import questao_05.EnviavelPorEmail;
import questao_05.Imprimivel;
import questao_05.RelatorioFinanceiro;

public class Main {
    public static void main(String[] args) {
        // =========================================================================
        // QUESTÃO 3: Smartphone implementando múltiplas interfaces
        // =========================================================================
        System.out.println("====================================================");
        System.out.println("QUESTÃO 03 - SMARTPHONE (MÚLTIPLAS INTERFACES)");
        System.out.println("====================================================");
        Smartphone meuSmartphone = new Smartphone("Galaxy S24");

        meuSmartphone.ligar();
        meuSmartphone.atender();
        meuSmartphone.adicionarNovaAba();
        meuSmartphone.exibirPagina();
        meuSmartphone.tocar();
        meuSmartphone.pausar();

        // =========================================================================
        // QUESTÃO 4: Interface Funcional OperacaoMatematica com Expressões Lambda
        // =========================================================================
        System.out.println("\n====================================================");
        System.out.println("QUESTÃO 04 - OPERAÇÕES MATEMÁTICAS (LAMBDAS)");
        System.out.println("====================================================");
        OperacaoMatematica soma = (a, b) -> a + b;
        OperacaoMatematica subtracao = (a, b) -> a - b;
        OperacaoMatematica multiplicacao = (a, b) -> a * b;
        OperacaoMatematica divisao = (a, b) -> {
            if (b == 0) {
                throw new ArithmeticException("Divisão por zero não é permitida.");
            }
            return a / b;
        };

        double num1 = 20.0;
        double num2 = 4.0;

        System.out.println("Valores de entrada: a = " + num1 + ", b = " + num2);
        System.out.println("Soma:          " + num1 + " + " + num2 + " = " + soma.executar(num1, num2));
        System.out.println("Subtração:     " + num1 + " - " + num2 + " = " + subtracao.executar(num1, num2));
        System.out.println("Multiplicação: " + num1 + " * " + num2 + " = " + multiplicacao.executar(num1, num2));
        System.out.println("Divisão:       " + num1 + " / " + num2 + " = " + divisao.executar(num1, num2));

        // =========================================================================
        // QUESTÃO 5: Imprimivel e EnviavelPorEmail (Polimorfismo e instanceof)
        // =========================================================================
        System.out.println("\n====================================================");
        System.out.println("QUESTÃO 05 - PROCESSAMENTO DE DOCUMENTOS");
        System.out.println("====================================================");
        RelatorioFinanceiro relatorioQ3 = new RelatorioFinanceiro("Balanço 3º Trimestre", "diretoria@empresa.com");
        Contrato contratoPrestacao = new Contrato("Contrato #2026-089 - Prestação de Serviços");
        RelatorioFinanceiro relatorioAnual = new RelatorioFinanceiro("Fechamento Anual 2026", "conselho@empresa.com");

        System.out.println("--- Abordagem 1: Design Polimórfico (Sem verificações explícitas) ---");
        List<DocumentoProcessavel> documentosPolimorficos = List.of(
                relatorioQ3,
                contratoPrestacao,
                relatorioAnual
        );

        for (DocumentoProcessavel doc : documentosPolimorficos) {
            doc.processar();
            System.out.println();
        }

        System.out.println("--- Abordagem 2: Processando lista de Imprimivel com instanceof ---");
        List<Imprimivel> documentos = new ArrayList<>();
        documentos.add(relatorioQ3);
        documentos.add(contratoPrestacao);
        documentos.add(relatorioAnual);

        for (Imprimivel doc : documentos) {
            doc.imprimir();
            if (doc instanceof EnviavelPorEmail enviavel) {
                enviavel.enviar("arquivo.digital@empresa.com");
            }
            System.out.println();
        }
    }
}