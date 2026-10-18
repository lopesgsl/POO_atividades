public class Guerreiro extends Personagem {
    public Guerreiro(String nome) {
        super(nome);
    }

    @Override
    public void atacar() {
        System.out.println(getNome() + " desfere um golpe de espada devastador! [Dano Físico]");
    }
}
