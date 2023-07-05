package principal;

import negocios.Metodo;
import persistencia.Conexao;

import java.sql.Connection;
import java.sql.SQLException;

public class Main {

    // O IMPORTANTE!!!
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Connection conexao = Conexao.getConexao();
        Metodo login = new Metodo(conexao);
        Screen frame1 = new Screen(login);
        frame1.setVisible(true);
    }
}
//Deu boa!!!