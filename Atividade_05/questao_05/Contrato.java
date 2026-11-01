package questao_05;

public class Contrato implements Imprimivel, DocumentoProcessavel {
    private String identificacao;

    public Contrato(String identificacao) {
        this.identificacao = identificacao;
    }

    @Override
    public void imprimir() {
        System.out.println("[Impressora] Imprimindo Contrato: " + identificacao);
    }

    @Override
    public void processar() {
        imprimir();
    }
}