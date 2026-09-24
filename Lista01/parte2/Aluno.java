import java.text.Normalizer;
import java.time.LocalDate;
import java.time.Period;

/**
 * Prática 1 (parte 2) - Sistema de Cadastro de Bruxos de Hogwarts.
 * A classe Aluno da parte 1 ganhou sobrenome, data de nascimento
 * (LocalDate) e código de matrícula (String), além dos métodos de
 * tratamento de Strings e datas pedidos no enunciado.
 */
public class Aluno {

    private String nome;
    private String sobrenome;
    private int idade;
    private int coragem;
    private int inteligencia;
    private int ambicao;
    private int lealdade;
    private int estrategia;
    private int criatividade;
    private String casa;
    private LocalDate dataNascimento;
    private String codigoMatricula;

    public Aluno() {
        this.nome = "";
        this.sobrenome = "";
        this.idade = 0;
        this.coragem = 0;
        this.inteligencia = 0;
        this.ambicao = 0;
        this.lealdade = 0;
        this.estrategia = 0;
        this.criatividade = 0;
        this.casa = "";
        this.dataNascimento = null;
        this.codigoMatricula = "";
    }

    public Aluno(String nome, String sobrenome, LocalDate dataNascimento,
                 int coragem, int inteligencia, int ambicao, int lealdade,
                 int estrategia, int criatividade) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.dataNascimento = dataNascimento;
        this.coragem = coragem;
        this.inteligencia = inteligencia;
        this.ambicao = ambicao;
        this.lealdade = lealdade;
        this.estrategia = estrategia;
        this.criatividade = criatividade;
        this.casa = "";
        this.codigoMatricula = "";
        this.idade = calcularIdade();
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

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
        this.idade = calcularIdade();
    }

    public String getCodigoMatricula() {
        return codigoMatricula;
    }

    public void setCodigoMatricula(String codigoMatricula) {
        this.codigoMatricula = codigoMatricula;
    }

    /** 1. Calcula a idade a partir da data de nascimento. */
    public int calcularIdade() {
        if (dataNascimento == null) {
            return 0;
        }
        return Period.between(dataNascimento, LocalDate.now()).getYears();
    }

    /** 2. Um bruxo é considerado adulto aos 17 anos. */
    public boolean verificarMaioridadeMagica() {
        return calcularIdade() >= 17;
    }

    /** 3. Retorna o nome da casa em letras maiúsculas. */
    public String formatarCasa() {
        return casa.toUpperCase();
    }

    /**
     * 4. Gera o nome de usuário: primeira letra do nome + sobrenome
     * completo, tudo em minúsculo e sem espaços (ex.: Harry Potter -> hpotter).
     */
    public String gerarNomeUsuario() {
        if (nome.isEmpty() || sobrenome.isEmpty()) {
            return "";
        }
        String login = nome.charAt(0) + sobrenome.replace(" ", "");
        return login.toLowerCase();
    }

    /**
     * 5. Gera o código de matrícula: iniciais do nome - ano atual -
     * posição de cadastro. Ex.: HP-2026-01 para Harry Potter, primeiro
     * a se cadastrar (posição 1 do vetor).
     */
    public void gerarCodigoMatricula(int posicaoCadastro) {
        String iniciais = "" + Character.toUpperCase(nome.charAt(0))
                + Character.toUpperCase(sobrenome.charAt(0));
        int anoAtual = LocalDate.now().getYear();
        this.codigoMatricula = String.format("%s-%d-%02d", iniciais, anoAtual, posicaoCadastro);
    }

    /**
     * 6. Verifica se o aluno pertence à casa informada pelo usuário.
     * A comparação ignora maiúsculas/minúsculas e acentos, para aceitar
     * "grifinoria", "GRIFINÓRIA", "Grifinória" etc.
     */
    public boolean verificarCasa(String casaInformada) {
        return normalizar(casa).equals(normalizar(casaInformada));
    }

    /**
     * 7. Informa se o sobrenome contém a string informada pelo usuário
     * (ex.: "black", "malfoy"), ignorando maiúsculas/minúsculas — assim
     * um sobrenome composto é encontrado por apenas uma das partes.
     */
    public boolean verificarPresencaPalavra(String palavra) {
        return normalizar(sobrenome).contains(normalizar(palavra));
    }

    /** Remove acentos e converte para minúsculas, para comparações tolerantes. */
    private String normalizar(String texto) {
        String semAcentos = Normalizer.normalize(texto, Normalizer.Form.NFD)
                .replaceAll("\\p{M}", "");
        return semAcentos.toLowerCase().trim();
    }

    /**
     * Calcula a pontuação mágica de cada casa e define a casa do aluno
     * como a de MAIOR pontuação (mesmas fórmulas da parte 1).
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

    /** Exibe as informações do aluno cadastrado. */
    public void exibirInformacoes() {
        System.out.println("Matrícula " + codigoMatricula + " | " + nome + " " + sobrenome
                + " | login: " + gerarNomeUsuario());
        System.out.println("  Nascimento: " + dataNascimento + " | Idade: " + calcularIdade()
                + " anos | " + (verificarMaioridadeMagica() ? "maior" : "menor") + " de idade");
        System.out.println("  Casa: " + formatarCasa());
    }
}
