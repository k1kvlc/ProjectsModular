import java.util.Scanner;

/**
 * Desafio - Mata-mata
 * Dezesseis equipes (A a P) disputam 15 jogos eliminatórios:
 *   oitavas (jogos 1 a 8), quartas (9 a 12), semifinais (13 e 14) e final (15).
 * Lê o resultado dos 15 jogos, na ordem, e imprime a letra da equipe campeã.
 *
 * Cada linha da entrada pode estar no formato "M N" ou "jogo M N" (como nos
 * exemplos do enunciado). M são os gols da equipe à esquerda na tabela e N os
 * gols da equipe à direita. Não há empates.
 */
public class MataMata {

    static final int EQUIPES = 16;
    static final int GOLS_MAXIMO = 20;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Equipes na ordem da tabela: A, B, C, ..., P
        char[] equipes = new char[EQUIPES];
        for (int i = 0; i < EQUIPES; i++) {
            equipes[i] = (char) ('A' + i);
        }

        int numeroJogo = 1;

        // Cada rodada reduz as equipes pela metade: 16 -> 8 -> 4 -> 2 -> 1.
        // Em cada rodada, a equipe na posição 2*i enfrenta a da posição 2*i + 1,
        // o que reproduz exatamente a numeração dos jogos da tabela.
        while (equipes.length > 1) {
            char[] vencedores = new char[equipes.length / 2];

            for (int i = 0; i < vencedores.length; i++) {
                int[] placar = lerPlacar(sc, numeroJogo);
                int m = placar[0]; // gols da equipe à esquerda
                int n = placar[1]; // gols da equipe à direita

                vencedores[i] = (m > n) ? equipes[2 * i] : equipes[2 * i + 1];
                numeroJogo++;
            }

            equipes = vencedores;
        }

        System.out.println(equipes[0]);
        sc.close();
    }

    /** Lê a linha com o placar de um jogo e devolve {M, N}, validando a entrada. */
    static int[] lerPlacar(Scanner sc, int numeroJogo) {
        String linha = "";
        while (linha.trim().isEmpty()) {
            if (!sc.hasNextLine()) {
                System.err.println("Entrada incompleta: faltou o resultado do jogo " + numeroJogo + ".");
                System.exit(1);
            }
            linha = sc.nextLine();
        }

        String[] partes = linha.trim().split("\\s+");
        int m;
        int n;
        if (partes.length == 2) {          // formato "M N"
            m = Integer.parseInt(partes[0]);
            n = Integer.parseInt(partes[1]);
        } else if (partes.length == 3) {   // formato "jogo M N"
            m = Integer.parseInt(partes[1]);
            n = Integer.parseInt(partes[2]);
        } else {
            System.err.println("Formato inválido no jogo " + numeroJogo + ": \"" + linha + "\"");
            System.exit(1);
            return null;
        }

        if (m < 0 || m > GOLS_MAXIMO || n < 0 || n > GOLS_MAXIMO || m == n) {
            System.err.println("Placar inválido no jogo " + numeroJogo + ": " + m + " x " + n
                    + " (gols entre 0 e " + GOLS_MAXIMO + ", sem empate).");
            System.exit(1);
        }

        return new int[] {m, n};
    }
}
