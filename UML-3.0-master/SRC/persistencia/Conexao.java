package persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
    
    private static Connection connection = null;
    private static String senha;

    private Conexao(){}

    public static void setSenha(String senha){
        senha = "1620";
    }

    public static Connection getConexao() throws ClassNotFoundException, SQLException{
        try {
            
            if(connection == null){
                String url = "jdbc:postgresql://localhost:5432/RedeSocial";
                String usuario = "postgres";
                Class.forName("org.postgresql.Driver");
                connection = DriverManager.getConnection(url, usuario, senha);
            }

            return connection;
        } catch (ClassNotFoundException e) {
            throw new ClassNotFoundException("Driver JDBC não encontrado.", e);
        } catch (SQLException e) {
            throw new SQLException("Erro ao estabelecer a conexão com o banco de dados.", e);
        }
    }
}
