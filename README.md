# Sistema de Gestão E-Commerce

![Java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white)
![Status](https://img.shields.io/badge/Status-Concluído-success?style=for-the-badge)

Um sistema completo de gerenciamento de e-commerce executado via terminal (CLI - Command Line Interface). Desenvolvido 100% em Java, este projeto simula a regra de negócio real de uma loja virtual, separando a experiência do Administrador (gestão de estoque) e do Cliente (jornada de compra).

## 🎯 Objetivo do Projeto
Este projeto foi construído para aplicar e consolidar conceitos avançados de **Programação Orientada a Objetos (POO)** e **Arquitetura de Software**, servindo como uma base sólida para futuras implementações de APIs RESTful com Spring Boot e persistência em Banco de Dados.

## ✨ Funcionalidades

O sistema possui dois fluxos de navegação independentes:

### 🔐 Área do Administrador (Protegida por Senha)
- **Cadastro de Produtos:** Adição de novos itens com ID auto-incremental, nome, preço e quantidade.
- **Exclusão de Produtos:** Remoção de itens do catálogo através do ID.
- **Controle de Estoque:** Visualização detalhada do estoque atual e o valor total (patrimônio) investido nos produtos.

### 🛍️ Área do Cliente
- **Vitrine Virtual:** Visualização limpa dos produtos disponíveis (escondendo informações sensíveis da loja).
- **Carrinho de Compras:** Adição de itens ao carrinho com validação de disponibilidade em estoque em tempo real.
- **Checkout Seguro:** Cálculo de subtotal e total. Ao confirmar o pagamento, o sistema realiza a "baixa" automática no estoque principal da loja.

## 🏗️ Arquitetura e Boas Práticas

O código foi refatorado visando a separação de responsabilidades (Clean Code), adotando uma estrutura baseada em **Camadas (Layered Architecture)**, semelhante ao padrão de mercado:

* **`model` (Modelos):** Classes de domínio puras (`Produto`, `ItemEstoque`, `ItemCarrinho`). Responsáveis apenas por encapsular os dados.
* **`repository` (Repositórios):** Classes que gerenciam o armazenamento em memória e manipulam as listas (`Estoque`, `Carrinho`).
* **`controller` / `view` (Controladores de Tela):** Classes responsáveis pela interação com o usuário via console (`MenuAdmin`, `MenuCliente`), garantindo que a lógica de interface não se misture com a regra de negócio.
* **`Operacoes` (Interface):** Contrato que garante o polimorfismo entre as classes que manipulam listas de produtos.

## 🚀 Como Executar o Projeto

1. Certifique-se de ter o **Java JDK 17+** (ou superior) instalado na sua máquina.
2. Clone este repositório:
   ```bash
   git clone https://github.com/Guims0/SistemaGestaoLoja.git
3. Abra o projeto na sua IDE de preferência (IntelliJ IDEA, Eclipse, VS Code).

4. Execute o arquivo Main.java.

5. No terminal, utilize a senha 1234 para acessar o painel de Administrador e começar a cadastrar os produtos.
