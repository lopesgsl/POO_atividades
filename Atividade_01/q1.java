import java.util.Scanner;

public class q1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite a primeira nota: ");
        int nota1 = scanner.nextInt();

        System.out.print("Digite a segunda nota: ");
        int nota2 = scanner.nextInt(); 

        System.out.print("Digite a terceira nota: ");
        int nota3 = scanner.nextInt();

        double media = (nota1 + nota2 + nota3 * 2) / 4.0;

        if (media >= 7) {
            System.out.println("Aprovado. Sua media é "+ media );
        } else {
            System.out.println("Reprovado. Sua media é "+ media );
        }

        scanner.close();
    }
}