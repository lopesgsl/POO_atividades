import java.util.Scanner;

public class q5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Digite um número real (double): ");
        while (!sc.hasNextDouble()) {
            System.out.print("Entrada inválida. Digite um número real: ");
            sc.next();
        }
        double valor = sc.nextDouble();

        // Exibe com 2 casas decimais usando printf
        System.out.printf("Valor com 2 casas decimais: %.2f%n", valor);

        sc.close();
    }
}
