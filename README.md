Resolução da Lista de Exercícios: Java e POO
1. Entrada e Saída de Dados (Scanner e printf)
A classe Scanner é a ferramenta utilizada em Java para capturar os dados digitados pelo usuário no terminal, utilizando o método nextDouble() especificamente para a leitura de números decimais. Para formatar a exibição desse valor na tela, utiliza-se o método System.out.printf com o especificador %.2f, que delimita a saída para exatamente duas casas decimais e realiza o arredondamento automático do número.

Java
import java.util.Scanner;
import java.util.Locale;

public class Exemplo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in).useLocale(Locale.US);

        System.out.print("Digite um valor: ");
        double numero = sc.nextDouble();

        System.out.printf("Valor formatado: %.2f%n", numero);

        sc.close();
    }
}
2. Correção do Código Contador.java
O código original apresentava três falhas principais que impediam o seu funcionamento correto. O primeiro erro estava na assinatura do método principal, que omitiu os colchetes obrigatórios do parâmetro String[] args. O segundo erro foi a falta do ponto e vírgula ao final da instrução de impressão no console. Por fim, o terceiro erro foi de lógica, pois a variável de controle do laço while não recebia nenhum incremento dentro do bloco, gerando um ciclo de repetição infinito que travava a execução do programa.

Java
import java.util.Scanner;

public class Contador {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int contador = 0;

        while (contador <= 5) {
            System.out.println("Contador: " + contador);
            contador++; // Incremento para evitar o loop infinito
        }

        sc.close();
    }
}