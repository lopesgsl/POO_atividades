public class Mago extends Personagem {
    public Mago(String nome) {
        super(nome);
    }

    @Override
    public void atacar() {
        System.out.println(getNome() + " conjura uma Bola de Fogo incandescente! [Dano Mágico]");
    }
}