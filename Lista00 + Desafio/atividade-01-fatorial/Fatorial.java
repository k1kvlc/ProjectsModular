import java.util.Scanner;

/**
 * Atividade 1 - Fatorial
 * Lê um valor inteiro x e calcula x! = x * (x-1) * ... * 2 * 1.
 */
public class Fatorial {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Digite um valor inteiro x: ");
        int x = sc.nextInt();

        if (x < 0) {
            System.out.println("Não existe fatorial de número negativo.");
        } else if (x > 20) {
            // 21! já ultrapassa o limite do tipo long
            System.out.println("Valor muito grande: o fatorial de " + x + " não cabe em um long (máximo: 20).");
        } else if (x <= 1) {
            System.out.println(x + "! = 1");
        } else {
            System.out.println(x + "! = " + montarExpressao(x) + " = " + calcularFatorial(x));
        }

        sc.close();
    }

    /** Calcula x! de forma iterativa. 0! e 1! valem 1. */
    static long calcularFatorial(int x) {
        long resultado = 1;
        for (int i = 2; i <= x; i++) {
            resultado *= i;
        }
        return resultado;
    }

    /** Monta o texto "x * (x-1) * ... * 1" para mostrar o cálculo. */
    static String montarExpressao(int x) {
        StringBuilder sb = new StringBuilder();
        for (int i = x; i >= 1; i--) {
            sb.append(i);
            if (i > 1) {
                sb.append(" * ");
            }
        }
        return sb.toString();
    }
}
