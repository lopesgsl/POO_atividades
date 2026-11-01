package questao_03;

public class Smartphone implements AparelhoTelefonico, NavegadorInternet, ReprodutorMusical {
    private String modelo;

    public Smartphone(String modelo) {
        this.modelo = modelo;
    }

    @Override
    public void ligar() {
        System.out.println("[" + modelo + " - Telefone] Realizando chamada telefônica...");
    }

    @Override
    public void atender() {
        System.out.println("[" + modelo + " - Telefone] Atendendo chamada recebida.");
    }

    @Override
    public void exibirPagina() {
        System.out.println("[" + modelo + " - Navegador] Exibindo página da web.");
    }

    @Override
    public void adicionarNovaAba() {
        System.out.println("[" + modelo + " - Navegador] Nova aba adicionada no navegador.");
    }

    @Override
    public void tocar() {
        System.out.println("[" + modelo + " - Música] Reproduzindo música...");
    }

    @Override
    public void pausar() {
        System.out.println("[" + modelo + " - Música] Música pausada.");
    }
}