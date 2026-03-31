import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Estoque estoque = new Estoque();
        MenuAdmin menuAdmin = new MenuAdmin(scanner,estoque);
        MenuCliente menuCliente = new MenuCliente(scanner,estoque);

        int opcao = -1;

        while (opcao != 0) {
            System.out.print("""
                    
                    === E-COMMERCE ===
                    1. Acesso Administrador (Estoque)
                    2. Acesso Cliente (Loja e Carrinho)
                    0. Desligar Sistema
                    ====================================
                    Escolha sua opção:""");

            opcao = scanner.nextInt();
            scanner.nextLine();

            if (opcao == 1) {
                menuAdmin.iniciar();

            } else if (opcao == 2) {

                menuCliente.iniciar();

            } else if (opcao == 0) {
                System.out.println("Desligando o sistema. Até logo.");

            } else {
                System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }
}