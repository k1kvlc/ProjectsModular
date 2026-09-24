import java.util.ArrayList;

/**
 * Fatura da compra: guarda o conjunto de itens em um ArrayList e o valor
 * total, que corresponde à soma de todos os itens comprados.
 */
public class Fatura {

    private ArrayList<Item> itens;
    private double valorTotal;

    public Fatura() {
        this.itens = new ArrayList<>();
        this.valorTotal = 0;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    /** Quantidade de itens na fatura. */
    public int quantidadeItens() {
        return itens.size();
    }

    /** Inclui um item na fatura e atualiza o valor total. */
    public void incluirItem(Item item) {
        itens.add(item);
        recalcularTotal();
    }

    /**
     * Exclui o item da posição informada (1 a size).
     * Retorna true se a posição era válida.
     */
    public boolean excluirItem(int posicao) {
        if (posicao < 1 || posicao > itens.size()) {
            return false;
        }
        itens.remove(posicao - 1);
        recalcularTotal();
        return true;
    }

    /**
     * Altera a quantidade comprada do item da posição informada (1 a size).
     * Retorna true se a posição era válida.
     */
    public boolean alterarItem(int posicao, int novaQuantidade) {
        if (posicao < 1 || posicao > itens.size()) {
            return false;
        }
        itens.get(posicao - 1).alterarQuantidade(novaQuantidade);
        recalcularTotal();
        return true;
    }


    /**
     * Retorna o item da posição informada (1 a size), ou null se inválida.
     * Usado na Parte 2 para devolver/ajustar o estoque ao excluir ou
     * alterar um item.
     */
    public Item getItem(int posicao) {
        if (posicao < 1 || posicao > itens.size()) {
            return null;
        }
        return itens.get(posicao - 1);
    }

    /** Recalcula o valor total somando o valor de cada item. */
    private void recalcularTotal() {
        valorTotal = 0;
        for (Item item : itens) {
            valorTotal += item.getValorTotal();
        }
    }

    /** Exibe a fatura: itens numerados com suas informações e o valor final. */
    public void imprimirFatura() {
        System.out.println("----- FATURA -----");
        if (itens.isEmpty()) {
            System.out.println("Nenhum item comprado até o momento.");
        } else {
            for (int i = 0; i < itens.size(); i++) {
                System.out.print((i + 1) + ") ");
                itens.get(i).imprimir();
            }
        }
        System.out.printf("Valor final: R$ %.2f%n", valorTotal);
        System.out.println("------------------");
    }
}
