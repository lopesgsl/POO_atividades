import java.util.ArrayList;
import java.util.List;

public class MainCombate {
    public static void main(String[] args) {
        List<Personagem> grupo = new ArrayList<>();
        grupo.add(new Guerreiro("Thorin"));
        grupo.add(new Mago("Gandalf"));
        grupo.add(new Arqueiro("Legolas"));

        System.out.println("=== TURNO DE COMBATE POLIMÓRFICO ===");
        for (Personagem p : grupo) {
            p.atacar();
        }
    }
}