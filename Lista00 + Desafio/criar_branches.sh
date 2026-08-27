#!/usr/bin/env bash
# Inicializa o repositório Git local com uma branch para cada atividade.
#
# Uso (dentro da pasta do projeto):
#   bash criar_branches.sh
#
# Resultado:
#   main                          -> README, .gitignore e este script + merge de todas as atividades
#   atividade-01-fatorial ...     -> uma branch por atividade, contendo só o código daquela atividade
#   desafio-mata-mata             -> branch do desafio
set -euo pipefail
cd "$(dirname "$0")"

if [ -d .git ]; then
  echo "Já existe um repositório Git nesta pasta. Nada foi alterado."
  exit 1
fi

# Lista das pastas de atividade (coletada antes de qualquer checkout)
pastas=()
for pasta in atividade-* desafio-*; do
  [ -d "$pasta" ] && pastas+=("$pasta")
done

git init -q
git symbolic-ref HEAD refs/heads/main

# Commit inicial: apenas a estrutura básica do repositório
git add README.md .gitignore criar_branches.sh
git commit -q -m "Estrutura inicial do repositório"
base=$(git rev-parse HEAD)

# Uma branch por atividade, criada a partir do commit inicial
for pasta in "${pastas[@]}"; do
  git checkout -q -b "$pasta" "$base"
  git add "$pasta"
  git commit -q -m "Resolve $pasta"
done

# main recebe o merge de todas as branches (fica com a solução completa)
git checkout -q main
for pasta in "${pastas[@]}"; do
  git merge -q --no-ff "$pasta" -m "Merge da branch $pasta"
done

echo "Branches criadas:"
git branch
echo
echo "Para subir ao GitHub:"
echo "  git remote add origin https://github.com/SEU_USUARIO/NOME_DO_REPO.git"
echo "  git push -u origin --all"
