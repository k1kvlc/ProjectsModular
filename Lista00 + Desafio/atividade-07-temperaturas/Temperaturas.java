import java.util.Scanner;

/**
 * Atividade 7 - Temperaturas médias do ano
 * Lê a temperatura média de cada mês, guarda em um vetor e mostra a maior e a
 * menor temperatura com o nome do mês por extenso (empates desconsiderados:
 * vale a primeira ocorrência).
 */
public class Temperaturas {

    static final String[] MESES = {
        "janeiro", "fevereiro", "março", "abril", "maio", "junho",
        "julho", "agosto", "setembro", "outubro", "novembro", "dezembro"
    };

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double[] temperaturas = new double[MESES.length];

        for (int i = 0; i < MESES.length; i++) {
            System.out.print("Temperatura média de " + MESES[i] + ": ");
            temperaturas[i] = lerDouble(sc);
        }

        int mesMaior = 0;
        int mesMenor = 0;
        for (int i = 1; i < temperaturas.length; i++) {
            if (temperaturas[i] > temperaturas[mesMaior]) {
                mesMaior = i;
            }
            if (temperaturas[i] < temperaturas[mesMenor]) {
                mesMenor = i;
            }
        }

        System.out.println();
        System.out.printf("Maior temperatura: %.1f graus em %s%n", temperaturas[mesMaior], MESES[mesMaior]);
        System.out.printf("Menor temperatura: %.1f graus em %s%n", temperaturas[mesMenor], MESES[mesMenor]);

        sc.close();
    }

    /** Lê um número decimal aceitando ponto ou vírgula como separador. */
    static double lerDouble(Scanner sc) {
        return Double.parseDouble(sc.next().replace(',', '.'));
    }
}
