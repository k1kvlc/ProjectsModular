# Prática 2 – Arrays e Collections (Programação Modular)

Resolução da Prática 2 do Laboratório de Programação Modular (Prof. Glender Brás).
Linguagem: **Java** (JDK 8+, sem bibliotecas externas).

## Estrutura em branches (como pede o enunciado)

| Branch | Conteúdo |
|---|---|
| `main` | **Parte 1 – Carrinho de Compras**: classes `Produto`, `Item`, `Fatura` (com `ArrayList`) e `Main` com o menu |
| `parte2-hashmaps` | **Parte 2 – Estoque de Produtos**: adiciona a classe `Estoque` (`HashMap<Integer, Produto>`), altera `Produto` (quantidade em estoque) e expande o menu |

## Parte 1 – Carrinho de Compras (`main`)

- `Produto`: nome, código e preço.
- `Item`: produto comprado, quantidade e valor total (preço × quantidade), calculado em `realizarCompra`.
- `Fatura`: `ArrayList<Item>` e valor total (soma dos itens); métodos para incluir, excluir e alterar itens.
- `Main`: cadastra 3 produtos e apresenta o menu **1**-Comprar, **2**-Ver fatura, **3**-Excluir item, **4**-Alterar item, **5**-Finalizar. Em todo submenu, digitar `0` volta sem realizar nenhuma ação.

## Parte 2 – Estoque com HashMap (`parte2-hashmaps`)

- `Estoque`: `HashMap<Integer, Produto>` (chave = código) com tamanho, e os métodos `adicionarProduto` (false para código duplicado), `buscarProduto`, `removerProduto`, `verificarExistencia`, `listarProdutos` e `listarEstoqueBaixo`.
- `Produto`: ganhou `quantidadeEstoque`, `adicionarEstoque(int)` e `retirarEstoque(int)` (false se a quantidade pedida excede a disponível).
- Menu expandido: consultar produto, adicionar produto ao estoque, remover produto, repor estoque e produtos com estoque baixo (menos de 5 unidades).
- **Compra integrada ao estoque**: verifica se o produto existe, se há quantidade suficiente e, só então, realiza a venda, reduz o estoque e adiciona o item à fatura. Excluir ou reduzir um item da fatura devolve a quantidade ao estoque.

## Como executar

```bash
# Parte 1
git checkout main
javac -encoding UTF-8 *.java && java Main

# Parte 2
git checkout parte2-hashmaps
javac -encoding UTF-8 *.java && java Main
```

## Montagem do repositório

O script `criar_repo.sh` (incluído no zip, fora do repositório) inicializa o Git com
a `main` contendo a Parte 1 e a branch `parte2-hashmaps` com a Parte 2:

```bash
bash criar_repo.sh
git remote add origin https://github.com/SEU_USUARIO/NOME_DO_REPO.git
git push -u origin --all
```
