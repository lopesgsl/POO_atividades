public class Arqueiro extends Personagem {
    public Arqueiro(String nome) {
        super(nome);
    }

    @Override
    public void atacar() {
        System.out.println(getNome() + " dispara uma flecha precisa a longa distância! [Dano Perfurante]");
    }
}
