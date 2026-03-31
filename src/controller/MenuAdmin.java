package controller;

import model.Produto;
import repository.Estoque;

import java.util.Scanner;

public class MenuAdmin {
    private Scanner scanner;
    private Estoque estoque;
    private final int senha = 1234;

    public MenuAdmin(Scanner scanner, Estoque estoque) {
        this.scanner = scanner;
        this.estoque = estoque;
    }

    public void iniciar(){

        System.out.println(" === ÁREA RESTRITA === ");
        System.out.println("Digite a senha do Administrador: ");
        int senhaDigitada = scanner.nextInt();
        scanner.nextLine();

        if (senhaDigitada != senha){
            System.out.println("Acesso negado, senha errada\n");
            return;
        }
        System.out.println("Acesso permitido\n");

        int opcao = -1;

        while (opcao != 0){

            System.out.println("""
                    === PAINEL DO ADMINISTRADOR ===
                         1. Cadastrar produto
                         2. Excluir produto
                         3. Ver estoque completo
                         0. Voltar ao menu principal
                    ===============================
                          Escolha uma opção:
                    """);
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao){
                case 1:
                    System.out.println("-- CADASTRAR NOVO PRODUTO --");
                    System.out.println("Digite o nome do produto: ");
                    String nome = scanner.nextLine();

                    System.out.println("Digite o preço do produto: ");
                    double preco = scanner.nextDouble();

                    System.out.println("Digite a quantidade do produto: ");
                    int quantidade = scanner.nextInt();
                    scanner.nextLine();

                    estoque.adicionar(new Produto(nome,preco),quantidade);
                    System.out.println("Produto cadastrado com sucesso!");
                    break;

                case 2:
                    System.out.println("-- EXCLUIR PRODUTO --");
                    estoque.exibir();

                    System.out.println("Digite o id do produto que quer excluir: ");
                    long id = scanner.nextLong();
                    estoque.excluir(id);
                    break;

                case 3:
                    estoque.exibir();
                    break;

            }
        }
    }
}
