/**
 * Representa um item de venda da fatura: o produto comprado, a quantidade
 * e o valor total do item (preço do produto x quantidade).
 */
public class Item {

    private Produto produto;
    private int quantidade;
    private double valorTotal;

    public Item(Produto produto) {
        this.produto = produto;
        this.quantidade = 0;
        this.valorTotal = 0;
    }

    public Produto getProduto() {
        return produto;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    /**
     * Realiza a compra deste item: define a quantidade comprada e
     * calcula o valor total (preço x quantidade).
     */
    public void realizarCompra(int quantidade) {
        this.quantidade = quantidade;
        this.valorTotal = produto.getPreco() * quantidade;
    }

    /**
     * Altera a quantidade comprada e recalcula o valor total do item.
     */
    public void alterarQuantidade(int novaQuantidade) {
        realizarCompra(novaQuantidade);
    }

    /** Diz se este item se refere ao produto com o código informado. */
    public boolean possuiProduto(int codigo) {
        return produto.possuiCodigo(codigo);
    }

    /** Imprime as informações do item. */
    public void imprimir() {
        System.out.printf("%s (código %d) | %d un. x R$ %.2f = R$ %.2f%n",
                produto.getNome(), produto.getCodigo(), quantidade,
                produto.getPreco(), valorTotal);
    }
}
