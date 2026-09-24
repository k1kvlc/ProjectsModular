/**
 * Representa um produto da loja de suprimentos.
 * Atributos exigidos no enunciado: nome, código e preço.
 */
public class Produto {

    private String nome;
    private int codigo;
    private double preco;

    public Produto(String nome, int codigo, double preco) {
        this.nome = nome;
        this.codigo = codigo;
        this.preco = preco;
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

    /** Diz se este produto tem o código informado (evita expor comparação no main). */
    public boolean possuiCodigo(int codigo) {
        return this.codigo == codigo;
    }

    /** Imprime as informações do produto. */
    public void imprimir() {
        System.out.printf("Código %d | %s | R$ %.2f%n", codigo, nome, preco);
    }
}
