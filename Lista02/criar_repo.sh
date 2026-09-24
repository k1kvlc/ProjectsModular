#!/usr/bin/env bash
# Monta o repositório Git da Prática 2:
#   main            -> Parte 1 (Carrinho de Compras)
#   parte2-hashmaps -> Parte 2 (Estoque com HashMap), criada a partir da main
#
# Uso: bash criar_repo.sh
# Depois: git remote add origin <URL do seu repositório público> && git push -u origin --all
set -euo pipefail
cd "$(dirname "$0")"

if [ -d repo ]; then
  echo "A pasta 'repo' já existe. Apague-a se quiser recriar o repositório."
  exit 1
fi

mkdir repo
cp README.md repo/
printf '*.class\n.idea/\n.vscode/\nout/\nbin/\n' > repo/.gitignore
cp parte1/*.java repo/

cd repo
git init -q
git symbolic-ref HEAD refs/heads/main
git add .
git commit -q -m "Parte 1: carrinho de compras com Produto, Item, Fatura e menu (ArrayList)"

# Parte 2 em nova branch, como pede o enunciado
git checkout -q -b parte2-hashmaps
cp ../parte2/*.java .
git add .
git commit -q -m "Parte 2: estoque com HashMap, alterações em Produto e menu expandido"

git checkout -q main
echo "Repositório criado em ./repo com as branches:"
git branch
echo
echo "Próximos passos:"
echo "  cd repo"
echo "  git remote add origin https://github.com/SEU_USUARIO/NOME_DO_REPO.git"
echo "  git push -u origin --all"
