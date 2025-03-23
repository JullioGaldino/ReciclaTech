import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoDB {
    private static final String URL = "jdbc:mysql://localhost:3306/sistema_login";
    private static final String USUARIO = "root"; // Altere para o usuário do seu banco
    private static final String SENHA = "@Caesares06"; // Altere para a senha do seu banco

    public static Connection conectar() throws SQLException {
        return DriverManager.getConnection(URL, USUARIO, SENHA);
    }
}
