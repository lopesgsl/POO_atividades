import java.util.Scanner;

public class q4 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int[] valores = new int[5];
		for (int i = 0; i < 5; i++) {
			int n;
			do {
				System.out.print("Digite o número " + (i + 1) + " (1-30): ");
				while (!sc.hasNextInt()) {
					System.out.print("Entrada inválida. Digite um inteiro entre 1 e 30: ");
					sc.next();
				}
				n = sc.nextInt();
				if (n < 1 || n > 30) {
					System.out.println("Número fora do intervalo. Tente novamente.");
				}
			} while (n < 1 || n > 30);
			valores[i] = n;
		}

		System.out.println("\nGráfico de barras:");
		for (int v : valores) {
			// imprime v asteriscos em uma linha
			for (int j = 0; j < v; j++) {
				System.out.print('*');
			}
			System.out.println();
		}

		sc.close();
	}

}
