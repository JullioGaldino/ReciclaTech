import java.util.Scanner;

public class Login {
    private String usuario;
    private String senha;

    // Construtor
    public Login(String usuario, String senha) {
        this.usuario = usuario;
        this.senha = senha;
    }

    // Método para autenticar usuário
    public boolean autenticar(String usuario, String senha) {
        return this.usuario.equals(usuario) && this.senha.equals(senha);
    }

    public static void main(String[] args) {
        // Criando um login com usuário e senha pré-definidos
        Login login = new Login("admin", "1234");

        // Entrada do usuário
        Scanner scanner = new Scanner(System.in);

        System.out.print("Usuário: ");
        String usuarioInput = scanner.nextLine();

        System.out.print("Senha: ");
        String senhaInput = scanner.nextLine();

        // Verificação de login
        if (login.autenticar(usuarioInput, senhaInput)) {
            System.out.println("Login bem-sucedido! Bem-vindo, " + usuarioInput);
        } else {
            System.out.println("Usuário ou senha incorretos!");
        }

        scanner.close();
    }
}
