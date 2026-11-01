package questao_05;

public class RelatorioFinanceiro implements Imprimivel, EnviavelPorEmail, DocumentoProcessavel {
    private String titulo;
    private String emailDestinoPadrao;

    public RelatorioFinanceiro(String titulo, String emailDestinoPadrao) {
        this.titulo = titulo;
        this.emailDestinoPadrao = emailDestinoPadrao;
    }

    @Override
    public void imprimir() {
        System.out.println("[Impressora] Imprimindo Relatório Financeiro: " + titulo);
    }

    @Override
    public void enviar(String email) {
        System.out.println("[E-mail] Enviando Relatório Financeiro '" + titulo + "' para: " + email);
    }

    @Override
    public void processar() {
        imprimir();
        enviar(emailDestinoPadrao);
    }
}