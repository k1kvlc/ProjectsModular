import java.util.HashMap;

/**
 * Estoque da loja: armazena os produtos em um HashMap, onde a chave é o
 * código do produto e o valor é o objeto Produto. O estoque também possui
 * um tamanho, que corresponde à quantidade de produtos cadastrados.
 */
public class Estoque {

    private HashMap<Integer, Produto> produtos;
    private int tamanho;

    public Estoque() {
        this.produtos = new HashMap<>();
        this.tamanho = 0;
    }

    public int getTamanho() {
        return tamanho;
    }

    /**
     * Cadastra um novo produto no estoque.
     * Retorna true se o produto foi adicionado, ou false caso já exista
     * um produto com o mesmo código.
     */
    public boolean adicionarProduto(Produto produto) {
        if (produtos.containsKey(produto.getCodigo())) {
            return false;
        }
        produtos.put(produto.getCodigo(), produto);
        tamanho = produtos.size();
        return true;
    }

    /** Retorna um produto a partir do código (null se não existir). */
    public Produto buscarProduto(int codigo) {
        return produtos.get(codigo);
    }

    /**
     * Remove um produto do estoque a partir do código.
     * Retorna true se o produto existia e foi removido.
     */
    public boolean removerProduto(int codigo) {
        if (!produtos.containsKey(codigo)) {
            return false;
        }
        produtos.remove(codigo);
        tamanho = produtos.size();
        return true;
    }

    /** Recebe o código de um produto e retorna true se ele existe no estoque. */
    public boolean verificarExistencia(int codigo) {
        return produtos.containsKey(codigo);
    }

    /** Exibe todos os produtos cadastrados. */
    public void listarProdutos() {
        if (produtos.isEmpty()) {
            System.out.println("Nenhum produto cadastrado no estoque.");
            return;
        }
        for (Produto p : produtos.values()) {
            p.imprimir();
        }
    }

    /** Exibe os produtos cuja quantidade em estoque é inferior ao limite. */
    public void listarEstoqueBaixo(int limite) {
        boolean encontrou = false;
        for (Produto p : produtos.values()) {
            if (p.estoqueAbaixoDe(limite)) {
                p.imprimir();
                encontrou = true;
            }
        }
        if (!encontrou) {
            System.out.println("Nenhum produto com estoque abaixo de " + limite + " unidades.");
        }
    }
}
