import java.util.List;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        XDAO xdao = new XDAO();
        Scanner scanner = new Scanner(System.in);

        int opcao;
        do {
            System.out.println("\nMenu:");
            System.out.println("1. Listar");
            System.out.println("2. Inserir");
            System.out.println("3. Excluir");
            System.out.println("4. Atualizar");
            System.out.println("5. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine(); // Consumir a nova linha

            switch (opcao) {
                case 1:
                    // Listar
                    List<X> xs = xdao.listar();
                    for (X x : xs) {
                        System.out.println(x);
                    }
                    break;

                case 2:
                    // Inserir
                    System.out.print("Digite o nome: ");
                    String nome = scanner.nextLine();
                    System.out.print("Digite o valor: ");
                    double valor = scanner.nextDouble();
                    X novoX = new X(nome, valor);
                    xdao.inserir(novoX);
                    System.out.println("Registro inserido com sucesso.");
                    break;

                case 3:
                    // Excluir
                    System.out.print("Digite o ID do registro a excluir: ");
                    int idExcluir = scanner.nextInt();
                    xdao.excluir(idExcluir);
                    System.out.println("Registro excluído com sucesso.");
                    break;

                case 4:
                    // Atualizar
                    System.out.print("Digite o ID do registro a atualizar: ");
                    int idAtualizar = scanner.nextInt();
                    scanner.nextLine(); // Consumir a nova linha
                    System.out.print("Digite o novo nome: ");
                    String novoNome = scanner.nextLine();
                    System.out.print("Digite o novo valor: ");
                    double novoValor = scanner.nextDouble();
                    X atualizarX = new X(idAtualizar, novoNome, novoValor);
                    xdao.atualizar(atualizarX);
                    System.out.println("Registro atualizado com sucesso.");
                    break;

                case 5:
                    // Sair
                    System.out.println("Saindo...");
                    break;

                default:
                    System.out.println("Opção inválida.");
            }
        } while (opcao != 5);

        scanner.close();
    }
}
