import java.util.Scanner;

/**
 * Atividade 3 - Interseção de vetores
 * Lê as matrículas de n alunos de Programação Modular e de n alunos de Cálculo
 * e imprime as matrículas dos alunos presentes nas duas disciplinas.
 */
public class Intersecao {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Quantidade de alunos em cada disciplina (n): ");
        int n = sc.nextInt();

        int[] progModular = new int[n];
        int[] calculo = new int[n];

        System.out.println("Digite as " + n + " matrículas de Programação Modular:");
        for (int i = 0; i < n; i++) {
            progModular[i] = sc.nextInt();
        }

        System.out.println("Digite as " + n + " matrículas de Cálculo:");
        for (int i = 0; i < n; i++) {
            calculo[i] = sc.nextInt();
        }

        // Interseção guardada em um terceiro vetor, sem repetições
        int[] intersecao = new int[n];
        int tamanho = 0;
        for (int i = 0; i < n; i++) {
            int matricula = progModular[i];
            if (contem(calculo, n, matricula) && !contem(intersecao, tamanho, matricula)) {
                intersecao[tamanho] = matricula;
                tamanho++;
            }
        }

        System.out.println("Alunos matriculados nas duas disciplinas:");
        if (tamanho == 0) {
            System.out.println("Nenhum aluno.");
        }
        for (int i = 0; i < tamanho; i++) {
            System.out.println(intersecao[i]);
        }

        sc.close();
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
