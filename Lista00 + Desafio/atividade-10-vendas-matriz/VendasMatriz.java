import java.util.Scanner;

/**
 * Atividade 10 - Vendas em matriz 12 x 4
 * Cada linha é um mês do ano e cada coluna uma semana do mês.
 * Mostra o total vendido em cada mês (nome por extenso), o total de cada
 * semana ao longo do ano e o total geral do ano.
 */
public class VendasMatriz {

    static final int MESES = 12;
    static final int SEMANAS = 4;
    static final String[] NOMES_MESES = {
        "janeiro", "fevereiro", "março", "abril", "maio", "junho",
        "julho", "agosto", "setembro", "outubro", "novembro", "dezembro"
    };

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double[][] vendas = new double[MESES][SEMANAS];

        // Preenchimento da matriz
        for (int mes = 0; mes < MESES; mes++) {
            for (int semana = 0; semana < SEMANAS; semana++) {
                System.out.print("Vendas de " + NOMES_MESES[mes] + " - semana " + (semana + 1) + " (R$): ");
                vendas[mes][semana] = lerDouble(sc);
            }
        }

        // Total por mês (soma de cada linha)
        System.out.println();
        System.out.println("Total vendido por mês:");
        double totalAno = 0;
        for (int mes = 0; mes < MESES; mes++) {
            double totalMes = 0;
            for (int semana = 0; semana < SEMANAS; semana++) {
                totalMes += vendas[mes][semana];
            }
            totalAno += totalMes;
            System.out.printf("%-10s R$ %12.2f%n", NOMES_MESES[mes], totalMes);
        }

        // Total por semana (soma de cada coluna)
        System.out.println();
        System.out.println("Total vendido por semana durante o ano:");
        for (int semana = 0; semana < SEMANAS; semana++) {
            double totalSemana = 0;
            for (int mes = 0; mes < MESES; mes++) {
                totalSemana += vendas[mes][semana];
            }
            System.out.printf("Semana %d   R$ %12.2f%n", semana + 1, totalSemana);
        }

        // Total geral
        System.out.println();
        System.out.printf("Total vendido no ano: R$ %.2f%n", totalAno);

        sc.close();
    }

    /** Lê um número decimal aceitando ponto ou vírgula como separador. */
    static double lerDouble(Scanner sc) {
        return Double.parseDouble(sc.next().replace(',', '.'));
    }
}
