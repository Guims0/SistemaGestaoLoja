package controller;

import model.ItemCarrinho;
import model.ItemEstoque;
import model.Produto;
import repository.Carrinho;
import repository.Estoque;

import java.util.Scanner;

public class MenuCliente {
    private Scanner scanner;
    private Estoque estoque;
    private Carrinho carrinho;

    public MenuCliente(Scanner scanner, Estoque estoque) {
        this.scanner = scanner;
        this.estoque = estoque;
        this.carrinho = new Carrinho();
    }

    public void iniciar(){
        int opcao = -1;
        while (opcao != 0){

            System.out.println("""
                    1. Ver Produtos da Loja
                    2. Adicionar ao carrinho
                    3. Ver meu carrinho
                    4. Finalizar compra
                    0. Voltar ao menu principal
                    ==========================
                       Escolha uma opção:
                    """);
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    System.out.println(" ===  V I T R I N E  === ");
                    System.out.println("----------------------------------------");
                    if (estoque.getListaDeEstoque().isEmpty()){
                        System.out.println("Vitrine está vazia. Volte depois.");
                        break;
                    }
                    for (ItemEstoque item : estoque.getListaDeEstoque()) {
                        System.out.printf("""
                           | Cód: %-20s
                           | Produto: %-25s
                           | Preço:   R$ %-20.2f
                           | Em estoque: %-20d
                           ----------------------------------------
                           """, item.getProduto().getId(),
                                item.getProduto().getNome(),
                                item.getProduto().getPreco(),
                                item.getQuantidade());
                    }

                    break;
                case 2:

                    System.out.println(" -- ADICIONAR AO CARRINHO -- ");
                    System.out.println("Digite o cód do produto que deseja comprar:");
                    long idProduto = scanner.nextLong();

                    Produto produtoEncontrado = estoque.buscarProduto(idProduto);

                    if (produtoEncontrado == null) {
                        System.out.println("Produto não encontrado.");
                        break;
                    }

                    System.out.println("Quantas unidades de " + produtoEncontrado.getNome() + " você quer? ");
                    int qtd = scanner.nextInt();
                    scanner.nextLine();

                    int qtdEstoque = estoque.verificarQuantidade(idProduto);

                    if (qtdEstoque <= 0) {
                        System.out.println("Deve adicionar pelo menos 1 unidade.");
                    } else if (qtd > qtdEstoque) {
                        System.out.println("Quantidade maior que a disponivel em estoque. Temos " + qtdEstoque + " unidades de " + produtoEncontrado.getNome() + ".");
                    } else {
                        carrinho.adicionar(produtoEncontrado, qtd);
                        System.out.println("Qtd: " + qtd + " | " + produtoEncontrado.getNome() + " adicionado(s) ao carrinho.");
                    }
                    break;
                case 3:
                    carrinho.exibir();
                    break;

                case 4:
                    System.out.println(" -- CAIXA / FINALIZAR COMPRA -- ");
                    if (carrinho.getItemCarrinhos().isEmpty()) {
                        System.out.println(" Seu carrinho está vazio. Adicione produtos antes de ir ao caixa.");
                        break;
                    }
                    carrinho.exibir();
                    double total = carrinho.calcularTotal();
                    System.out.println("TOTAL A PAGAR: R$ " + total);

                    System.out.println("Confirmar pagamento? (1 para SIM / 2 para NÃO): ");
                    int confirmacao = scanner.nextInt();
                    scanner.nextLine();

                    if (confirmacao == 1) {
                        for (ItemCarrinho item : carrinho.getItemCarrinhos()) {
                            Long id = item.getProduto().getId();
                            int quantidade = item.getQuantidade();

                            estoque.darBaixa(id, quantidade);
                        }

                        carrinho.limpar();
                        System.out.println(" Pagamento Aprovado. Compra finalizada com sucesso.");
                        System.out.println("Obrigado pela preferência e volte sempre.");
                    }else {
                        System.out.println("Compra cancelada. Seus itens continuam no carrinho.");
                    }
                    break;

            }
        }
    }

}
