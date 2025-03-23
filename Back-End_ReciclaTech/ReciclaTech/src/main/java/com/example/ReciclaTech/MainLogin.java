import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class GerenciadorUsuarios {
    private static Map<String, String> usuarios = new HashMap<>();

    public static void cadastrarUsuario(Scanner scanner) {
        System.out.println("Cadastro de Usuário");
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

        usuarios.put(email, senha);
        System.out.println("Cadastro realizado com sucesso!");
    }

    public static Map<String, String> getUsuarios() {
        return usuarios;
    }
}

class LoginUsuario {
    public static void realizarLogin(Scanner scanner, Map<String, String> usuarios) {
        System.out.println("\nLogin de Usuário");
        boolean loginSucesso = false;

        while (!loginSucesso) {
            System.out.print("E-mail: ");
            String emailLogin = scanner.nextLine();

            System.out.print("Senha: ");
            String senhaLogin = scanner.nextLine();

            if (usuarios.containsKey(emailLogin) && usuarios.get(emailLogin).equals(senhaLogin)) {
                System.out.println("Login realizado com sucesso!");
                loginSucesso = true;
            } else {
                System.out.println("E-mail ou senha incorretos. Tente novamente.");
            }
        }
    }
}

public class MainLogin {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        GerenciadorUsuarios.cadastrarUsuario(scanner);
        LoginUsuario.realizarLogin(scanner, GerenciadorUsuarios.getUsuarios());
        scanner.close();
    }
}
