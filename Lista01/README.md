# Prática 1 – Classes e Objetos / Strings e Datas (Programação Modular)

Resolução da Prática 1 do Laboratório de Programação Modular (Prof. Glender Brás).
Linguagem: **Java** (JDK 8+ na parte 1; JDK 8+ com `java.time` na parte 2).

## Estrutura em branches (como pede o enunciado)

| Branch | Conteúdo |
|---|---|
| `main` | **Parte 1**: Exercício 1 (IMC e Classificação Corporal) e Exercício 2 (Chapéu Seletor de Hogwarts) |
| `parte2-strings-datas` | **Parte 2**: Sistema de Cadastro de Bruxos — Strings, `LocalDate`, vetor de até 10 alunos e menu completo |

## Parte 1 (`main`)

**Exercício 1 – IMC** (`exercicio1-imc/`)
- `Pessoa`: atributos encapsulados (nome, sobrenome, idade, altura, peso, imc), construtores, get/set de cada variável, `CalculaIMC()` (peso / altura²) e `InformaObesidade()` com a tabela do enunciado.
- `Main`: lê os dados, calcula e exibe o IMC e a faixa de massa corporal.

**Exercício 2 – Chapéu Seletor** (`exercicio2-chapeu-seletor/`)
- `Aluno`: nome, idade, coragem, inteligência, ambição, lealdade e casa — além de **estratégia** e **criatividade**, atributos extras necessários porque as fórmulas de Sonserina e Corvinal os utilizam.
- `calcularCasa()`: Grifinória `2*coragem + lealdade` · Sonserina `2*ambicao + estrategia` · Corvinal `2*inteligencia + criatividade` · Lufa-Lufa `(2*lealdade + coragem)/3`; vence a maior pontuação (empate fica com a primeira da ordem acima).
- `Main`: loop de cadastro e classificação; encerra só quando o usuário pedir.

## Parte 2 (`parte2-strings-datas`)

- `Aluno` ganhou `sobrenome`, `dataNascimento` (`LocalDate`) e `codigoMatricula` (`String`), e os métodos:
  1. `calcularIdade()` — `Period.between` da data de nascimento até hoje;
  2. `verificarMaioridadeMagica()` — adulto aos 17 anos;
  3. `formatarCasa()` — casa em maiúsculas;
  4. `gerarNomeUsuario()` — 1ª letra do nome + sobrenome completo em minúsculo (Harry Potter → `hpotter`);
  5. `gerarCodigoMatricula(posicao)` — iniciais-ano-posição (ex.: `HP-2026-01`);
  6. `verificarCasa(casa)` — ignora maiúsculas e acentos ("grifinoria" ≡ "GRIFINÓRIA" ≡ "Grifinória");
  7. `verificarPresencaPalavra(palavra)` — o sobrenome contém a palavra (acha "black" em "Black Padfoot").
- `Main`: vetor `Aluno[10]`, cadastro com **data validada** (`ResolverStyle.STRICT` rejeita 31/02 e datas futuras; formato `dd/mm/aaaa`) e menu 1-Cadastrar · 2-Listar · 3-Alunos de uma casa + total · 4-Alunos agrupados por casa · 5-Maiores · 6-Menores · 7-Buscar por sobrenome · 8-Encerrar (exibe todos os cadastrados ao sair).

## Como executar

```bash
# Parte 1 - Exercício 1
git checkout main && cd exercicio1-imc
javac -encoding UTF-8 *.java && java Main

# Parte 1 - Exercício 2
cd ../exercicio2-chapeu-seletor
javac -encoding UTF-8 *.java && java Main

# Parte 2
git checkout parte2-strings-datas && cd cadastro-bruxos
javac -encoding UTF-8 *.java && java Main
```

## Montagem do repositório

```bash
bash criar_repo.sh
cd repo
git remote add origin https://github.com/SEU_USUARIO/NOME_DO_REPO.git
git push -u origin --all
```
