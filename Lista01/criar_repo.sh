#!/usr/bin/env bash
# Monta o repositório Git da Prática 1:
#   main                 -> Parte 1 (exercicio1-imc + exercicio2-chapeu-seletor)
#   parte2-strings-datas -> Parte 2 (cadastro-bruxos), criada a partir da main
#
# Uso: bash criar_repo.sh
# Depois: cd repo && git remote add origin <URL do seu repositório> && git push -u origin --all
set -euo pipefail
cd "$(dirname "$0")"

if [ -d repo ]; then
  echo "A pasta 'repo' já existe. Apague-a se quiser recriar o repositório."
  exit 1
fi

mkdir repo
cp README.md repo/
printf '*.class\n.idea/\n.vscode/\nout/\nbin/\nbuild/\n' > repo/.gitignore
cp -r parte1/exercicio1-imc parte1/exercicio2-chapeu-seletor repo/

cd repo
git init -q
git symbolic-ref HEAD refs/heads/main
git add .
git commit -q -m "Parte 1: IMC e classificação corporal + Chapéu Seletor de Hogwarts"

# Parte 2 em nova branch, como pede o enunciado
git checkout -q -b parte2-strings-datas
mkdir cadastro-bruxos
cp ../parte2/*.java cadastro-bruxos/
git add .
git commit -q -m "Parte 2: cadastro de bruxos com tratamento de Strings e datas"

git checkout -q main
echo "Repositório criado em ./repo com as branches:"
git branch
echo
echo "Próximos passos:"
echo "  cd repo"
echo "  git remote add origin https://github.com/SEU_USUARIO/NOME_DO_REPO.git"
echo "  git push -u origin --all"
