import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.format.ResolverStyle;
import java.util.Scanner;

/**
 * Prática 1 (parte 2) - Sistema de Cadastro de Bruxos de Hogwarts.
 * Cadastra no máximo 10 alunos em um vetor, com menu para listar,
 * filtrar por casa, por maioridade e buscar por sobrenome.
 */
public class Main {

    private static final int MAXIMO_ALUNOS = 10;
    private static final String[] CASAS = {"Grifinória", "Sonserina", "Corvinal", "Lufa-Lufa"};
    // ResolverStyle.STRICT rejeita datas inexistentes como 31/02/2010
    // (o padrão "uuuu" é o ano exigido pelo modo estrito)
    private static final DateTimeFormatter FORMATO_DATA =
            DateTimeFormatter.ofPattern("dd/MM/uuuu").withResolverStyle(ResolverStyle.STRICT);

    private static Scanner entrada = new Scanner(System.in);

    public static void main(String[] args) {
        // Vetor de alunos, como relembrado no enunciado
        Aluno[] alunos = new Aluno[MAXIMO_ALUNOS];
        int totalAlunos = 0;
        boolean executando = true;

        while (executando) {
            System.out.println();
            System.out.println("===== CADASTRO DE BRUXOS DE HOGWARTS =====");
            System.out.println("1 - Cadastrar aluno");
            System.out.println("2 - Listar todos os alunos");
            System.out.println("3 - Exibir alunos de uma casa");
            System.out.println("4 - Exibir alunos por casa");
            System.out.println("5 - Exibir alunos maiores de idade");
            System.out.println("6 - Exibir alunos menores de idade");
            System.out.println("7 - Buscar alunos por sobrenome");
            System.out.println("8 - Encerrar");
            System.out.print("Escolha uma opção: ");
            int opcao = lerInteiro();

            switch (opcao) {
                case 1:
                    totalAlunos = cadastrarAluno(alunos, totalAlunos);
                    break;
                case 2:
                    listarTodos(alunos, totalAlunos);
                    break;
                case 3:
                    exibirDeUmaCasa(alunos, totalAlunos);
                    break;
                case 4:
                    exibirPorCasa(alunos, totalAlunos);
                    break;
                case 5:
                    exibirPorMaioridade(alunos, totalAlunos, true);
                    break;
                case 6:
                    exibirPorMaioridade(alunos, totalAlunos, false);
                    break;
                case 7:
                    buscarPorSobrenome(alunos, totalAlunos);
                    break;
                case 8:
                    // Ao finalizar, exibe os dados de todos os cadastrados
                    System.out.println();
                    System.out.println("Encerrando. Alunos cadastrados:");
                    listarTodos(alunos, totalAlunos);
                    executando = false;
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        }
        entrada.close();
    }

    /** Opção 1 - Cadastra um aluno (até o máximo de 10). */
    private static int cadastrarAluno(Aluno[] alunos, int totalAlunos) {
        if (totalAlunos >= MAXIMO_ALUNOS) {
            System.out.println("Limite de " + MAXIMO_ALUNOS + " alunos atingido.");
            return totalAlunos;
        }

        System.out.print("Nome: ");
        String nome = entrada.next();
        System.out.print("Sobrenome (pode ser composto): ");
        entrada.nextLine(); // consome a quebra pendente
        String sobrenome = entrada.nextLine().trim();

        LocalDate dataNascimento = lerData();

        System.out.print("Coragem (0 a 10): ");
        int coragem = lerInteiro();
        System.out.print("Inteligência (0 a 10): ");
        int inteligencia = lerInteiro();
        System.out.print("Ambição (0 a 10): ");
        int ambicao = lerInteiro();
        System.out.print("Lealdade (0 a 10): ");
        int lealdade = lerInteiro();
        System.out.print("Estratégia (0 a 10): ");
        int estrategia = lerInteiro();
        System.out.print("Criatividade (0 a 10): ");
        int criatividade = lerInteiro();

        Aluno aluno = new Aluno(nome, sobrenome, dataNascimento, coragem,
                inteligencia, ambicao, lealdade, estrategia, criatividade);
        aluno.calcularCasa();
        aluno.gerarCodigoMatricula(totalAlunos + 1); // posição de cadastro no vetor

        alunos[totalAlunos] = aluno;
        totalAlunos++;

        System.out.println();
        System.out.println("Aluno cadastrado com sucesso!");
        aluno.exibirInformacoes();
        return totalAlunos;
    }

    /** Opção 2 - Lista todos os alunos cadastrados. */
    private static void listarTodos(Aluno[] alunos, int totalAlunos) {
        if (totalAlunos == 0) {
            System.out.println("Nenhum aluno cadastrado.");
            return;
        }
        for (int i = 0; i < totalAlunos; i++) {
            alunos[i].exibirInformacoes();
        }
    }

    /** Opção 3 - Exibe os alunos de uma casa escolhida, com o total. */
    private static void exibirDeUmaCasa(Aluno[] alunos, int totalAlunos) {
        System.out.print("Informe a casa: ");
        entrada.nextLine();
        String casa = entrada.nextLine().trim();

        int totalDaCasa = 0;
        for (int i = 0; i < totalAlunos; i++) {
            if (alunos[i].verificarCasa(casa)) {
                alunos[i].exibirInformacoes();
                totalDaCasa++;
            }
        }
        System.out.println("Total de alunos da casa: " + totalDaCasa);
    }

    /** Opção 4 - Exibe os alunos agrupados por casa. */
    private static void exibirPorCasa(Aluno[] alunos, int totalAlunos) {
        if (totalAlunos == 0) {
            System.out.println("Nenhum aluno cadastrado.");
            return;
        }
        for (String casa : CASAS) {
            System.out.println("--- " + casa.toUpperCase() + " ---");
            boolean temAluno = false;
            for (int i = 0; i < totalAlunos; i++) {
                if (alunos[i].verificarCasa(casa)) {
                    alunos[i].exibirInformacoes();
                    temAluno = true;
                }
            }
            if (!temAluno) {
                System.out.println("(nenhum aluno)");
            }
        }
    }

    /** Opções 5 e 6 - Exibe alunos maiores ou menores de idade (17 anos). */
    private static void exibirPorMaioridade(Aluno[] alunos, int totalAlunos, boolean maiores) {
        boolean encontrou = false;
        for (int i = 0; i < totalAlunos; i++) {
            if (alunos[i].verificarMaioridadeMagica() == maiores) {
                alunos[i].exibirInformacoes();
                encontrou = true;
            }
        }
        if (!encontrou) {
            System.out.println("Nenhum aluno " + (maiores ? "maior" : "menor") + " de idade.");
        }
    }

    /**
     * Opção 7 - Busca alunos por sobrenome. Para sobrenome composto,
     * basta o usuário informar uma das partes.
     */
    private static void buscarPorSobrenome(Aluno[] alunos, int totalAlunos) {
        System.out.print("Informe o sobrenome (ou parte dele): ");
        entrada.nextLine();
        String palavra = entrada.nextLine().trim();

        boolean encontrou = false;
        for (int i = 0; i < totalAlunos; i++) {
            if (alunos[i].verificarPresencaPalavra(palavra)) {
                alunos[i].exibirInformacoes();
                encontrou = true;
            }
        }
        if (!encontrou) {
            System.out.println("Nenhum aluno encontrado com esse sobrenome.");
        }
    }

    /** Lê a data de nascimento no formato dd/MM/aaaa, repetindo se for inválida. */
    private static LocalDate lerData() {
        while (true) {
            System.out.print("Data de nascimento (dd/mm/aaaa): ");
            String texto = entrada.next();
            try {
                LocalDate data = LocalDate.parse(texto, FORMATO_DATA);
                if (data.isAfter(LocalDate.now())) {
                    System.out.println("Data no futuro. Tente novamente.");
                    continue;
                }
                return data;
            } catch (DateTimeParseException e) {
                System.out.println("Data inválida. Tente novamente.");
            }
        }
    }

    /** Lê um inteiro, tratando entradas inválidas. */
    private static int lerInteiro() {
        while (!entrada.hasNextInt()) {
            entrada.next();
            System.out.print("Digite um número válido: ");
        }
        return entrada.nextInt();
    }
}
