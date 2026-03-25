# 📱 Projeto de Navegação Android

# ! O que foi implementado

Foram adicionadas melhorias na navegação entre as telas Menu, Perfil e Pedidos, permitindo a passagem de parâmetros dinâmicos.

## 🔁 Tela de Perfil

Agora recebe:
- nome (String)
- idade (Int)

Exibe os dados dinamicamente na interface.

## 🖥️ Tela de Pedidos
Passa a receber:
- cliente (String opcional)

Caso não seja informado, utiliza valor padrão.

## Menu

Foram alteradas as navegações dos botões:

- Perfil com nome e idade
- Pedidos com nome do cliente
---

### Como a navegação foi configurada

A navegação foi implementada utilizando o NavHost e rotas com parâmetros obrigatórios e opcionais.

Rota com parâmetros obrigatórios (Perfil)
- nome e idade são obrigatórios
- Tipos definidos explicitamente

Rota com parâmetro opcional (Pedidos)
- Parâmetro opcional
- Valor padrão definido

---


### Como os parâmetros são enviados

Envio de parâmetros

Os parâmetros são enviados via navegação:

Perfil : navController.navigate("perfil/Fulano de Tal/27")
Pedidos : navController.navigate("pedidos?cliente=Cliente XPTO")

---

### Recebimento de parâmetros

Os valores são recuperados via arguments:

Perfil:
val nome = it.arguments?.getString("nome", "Usuário Genérico")
val idade = it.arguments?.getInt("idade", 0)

Pedidos:
val cliente = it.arguments?.getString("cliente")
