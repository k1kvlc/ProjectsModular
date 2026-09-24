import java.util.Scanner;

/**
 * Classe principal da Parte 2: os produtos agora ficam no Estoque
 * (HashMap código -> Produto) e a compra é integrada ao estoque:
 * verifica existência, verifica quantidade, reduz o estoque e só
 * então adiciona o item à fatura.
 */
public class Main {

    private static final int LIMITE_ESTOQUE_BAIXO = 5;
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        Estoque estoque = new Estoque();
        // Produtos iniciais definidos pelo programa
        estoque.adicionarProduto(new Produto("Caneta esferográfica", 1, 3.50, 100));
        estoque.adicionarProduto(new Produto("Caderno 200 folhas", 2, 24.90, 40));
        estoque.adicionarProduto(new Produto("Mochila escolar", 3, 149.90, 4));

        Fatura fatura = new Fatura();
        boolean executando = true;

        while (executando) {
            System.out.println();
            System.out.println("===== LOJA DE SUPRIMENTOS =====");
            System.out.println("1 - Comprar");
            System.out.println("2 - Ver fatura");
            System.out.println("3 - Excluir item");
            System.out.println("4 - Alterar item");
            System.out.println("5 - Consultar produto");
            System.out.println("6 - Adicionar produto ao estoque");
            System.out.println("7 - Remover produto");
            System.out.println("8 - Repor estoque");
            System.out.println("9 - Produtos com estoque baixo");
            System.out.println("0 - Finalizar");
            System.out.print("Escolha uma opção: ");
            int opcao = lerInteiro();

            switch (opcao) {
                case 1 -> comprar(estoque, fatura);
                case 2 -> fatura.imprimirFatura();
                case 3 -> excluirItem(fatura);
                case 4 -> alterarItem(fatura);
                case 5 -> consultarProduto(estoque);
                case 6 -> adicionarProduto(estoque);
                case 7 -> removerProduto(estoque);
                case 8 -> reporEstoque(estoque);
                case 9 -> estoque.listarEstoqueBaixo(LIMITE_ESTOQUE_BAIXO);
                case 0 -> {
                    System.out.printf("Compra finalizada. Valor final: R$ %.2f%n",
                            fatura.getValorTotal());
                    executando = false;
                }
                default -> System.out.println("Opção inválida.");
            }
        }
        sc.close();
    }

    /**
     * Opção 1 - Comprar, integrada ao estoque:
     * verifica se o produto existe, se há quantidade suficiente e,
     * caso exista, realiza a venda, reduz o estoque e inclui o item
     * na fatura.
     */
    private static void comprar(Estoque estoque, Fatura fatura) {
        System.out.println("--- Produtos disponíveis ---");
        estoque.listarProdutos();
        System.out.print("Informe o código do produto (0 para voltar): ");
        int codigo = lerInteiro();
        if (codigo == 0) {
            return; // volta sem realizar nenhuma ação
        }

        // 1) Verifica se o produto existe no estoque
        if (!estoque.verificarExistencia(codigo)) {
            System.out.println("Produto não encontrado no estoque.");
            return;
        }
        Produto produto = estoque.buscarProduto(codigo);

        System.out.print("Informe a quantidade (0 para voltar): ");
        int quantidade = lerInteiro();
        if (quantidade <= 0) {
            return;
        }

        // 2) Verifica se há quantidade suficiente
        if (!produto.possuiEstoque(quantidade)) {
            System.out.printf("Estoque insuficiente: há apenas %d un. de %s.%n",
                    produto.getQuantidadeEstoque(), produto.getNome());
            return;
        }

        // 3) Realiza a venda, reduz o estoque e adiciona o item na fatura
        produto.retirarEstoque(quantidade);
        Item item = new Item(produto);
        item.realizarCompra(quantidade);
        fatura.incluirItem(item);
        System.out.printf("Item adicionado: %s x%d = R$ %.2f%n",
                produto.getNome(), quantidade, item.getValorTotal());
    }

    /** Opção 3 - Excluir item da fatura (a quantidade volta ao estoque). */
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
        Item item = fatura.getItem(posicao);
        if (item == null) {
            System.out.println("Item inexistente.");
            return;
        }
        fatura.excluirItem(posicao);
        item.getProduto().adicionarEstoque(item.getQuantidade()); // devolve ao estoque
        System.out.println("Item excluído e estoque devolvido.");
    }

    /** Opção 4 - Alterar a quantidade de um item (ajustando o estoque). */
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
        Item item = fatura.getItem(posicao);
        if (item == null) {
            System.out.println("Item inexistente.");
            return;
        }
        System.out.print("Nova quantidade (0 para voltar): ");
        int novaQuantidade = lerInteiro();
        if (novaQuantidade <= 0) {
            return;
        }

        int diferenca = novaQuantidade - item.getQuantidade();
        Produto produto = item.getProduto();
        if (diferenca > 0) {
            // Aumentou a compra: retira a diferença do estoque, se houver
            if (!produto.retirarEstoque(diferenca)) {
                System.out.printf("Estoque insuficiente: há apenas %d un. disponíveis.%n",
                        produto.getQuantidadeEstoque());
                return;
            }
        } else if (diferenca < 0) {
            // Diminuiu a compra: devolve a diferença ao estoque
            produto.adicionarEstoque(-diferenca);
        }
        fatura.alterarItem(posicao, novaQuantidade);
        System.out.println("Item alterado.");
    }

    /** Opção 5 - Consultar produto: exibe todas as informações pelo código. */
    private static void consultarProduto(Estoque estoque) {
        System.out.print("Informe o código do produto (0 para voltar): ");
        int codigo = lerInteiro();
        if (codigo == 0) {
            return;
        }
        Produto produto = estoque.buscarProduto(codigo);
        if (produto == null) {
            System.out.println("Produto não encontrado.");
        } else {
            produto.imprimir();
        }
    }

    /** Opção 6 - Adicionar produto ao estoque (cadastrado pelo usuário). */
    private static void adicionarProduto(Estoque estoque) {
        System.out.print("Código do novo produto (0 para voltar): ");
        int codigo = lerInteiro();
        if (codigo == 0) {
            return;
        }
        System.out.print("Nome do produto: ");
        sc.nextLine(); // consome a quebra de linha pendente
        String nome = sc.nextLine().trim();
        System.out.print("Preço (R$): ");
        double preco = lerDouble();
        System.out.print("Quantidade inicial em estoque: ");
        int quantidade = lerInteiro();

        Produto novo = new Produto(nome, codigo, preco, quantidade);
        if (estoque.adicionarProduto(novo)) {
            System.out.println("Produto cadastrado no estoque.");
        } else {
            System.out.println("Já existe um produto com o código " + codigo + ".");
        }
    }

    /** Opção 7 - Remover produto do estoque através do código. */
    private static void removerProduto(Estoque estoque) {
        System.out.print("Código do produto a remover (0 para voltar): ");
        int codigo = lerInteiro();
        if (codigo == 0) {
            return;
        }
        if (estoque.removerProduto(codigo)) {
            System.out.println("Produto removido do estoque.");
        } else {
            System.out.println("Produto não encontrado.");
        }
    }

    /** Opção 8 - Repor estoque: informa código e quantidade a adicionar. */
    private static void reporEstoque(Estoque estoque) {
        System.out.print("Código do produto (0 para voltar): ");
        int codigo = lerInteiro();
        if (codigo == 0) {
            return;
        }
        Produto produto = estoque.buscarProduto(codigo);
        if (produto == null) {
            System.out.println("Produto não encontrado.");
            return;
        }
        System.out.print("Quantidade a adicionar (0 para voltar): ");
        int quantidade = lerInteiro();
        if (quantidade <= 0) {
            return;
        }
        produto.adicionarEstoque(quantidade);
        System.out.printf("Estoque atualizado: %s agora tem %d un.%n",
                produto.getNome(), produto.getQuantidadeEstoque());
    }

    /** Lê um inteiro, tratando entradas inválidas. */
    private static int lerInteiro() {
        while (!sc.hasNextInt()) {
            sc.next();
            System.out.print("Digite um número válido: ");
        }
        return sc.nextInt();
    }

    /** Lê um número decimal, aceitando ponto ou vírgula. */
    private static double lerDouble() {
        while (true) {
            String texto = sc.next().replace(',', '.');
            try {
                return Double.parseDouble(texto);
            } catch (NumberFormatException e) {
                System.out.print("Digite um valor válido: ");
            }
        }
    }
}
