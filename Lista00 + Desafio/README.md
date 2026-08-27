# Nivelamento – Programação Modular (PUC Minas)

Resolução da **Lista 00 – Revisão de Programação** e do **Desafio Mata-mata**
(Prof. Glender Brás). Linguagem: **Java** (JDK 8 ou superior, sem bibliotecas externas).

## Atividades

| Pasta / branch | Atividade | Classe |
|---|---|---|
| `atividade-01-fatorial` | 1 – Fatorial de um inteiro | `Fatorial` |
| `atividade-02-vetor-tres-valores` | 2 – Maior, menor, intervalo [y, z] e divisibilidade de x, y, z | `TresValores` |
| `atividade-03-intersecao-vetores` | 3 – Interseção de matrículas (Programação Modular ∩ Cálculo) | `Intersecao` |
| `atividade-04-uniao-vetores` | 4 – União de vetores sem repetição | `Uniao` |
| `atividade-05-pesquisa-populacao` | 5 – Pesquisa de características da população | `Pesquisa` |
| `atividade-06-correcao-provas` | 6 – Correção de provas de múltipla escolha | `CorrecaoProvas` |
| `atividade-07-temperaturas` | 7 – Maior e menor temperatura do ano | `Temperaturas` |
| `atividade-08-loja-artesanato` | 8 – Relatório de vendas e comissão do vendedor | `LojaArtesanato` |
| `atividade-09-pares-impares` | 9 – Relatório de pares e ímpares | `ParesImpares` |
| `atividade-10-vendas-matriz` | 10 – Vendas em matriz 12 x 4 (mês x semana) | `VendasMatriz` |
| `desafio-mata-mata` | Desafio – Equipe campeã do mata-mata | `MataMata` |

## Como executar

Entre na pasta da atividade, compile e execute:

```bash
cd atividade-01-fatorial
javac -encoding UTF-8 Fatorial.java
java Fatorial
```

Cada pasta tem um `entrada-exemplo.txt` para testar sem digitar nada:

```bash
java Fatorial < entrada-exemplo.txt
```

Com JDK 11 ou superior dá para pular a compilação: `java Fatorial.java < entrada-exemplo.txt`.

## Desafio Mata-mata

```bash
cd desafio-mata-mata
javac -encoding UTF-8 MataMata.java
java MataMata < exemplo1.txt   # imprime F
java MataMata < exemplo2.txt   # imprime A
```

A entrada são 15 linhas, uma por jogo (na ordem 1 a 15), no formato `M N` ou `jogo M N`
(como nos exemplos do enunciado). O programa valida gols entre 0 e 20 e ausência de empates.

## Branches (uma por atividade)

O script `criar_branches.sh` inicializa o repositório com:

- `main`: README, `.gitignore` e o script;
- uma branch por atividade (`atividade-01-fatorial` … `desafio-mata-mata`), cada uma com o código correspondente;
- merge de todas as branches em `main`, para que `main` tenha a solução completa.

```bash
bash criar_branches.sh
git remote add origin https://github.com/SEU_USUARIO/NOME_DO_REPO.git
git push -u origin --all
```

## Observações sobre as soluções

- **Atividade 3**: um único `n` é lido e usado para os dois vetores, como indica o enunciado.
- **Atividade 5**: a idade é lida antes dos outros dados de cada habitante, para que o `-1` encerre a leitura sem precisar digitar os demais campos.
- **Atividades 8 e 9**: as posições são exibidas a partir de 1, como no exemplo do enunciado (a atividade 8 também mostra o índice do vetor).
- Valores decimais (temperaturas e preços) aceitam ponto ou vírgula.
