import java.util.Scanner;

/**
 * Atividade 5 - Pesquisa de características físicas da população
 * Para cada habitante lê: idade, sexo, cor dos olhos e cor dos cabelos.
 * A leitura termina quando a idade digitada for -1.
 * Mostra a maior idade, a menor idade e a quantidade de mulheres entre
 * 18 e 35 anos (inclusive) com olhos verdes e cabelos louros.
 */
public class Pesquisa {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int maiorIdade = 0;
        int menorIdade = 0;
        int totalHabitantes = 0;
        int mulheresPerfil = 0; // feminino, 18 a 35 anos, olhos verdes, cabelos louros

        System.out.println("Informe os dados de cada habitante (idade -1 encerra a pesquisa).");

        while (true) {
            // A idade é lida primeiro para permitir encerrar com -1
            System.out.print("Idade: ");
            int idade = sc.nextInt();
            if (idade == -1) {
                break;
            }

            System.out.print("Sexo (masculino/feminino): ");
            String sexo = sc.next().toLowerCase();
            System.out.print("Cor dos olhos (azuis/verdes/castanhos): ");
            String olhos = sc.next().toLowerCase();
            System.out.print("Cor dos cabelos (louros/castanhos/pretos): ");
            String cabelos = sc.next().toLowerCase();

            totalHabitantes++;
            if (totalHabitantes == 1 || idade > maiorIdade) {
                maiorIdade = idade;
            }
            if (totalHabitantes == 1 || idade < menorIdade) {
                menorIdade = idade;
            }

            boolean feminino = sexo.startsWith("f");          // aceita "f" ou "feminino"
            boolean faixaEtaria = idade >= 18 && idade <= 35;
            boolean olhosVerdes = olhos.startsWith("verde");   // aceita "verde" ou "verdes"
            boolean cabelosLouros = cabelos.startsWith("lo");  // aceita "louros" ou "loiros"

            if (feminino && faixaEtaria && olhosVerdes && cabelosLouros) {
                mulheresPerfil++;
            }
        }

        System.out.println();
        if (totalHabitantes == 0) {
            System.out.println("Nenhum habitante informado.");
        } else {
            System.out.println("Habitantes pesquisados: " + totalHabitantes);
            System.out.println("Maior idade: " + maiorIdade);
            System.out.println("Menor idade: " + menorIdade);
            System.out.println("Mulheres de 18 a 35 anos com olhos verdes e cabelos louros: " + mulheresPerfil);
        }

        sc.close();
    }
}
