/**
 * Exercício 2 - Chapéu Seletor de Hogwarts.
 * Cada aluno tem características (coragem, inteligência, ambição,
 * lealdade — e também estratégia e criatividade, usadas nas fórmulas
 * de Sonserina e Corvinal) e o método calcularCasa define a casa com
 * a maior pontuação.
 */
public class Aluno {

    private String nome;
    private int idade;
    private int coragem;
    private int inteligencia;
    private int ambicao;
    private int lealdade;
    private int estrategia;
    private int criatividade;
    private String casa;

    public Aluno() {
        this.nome = "";
        this.idade = 0;
        this.coragem = 0;
        this.inteligencia = 0;
        this.ambicao = 0;
        this.lealdade = 0;
        this.estrategia = 0;
        this.criatividade = 0;
        this.casa = "";
    }

    public Aluno(String nome, int idade, int coragem, int inteligencia,
                 int ambicao, int lealdade, int estrategia, int criatividade) {
        this.nome = nome;
        this.idade = idade;
        this.coragem = coragem;
        this.inteligencia = inteligencia;
        this.ambicao = ambicao;
        this.lealdade = lealdade;
        this.estrategia = estrategia;
        this.criatividade = criatividade;
        this.casa = "";
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public int getCoragem() {
        return coragem;
    }

    public void setCoragem(int coragem) {
        this.coragem = coragem;
    }

    public int getInteligencia() {
        return inteligencia;
    }

    public void setInteligencia(int inteligencia) {
        this.inteligencia = inteligencia;
    }

    public int getAmbicao() {
        return ambicao;
    }

    public void setAmbicao(int ambicao) {
        this.ambicao = ambicao;
    }

    public int getLealdade() {
        return lealdade;
    }

    public void setLealdade(int lealdade) {
        this.lealdade = lealdade;
    }

    public int getEstrategia() {
        return estrategia;
    }

    public void setEstrategia(int estrategia) {
        this.estrategia = estrategia;
    }

    public int getCriatividade() {
        return criatividade;
    }

    public void setCriatividade(int criatividade) {
        this.criatividade = criatividade;
    }

    public String getCasa() {
        return casa;
    }

    public void setCasa(String casa) {
        this.casa = casa;
    }

    /**
     * Calcula a pontuação mágica de cada casa e define a casa do aluno
     * como a de MAIOR pontuação.
     *   Grifinória: (2 * coragem) + lealdade
     *   Sonserina:  (2 * ambicao) + estrategia
     *   Corvinal:   (2 * inteligencia) + criatividade
     *   Lufa-Lufa:  ((2 * lealdade) + coragem) / 3
     */
    public void calcularCasa() {
        double grifinoria = (2.0 * coragem) + lealdade;
        double sonserina = (2.0 * ambicao) + estrategia;
        double corvinal = (2.0 * inteligencia) + criatividade;
        double lufaLufa = ((2.0 * lealdade) + coragem) / 3.0;

        double maior = grifinoria;
        this.casa = "Grifinória";

        if (sonserina > maior) {
            maior = sonserina;
            this.casa = "Sonserina";
        }
        if (corvinal > maior) {
            maior = corvinal;
            this.casa = "Corvinal";
        }
        if (lufaLufa > maior) {
            maior = lufaLufa;
            this.casa = "Lufa-Lufa";
        }
    }

    /** Exibe as informações do aluno. */
    public void exibirInformacoes() {
        System.out.println("Aluno: " + nome + " (" + idade + " anos)");
        System.out.println("  Coragem: " + coragem + " | Inteligência: " + inteligencia
                + " | Ambição: " + ambicao + " | Lealdade: " + lealdade
                + " | Estratégia: " + estrategia + " | Criatividade: " + criatividade);
        System.out.println("  Casa: " + (casa.isEmpty() ? "ainda não selecionada" : casa));
    }
}
