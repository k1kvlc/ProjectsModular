import java.util.Scanner;

/**
 * Atividade 9 - Pares e ímpares
 * Lê 6 números inteiros e mostra os pares (com posição e soma) e os ímpares
 * (com posição e quantidade). As posições começam em 1, como no exemplo do
 * enunciado.
 */
public class ParesImpares {

    static final int QUANTIDADE = 6;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] numeros = new int[QUANTIDADE];

        System.out.println("Digite " + QUANTIDADE + " números inteiros:");
        for (int i = 0; i < QUANTIDADE; i++) {
            numeros[i] = sc.nextInt();
        }

        System.out.println();
        System.out.println("RELATÓRIO");

        System.out.println("Os números pares são:");
        int somaPares = 0;
        for (int i = 0; i < QUANTIDADE; i++) {
            if (numeros[i] % 2 == 0) {
                System.out.println("número " + numeros[i] + " na posição " + (i + 1));
                somaPares += numeros[i];
            }
        }
        System.out.println("Soma dos pares = " + somaPares);

        System.out.println("Os números ímpares são:");
        int quantidadeImpares = 0;
        for (int i = 0; i < QUANTIDADE; i++) {
            if (numeros[i] % 2 != 0) {
                System.out.println("número " + numeros[i] + " na posição " + (i + 1));
                quantidadeImpares++;
            }
        }
        System.out.println("Quantidade de ímpares = " + quantidadeImpares);

        sc.close();
    }
}
