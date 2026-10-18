public abstract class Personagem {
    private String nome;

    public Personagem(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public abstract void atacar();
}
