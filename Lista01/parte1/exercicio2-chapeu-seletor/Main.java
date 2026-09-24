import java.util.Scanner;

/**
 * Classe principal do Exercício 2: recebe os dados de alunos em um
 * loop e os classifica na casa correspondente. O programa só encerra
 * quando o usuário solicitar.
 */
public class Main {

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        boolean continuar = true;

        System.out.println("===== CHAPÉU SELETOR DE HOGWARTS =====");

        while (continuar) {
            System.out.println();
            System.out.print("Nome do aluno: ");
            String nome = entrada.next();
            System.out.print("Idade: ");
            int idade = entrada.nextInt();
            System.out.print("Coragem (0 a 10): ");
            int coragem = entrada.nextInt();
            System.out.print("Inteligência (0 a 10): ");
            int inteligencia = entrada.nextInt();
            System.out.print("Ambição (0 a 10): ");
            int ambicao = entrada.nextInt();
            System.out.print("Lealdade (0 a 10): ");
            int lealdade = entrada.nextInt();
            System.out.print("Estratégia (0 a 10): ");
            int estrategia = entrada.nextInt();
            System.out.print("Criatividade (0 a 10): ");
            int criatividade = entrada.nextInt();

            Aluno aluno = new Aluno(nome, idade, coragem, inteligencia,
                    ambicao, lealdade, estrategia, criatividade);
            aluno.calcularCasa();

            System.out.println();
            aluno.exibirInformacoes();

            System.out.println();
            System.out.print("Cadastrar outro aluno? (s/n): ");
            String resposta = entrada.next();
            if (!resposta.equalsIgnoreCase("s")) {
                continuar = false;
            }
        }

        System.out.println("Seleção encerrada.");
        entrada.close();
    }
}
