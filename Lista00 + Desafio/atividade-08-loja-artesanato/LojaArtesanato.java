import java.util.Scanner;

/**
 * Atividade 8 - Loja de artesanato
 * Dez objetos: o valor unitário fica em um vetor e a quantidade vendida em
 * outro, na mesma posição. Mostra o relatório de vendas, o total geral, a
 * comissão do vendedor (5% das vendas, além do salário fixo de R$ 545,00) e
 * o objeto mais vendido com sua posição no vetor.
 */
public class LojaArtesanato {

    static final int QTD_OBJETOS = 10;
    static final double SALARIO_FIXO = 545.00;
    static final double PERCENTUAL_COMISSAO = 0.05;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double[] precos = new double[QTD_OBJETOS];
        int[] quantidades = new int[QTD_OBJETOS];

        for (int i = 0; i < QTD_OBJETOS; i++) {
            System.out.print("Objeto " + (i + 1) + " - valor unitário (R$): ");
            precos[i] = lerDouble(sc);
            System.out.print("Objeto " + (i + 1) + " - quantidade vendida: ");
            quantidades[i] = sc.nextInt();
        }

        System.out.println();
        System.out.println("RELATÓRIO DE VENDAS");
        System.out.printf("%-8s %-12s %-16s %-16s%n", "Objeto", "Quantidade", "Valor unitário", "Valor total");

        double totalGeral = 0;
        int posicaoMaisVendido = 0;
        for (int i = 0; i < QTD_OBJETOS; i++) {
            double totalObjeto = precos[i] * quantidades[i];
            totalGeral += totalObjeto;
            System.out.printf("%-8d %-12d R$ %-13.2f R$ %-13.2f%n", i + 1, quantidades[i], precos[i], totalObjeto);

            if (quantidades[i] > quantidades[posicaoMaisVendido]) {
                posicaoMaisVendido = i;
            }
        }

        double comissao = totalGeral * PERCENTUAL_COMISSAO;
        System.out.println();
        System.out.printf("Valor geral das vendas: R$ %.2f%n", totalGeral);
        System.out.printf("Comissão do vendedor (5%%): R$ %.2f%n", comissao);
        System.out.printf("Salário do mês (R$ %.2f fixo + comissão): R$ %.2f%n", SALARIO_FIXO, SALARIO_FIXO + comissao);

        System.out.println();
        System.out.printf("Objeto mais vendido: posição %d do vetor (índice %d) - valor unitário R$ %.2f, %d unidades%n",
                posicaoMaisVendido + 1, posicaoMaisVendido, precos[posicaoMaisVendido], quantidades[posicaoMaisVendido]);

        sc.close();
    }

    /** Lê um número decimal aceitando ponto ou vírgula como separador. */
    static double lerDouble(Scanner sc) {
        return Double.parseDouble(sc.next().replace(',', '.'));
    }
}
