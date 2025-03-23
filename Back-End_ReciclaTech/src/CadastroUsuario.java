import java.util.Scanner;

public class CadastroUsuario {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Nome: ");
        String nome = scanner.nextLine();

        System.out.print("E-mail: ");
        String email = scanner.nextLine();

        String senha;
        String confirmacaoSenha;

        while (true) {
            System.out.print("Senha: ");
            senha = scanner.nextLine();

            System.out.print("Confirme a senha: ");
            confirmacaoSenha = scanner.nextLine();

            if (senha.equals(confirmacaoSenha)) {
                break;
            } else {
                System.out.println("As senhas não coincidem. Tente novamente.");
            }
        }

        System.out.println("Cadastro realizado com sucesso!");
        System.out.println("Nome: " + nome);
        System.out.println("E-mail: " + email);

        scanner.close();
    }
}
