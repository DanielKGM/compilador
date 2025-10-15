# Etapas (PT-BR)

## 1. Tradutor Simples

- Converter notação infixada para pós-fixada;
- Exemplo: `2 + 2 → 2 2 +`;
- Até o momento sem analisador léxico, pois os dígitos são os números naturais\*;
- Reconhecedor de uma gramática livre de contexto sem ambiguidades → `analisador sintático preditivo`;
- `Analisador sintático preditivo` "prevê" qual regra de produção da gramática será utilizada na estrutura da árvore sintática, lendo a entrada da esquerda para a direita;
- Ou seja, a gramática não pode ser `recursiva à esquerda`;

### 1.1 Gramática de Entrada (Notação Infixada)

- Primeiramente, expressões infixadas tipo `2 + 1 - 1` podem ser descritas pela GLC recursiva `à esquerda`:

```Java
expr →  expr + digit
        | expr - digit
        | digit
digit → 0 | .. | 9
```

- Equivalente à GLC recursiva `à direita`:

```Java
expr →  digit oper
oper →  + digit oper
        | - digit oper
        | ε
digit → 0 | .. | 9
```

### 1.1 Implementação do Parser (Notação Infixada)

- PolishNotationParser.java

## Referências

SOUZA COSTA, S. **Tradução Dirigida por Sintaxe**. Disponível em: <https://profsergiocosta.notion.site/Tradu-o-dirigida-por-sintaxe-bc590c67d8234f81bee5cfdb505f2dd1?pvs=18>. Acesso em: 15 out. 2025.
