import java.util.ArrayList;
import java.util.Scanner;

/**
 * Classe principal: cadastra os produtos da loja e apresenta o menu.
 * As ações são delegadas para as classes Produto, Item e Fatura —
 * o main apenas lê as opções do usuário.
 */
public class Main {

    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        // (a) Pelo menos 3 produtos, definidos pelo programa
        ArrayList<Produto> produtos = new ArrayList<>();
        produtos.add(new Produto("Caneta esferográfica", 1, 3.50));
        produtos.add(new Produto("Caderno 200 folhas", 2, 24.90));
        produtos.add(new Produto("Mochila escolar", 3, 149.90));

        Fatura fatura = new Fatura();
        boolean executando = true;

        while (executando) {
            System.out.println();
            System.out.println("===== LOJA DE SUPRIMENTOS =====");
            System.out.println("1 - Comprar");
            System.out.println("2 - Ver fatura");
            System.out.println("3 - Excluir item");
            System.out.println("4 - Alterar item");
            System.out.println("5 - Finalizar");
            System.out.print("Escolha uma opção: ");
            int opcao = lerInteiro();

            switch (opcao) {
                case 1 -> comprar(produtos, fatura);
                case 2 -> fatura.imprimirFatura();
                case 3 -> excluirItem(fatura);
                case 4 -> alterarItem(fatura);
                case 5 -> {
                    System.out.printf("Compra finalizada. Valor final: R$ %.2f%n",
                            fatura.getValorTotal());
                    executando = false;
                }
                default -> System.out.println("Opção inválida.");
            }
        }
        sc.close();
    }

    /** Opção 1 - Comprar: exibe os produtos e adiciona um item à fatura. */
    private static void comprar(ArrayList<Produto> produtos, Fatura fatura) {
        System.out.println("--- Produtos cadastrados ---");
        for (Produto p : produtos) {
            p.imprimir();
        }
        System.out.print("Informe o código do produto (0 para voltar): ");
        int codigo = lerInteiro();
        if (codigo == 0) {
            return; // volta sem realizar nenhuma ação
        }

        Produto escolhido = buscarProduto(produtos, codigo);
        if (escolhido == null) {
            System.out.println("Produto não encontrado.");
            return;
        }

        System.out.print("Informe a quantidade (0 para voltar): ");
        int quantidade = lerInteiro();
        if (quantidade <= 0) {
            return;
        }

        Item item = new Item(escolhido);
        item.realizarCompra(quantidade);
        fatura.incluirItem(item);
        System.out.printf("Item adicionado: %s x%d = R$ %.2f%n",
                escolhido.getNome(), quantidade, item.getValorTotal());
    }

    /** Opção 3 - Excluir item da fatura. */
    private static void excluirItem(Fatura fatura) {
        if (fatura.quantidadeItens() == 0) {
            System.out.println("A fatura está vazia.");
            return;
        }
        fatura.imprimirFatura();
        System.out.print("Número do item a excluir (0 para voltar): ");
        int posicao = lerInteiro();
        if (posicao == 0) {
            return;
        }
        if (fatura.excluirItem(posicao)) {
            System.out.println("Item excluído.");
        } else {
            System.out.println("Item inexistente.");
        }
    }

    /** Opção 4 - Alterar a quantidade comprada de um item. */
    private static void alterarItem(Fatura fatura) {
        if (fatura.quantidadeItens() == 0) {
            System.out.println("A fatura está vazia.");
            return;
        }
        fatura.imprimirFatura();
        System.out.print("Número do item a alterar (0 para voltar): ");
        int posicao = lerInteiro();
        if (posicao == 0) {
            return;
        }
        System.out.print("Nova quantidade (0 para voltar): ");
        int quantidade = lerInteiro();
        if (quantidade <= 0) {
            return;
        }
        if (fatura.alterarItem(posicao, quantidade)) {
            System.out.println("Item alterado.");
        } else {
            System.out.println("Item inexistente.");
        }
    }

    /** Busca um produto pelo código na lista de produtos cadastrados. */
    private static Produto buscarProduto(ArrayList<Produto> produtos, int codigo) {
        for (Produto p : produtos) {
            if (p.possuiCodigo(codigo)) {
                return p;
            }
        }
        return null;
    }

    /** Lê um inteiro, tratando entradas inválidas. */
    private static int lerInteiro() {
        while (!sc.hasNextInt()) {
            sc.next();
            System.out.print("Digite um número válido: ");
        }
        return sc.nextInt();
    }
}
