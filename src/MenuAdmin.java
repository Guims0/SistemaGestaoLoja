import java.util.Scanner;

public class MenuAdmin {
    private Scanner scanner;
    private Estoque estoque;

    public MenuAdmin(Scanner scanner, Estoque estoque) {
        this.scanner = scanner;
        this.estoque = estoque;
    }

    public void iniciar(){
        int opcao = -1;

        while (opcao != 0){

            System.out.println("""
                    === PAINEL DO ADMINISTRADOR ===
                         1. Cadastrar Produto
                         2. Excluir Produto
                         3. Ver Estoque Completo
                         0. Voltar ao Menu Principal
                    ===============================
                          Escolha uma opção:
                    """);
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao){
                case 1:
                    System.out.println("\n-- CADASTRAR NOVO PRODUTO --");
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
                    System.out.println("\n-- EXCLUIR PRODUTO --");
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
