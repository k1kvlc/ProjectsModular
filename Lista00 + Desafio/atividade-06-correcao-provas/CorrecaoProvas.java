import java.util.Scanner;

/**
 * Atividade 6 - Correção de provas de múltipla escolha
 * 8 questões (1 ponto cada) e 10 alunos. Lê o gabarito e, para cada aluno,
 * o número de matrícula e as 8 respostas. Mostra a nota de cada aluno e o
 * percentual de aprovação (nota mínima 6).
 */
public class CorrecaoProvas {

    static final int QUESTOES = 8;
    static final int ALUNOS = 10;
    static final int NOTA_MINIMA = 6;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] gabarito = new String[QUESTOES];
        System.out.println("Digite o gabarito (" + QUESTOES + " respostas separadas por espaço, ex.: A B C D E A B C):");
        for (int q = 0; q < QUESTOES; q++) {
            gabarito[q] = sc.next().toUpperCase();
        }

        int[] numeros = new int[ALUNOS];
        int[] notas = new int[ALUNOS];

        for (int a = 0; a < ALUNOS; a++) {
            System.out.print("Número do aluno " + (a + 1) + ": ");
            numeros[a] = sc.nextInt();

            System.out.print("Respostas do aluno (" + QUESTOES + " letras): ");
            int nota = 0;
            for (int q = 0; q < QUESTOES; q++) {
                String resposta = sc.next().toUpperCase();
                if (resposta.equals(gabarito[q])) {
                    nota++;
                }
            }
            notas[a] = nota;
        }

        System.out.println();
        System.out.println("Número   Nota");
        int aprovados = 0;
        for (int a = 0; a < ALUNOS; a++) {
            System.out.printf("%-8d %d%n", numeros[a], notas[a]);
            if (notas[a] >= NOTA_MINIMA) {
                aprovados++;
            }
        }

        double percentual = aprovados * 100.0 / ALUNOS;
        System.out.println();
        System.out.println("Aprovados (nota >= " + NOTA_MINIMA + "): " + aprovados + " de " + ALUNOS);
        System.out.printf("Percentual de aprovação: %.1f%%%n", percentual);

        sc.close();
    }
}
