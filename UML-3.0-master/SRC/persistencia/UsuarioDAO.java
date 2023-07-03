package persistencia;

import dados.*;

import excecoes.InsertException;
import excecoes.SelectException;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UsuarioDAO {

    private static UsuarioDAO instance = null;
    private PreparedStatement selectNewId;
    private PreparedStatement selectUsuario;
    private PreparedStatement insertUsuario;
    private PreparedStatement selectAll;

    public static UsuarioDAO getInstance() throws ClassNotFoundException, SQLException, SelectException{
        if ( instance == null)
            instance = new UsuarioDAO();
        return instance;
    } 

    private UsuarioDAO() throws ClassNotFoundException, SQLException, SelectException{
        Connection cox = Conexao.getConexao();
        selectNewId = cox.prepareStatement("select nextVal('id')");
        insertUsuario = cox.prepareStatement("insert into usuario values(?, ?, ?, ?, ?, ?)");
        selectUsuario = cox.prepareStatement("select * from usuario where id_character = ?");
        selectAll = cox.prepareStatement("select * from usuario");
    }

    private int selectNewId() throws SelectException{
        try{
            ResultSet rs = selectNewId.executeQuery();
            if(rs.next()){
                return rs.getInt(1);
            }
        } catch (SQLException e) {
            throw new SelectException("Erro ao buscar novo id da tabela usuarios");
        }
        return 0;
    }

    public void insert(Usuario usuario) throws InsertException, SelectException{
        try{
            insertUsuario.setString(2, usuario.getNome());
            insertUsuario.setString(3, usuario.getEmail());
            insertUsuario.setString(4, usuario.getSenha());
            insertUsuario.setObject(5, usuario.getSeguidos());
            insertUsuario.setObject(6, usuario.getSeguidores());
            insertUsuario.setObject(7, usuario.getPost());
        } catch (SQLException e){
            throw new InsertException("Erro ao inserir Usuario!!!");
        }
    }

    public Usuario select(int usuario) throws SelectException{
        try{
            selectUsuario.setInt(1, usuario);
            ResultSet rs = selectUsuario.executeQuery();
            if(rs.next()) {
                int id = rs.getInt(1);
                String nome = rs.getString(2);
                String email = rs.getString(3);
                String senha = rs.getString(4);
                List<Usuario> seguidos = rs.getString(5);

            }

        }catch (SQLException e){
            throw new SelectException("Erro ao buscar endereço de pessoa");
        }
        return null;
    }
    
}
