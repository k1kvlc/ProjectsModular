import java.util.Scanner;

/**
 * Classe principal do Exercício 1: recebe os dados da pessoa,
 * calcula o IMC e exibe o valor e a faixa de massa corporal.
 */
public class Main {

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);

        System.out.print("Nome: ");
        String nome = entrada.next();
        System.out.print("Sobrenome: ");
        String sobrenome = entrada.next();
        System.out.print("Idade: ");
        int idade = entrada.nextInt();
        System.out.print("Altura (m): ");
        double altura = Double.parseDouble(entrada.next().replace(',', '.'));
        System.out.print("Peso (kg): ");
        double peso = Double.parseDouble(entrada.next().replace(',', '.'));

        Pessoa pessoa = new Pessoa(nome, sobrenome, idade, altura, peso);
        pessoa.CalculaIMC();

        System.out.printf("%n%s %s, %d anos%n", pessoa.getNome(),
                pessoa.getSobrenome(), pessoa.getIdade());
        System.out.printf("IMC: %.2f%n", pessoa.getImc());
        System.out.println("Classificação: " + pessoa.InformaObesidade());

        entrada.close();
    }
}
