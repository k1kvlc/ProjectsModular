import java.util.Scanner;

/**
 * Atividade 4 - União de vetores
 * Lê um vetor X com n elementos e um vetor Y com m elementos e monta o vetor
 * união Z. Elementos repetidos entram apenas uma vez em Z.
 */
public class Uniao {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Tamanho do vetor X (n): ");
        int n = sc.nextInt();
        System.out.print("Tamanho do vetor Y (m): ");
        int m = sc.nextInt();

        int[] x = new int[n];
        int[] y = new int[m];

        System.out.println("Digite os " + n + " elementos de X:");
        for (int i = 0; i < n; i++) {
            x[i] = sc.nextInt();
        }
        System.out.println("Digite os " + m + " elementos de Y:");
        for (int i = 0; i < m; i++) {
            y[i] = sc.nextInt();
        }

        // Z tem no máximo n + m elementos; 'tamanho' controla quantas posições foram usadas
        int[] z = new int[n + m];
        int tamanho = 0;
        tamanho = adicionarSemRepetir(z, tamanho, x);
        tamanho = adicionarSemRepetir(z, tamanho, y);

        System.out.print("Vetor união Z: ");
        for (int i = 0; i < tamanho; i++) {
            System.out.print(z[i]);
            if (i < tamanho - 1) {
                System.out.print(" ");
            }
        }
        System.out.println();
        System.out.println("Total de elementos em Z: " + tamanho);

        sc.close();
    }

    /** Copia para z os elementos de 'origem' que ainda não estão em z. Devolve o novo tamanho. */
    static int adicionarSemRepetir(int[] z, int tamanho, int[] origem) {
        for (int valor : origem) {
            if (!contem(z, tamanho, valor)) {
                z[tamanho] = valor;
                tamanho++;
            }
        }
        return tamanho;
    }

    /** Verifica se valor está entre as primeiras 'tamanho' posições do vetor. */
    static boolean contem(int[] vetor, int tamanho, int valor) {
        for (int i = 0; i < tamanho; i++) {
            if (vetor[i] == valor) {
                return true;
            }
        }
        return false;
    }
}
