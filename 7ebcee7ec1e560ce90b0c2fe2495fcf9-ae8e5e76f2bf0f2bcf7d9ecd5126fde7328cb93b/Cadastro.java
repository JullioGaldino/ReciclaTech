public class Cadastro {
    private String nome;
    private String email;
    private String telefone;

    // Construtor
    public Cadastro(String nome, String email, String telefone) {
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
    }

    // Getters e Setters
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    // Método para exibir os dados
    public void exibirDados() {
        System.out.println("Nome: " + nome);
        System.out.println("Email: " + email);
        System.out.println("Telefone: " + telefone);
    }

    // Método principal para testes
    public static void main(String[] args) {
        Cadastro usuario = new Cadastro("João Silva", "joao@email.com", "11999999999");
        usuario.exibirDados();
    }
}

