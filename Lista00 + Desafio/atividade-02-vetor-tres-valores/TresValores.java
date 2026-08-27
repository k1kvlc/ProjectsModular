import java.util.Scanner;

/**
 * Atividade 2 - Três valores em um vetor
 * Lê x, y e z, guarda em um vetor e calcula:
 *  - o maior e o menor dentre os três;
 *  - se x está dentro ou fora do intervalo [y, z];
 *  - se x é divisível por y e por z.
 */
public class TresValores {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] valores = new int[3];

        System.out.print("Digite x: ");
        valores[0] = sc.nextInt();
        System.out.print("Digite y: ");
        valores[1] = sc.nextInt();
        System.out.print("Digite z: ");
        valores[2] = sc.nextInt();

        int x = valores[0];
        int y = valores[1];
        int z = valores[2];

        // Maior e menor dentre os três (percorrendo o vetor)
        int maior = valores[0];
        int menor = valores[0];
        for (int i = 1; i < valores.length; i++) {
            if (valores[i] > maior) {
                maior = valores[i];
            }
            if (valores[i] < menor) {
                menor = valores[i];
            }
        }
        System.out.println("Maior: " + maior);
        System.out.println("Menor: " + menor);

        // Intervalo [y, z] - os limites são aceitos em qualquer ordem
        int inicio = Math.min(y, z);
        int fim = Math.max(y, z);
        boolean dentro = x >= inicio && x <= fim;
        System.out.println(x + " está dentro do intervalo [" + y + ", " + z + "]? " + (dentro ? "Sim" : "Não"));
        System.out.println(x + " está fora do intervalo [" + y + ", " + z + "]? " + (dentro ? "Não" : "Sim"));

        // Divisibilidade
        System.out.println(x + " é divisível por " + y + "? " + testarDivisivel(x, y));
        System.out.println(x + " é divisível por " + z + "? " + testarDivisivel(x, z));
        boolean porAmbos = y != 0 && z != 0 && x % y == 0 && x % z == 0;
        System.out.println(x + " é divisível por " + y + " e por " + z + "? " + (porAmbos ? "Sim" : "Não"));

        sc.close();
    }

    /** Devolve "Sim"/"Não", tratando divisão por zero. */
    static String testarDivisivel(int a, int b) {
        if (b == 0) {
            return "Indefinido (divisão por zero)";
        }
        return (a % b == 0) ? "Sim" : "Não";
    }
}
