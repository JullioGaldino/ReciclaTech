package com.example.ReciclaTech;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class CadastroUsuario {
    private static final String URL = "jdbc:mysql://localhost:3306/ReciclaTech_BD";
    private static final String USUARIO = "root"; // Altere para o usuário do seu banco
    private static final String SENHA = "@Caesares06"; // Altere para a senha do seu banco

    public static Connection conectar() throws SQLException {
        return DriverManager.getConnection(URL, USUARIO, SENHA);
    }

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

        // Inserir no banco de dados
        try (Connection conn = conectar()) {
            String sql = "INSERT INTO usuarios (nome, email, senha) VALUES (?, ?, ?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, nome);
            stmt.setString(2, email);
            stmt.setString(3, senha);

            stmt.executeUpdate();
            System.out.println("Cadastro realizado com sucesso!");

        } catch (SQLException e) {
            System.out.println("Erro ao cadastrar usuário: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        cadastrarUsuario(scanner);
        scanner.close();
    }
}
