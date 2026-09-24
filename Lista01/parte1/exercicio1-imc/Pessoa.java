/**
 * Exercício 1 - IMC e Classificação Corporal.
 * Classe Pessoa com dados encapsulados (atributos privados),
 * construtores, get/set de cada variável e os métodos CalculaIMC
 * e InformaObesidade pedidos no enunciado.
 */
public class Pessoa {

    private String nome;
    private String sobrenome;
    private int idade;
    private double altura;
    private double peso;
    private double imc;

    public Pessoa() {
        this.nome = "";
        this.sobrenome = "";
        this.idade = 0;
        this.altura = 0;
        this.peso = 0;
        this.imc = 0;
    }

    public Pessoa(String nome, String sobrenome, int idade, double altura, double peso) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.idade = idade;
        this.altura = altura;
        this.peso = peso;
        this.imc = 0;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public double getImc() {
        return imc;
    }

    public void setImc(double imc) {
        this.imc = imc;
    }

    /**
     * Calcula o IMC da pessoa pela fórmula peso / altura² e guarda o
     * resultado no atributo imc.
     */
    public double CalculaIMC() {
        this.imc = this.peso / (this.altura * this.altura);
        return this.imc;
    }

    /**
     * Informa a faixa de massa corporal em que a pessoa se encontra,
     * conforme a tabela do enunciado.
     */
    public String InformaObesidade() {
        if (imc < 18.5) {
            return "Abaixo do peso";
        } else if (imc <= 24.9) {
            return "Peso normal";
        } else if (imc <= 29.9) {
            return "Sobrepeso";
        } else if (imc <= 34.9) {
            return "Obesidade grau 1";
        } else if (imc <= 39.9) {
            return "Obesidade grau 2";
        } else {
            return "Obesidade grau 3";
        }
    }
}
