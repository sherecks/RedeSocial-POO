package persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {

    private static Connection connection = null;

    private Conexao(){}

    public static Connection getConexao() throws ClassNotFoundException, SQLException{

        if(connection == null){
            String url = "jdbc:postgresql://localhost:5432/RedeSocial";
            String usuario = "postgres";
            String senha = "1620";
            connection = DriverManager.getConnection(url, usuario, senha);
        }

        return connection;
    }

    
}
