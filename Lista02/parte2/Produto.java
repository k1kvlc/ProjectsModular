/**
 * Representa um produto da loja de suprimentos.
 * Parte 2: ganhou o atributo quantidadeEstoque e os métodos
 * adicionarEstoque e retirarEstoque.
 */
public class Produto {

    private String nome;
    private int codigo;
    private double preco;
    private int quantidadeEstoque;

    public Produto(String nome, int codigo, double preco, int quantidadeEstoque) {
        this.nome = nome;
        this.codigo = codigo;
        this.preco = preco;
        this.quantidadeEstoque = quantidadeEstoque;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public int getQuantidadeEstoque() {
        return quantidadeEstoque;
    }

    /** Recebe um valor inteiro e incrementa a quantidade em estoque. */
    public void adicionarEstoque(int quantidade) {
        if (quantidade > 0) {
            this.quantidadeEstoque += quantidade;
        }
    }

    /**
     * Retira a quantidade informada do estoque.
     * Retorna true se foi possível, ou false se a quantidade solicitada
     * for maior que a quantidade disponível.
     */
    public boolean retirarEstoque(int quantidade) {
        if (quantidade <= 0 || quantidade > quantidadeEstoque) {
            return false;
        }
        this.quantidadeEstoque -= quantidade;
        return true;
    }

    /** Diz se há quantidade suficiente em estoque para a compra. */
    public boolean possuiEstoque(int quantidade) {
        return quantidadeEstoque >= quantidade;
    }

    /** Diz se o estoque deste produto está abaixo do limite informado. */
    public boolean estoqueAbaixoDe(int limite) {
        return quantidadeEstoque < limite;
    }

    /** Diz se este produto tem o código informado. */
    public boolean possuiCodigo(int codigo) {
        return this.codigo == codigo;
    }

    /** Imprime todas as informações do produto. */
    public void imprimir() {
        System.out.printf("Código %d | %s | R$ %.2f | %d un. em estoque%n",
                codigo, nome, preco, quantidadeEstoque);
    }
}
