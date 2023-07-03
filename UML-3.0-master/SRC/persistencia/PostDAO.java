package persistencia;

import dados.*;

import excecoes.InsertException;
import excecoes.SelectException;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import javax.swing.ImageIcon;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class PostDAO {

    private static PostDAO instance = null;
    private PreparedStatement selectNewId;
    private PreparedStatement selectPost;
    private PreparedStatement insertPost;
    private PreparedStatement selectAll;

    public static PostDAO getInstance() throws ClassNotFoundException, SQLException, SelectException {
        if(instance == null){
            instance = new PostDAO();
        }
        return instance;
    }

    private PostDAO() throws ClassNotFoundException, SQLException, SelectException{
        Connection cox = Conexao.getConexao();
        selectNewId = cox.prepareStatement("select nextVal('id')");
        insertPost = cox.prepareStatement("insert into post values(?, ?, ?, ?, ?, ?)");
        selectPost = cox.prepareStatement("select * from post where id = ?");
        selectAll = cox.prepareStatement("select * from post");
    }

    private int selectNewId() throws SelectException{
        try{
            ResultSet rs = selectNewId.executeQuery();
            if(rs.next()){
                return rs.getInt(1);
            }
        } catch (SQLException e) {
            throw new SelectException("Erro ao buscar Post!!!");
        }
        return 0;
    }


    public void insert(Post post) throws InsertException, SelectException{

        int novoId = selectNewId();
        try{
            insertPost.setInt(1, novoId);
            insertPost.setObject(2, post.getImagem());
            insertPost.setString(3, post.getLegenda());
            insertPost.setObject(4, post.getAutor());
        } catch (SQLException e){
            throw new InsertException("Erro ao buscar Post!!!");
        }
    }

    public Post select(int postId) throws SelectException, ClassNotFoundException {
    try {
        selectPost.setInt(1, postId);
        ResultSet rs = selectPost.executeQuery();
        if (rs.next()) {
            int id = rs.getInt(1);
            ImageIcon imagem = (ImageIcon) rs.getObject("imagem");
            String legenda = rs.getString("legenda");
            int curtidas = rs.getInt("curtidas");

            UsuarioDAO usuarioDAO = UsuarioDAO.getInstance();
            Usuario autor = usuarioDAO.select(id);
            
            Post post = new Post();
            post.setId(id);
            post.setImagem(imagem);
            post.setLegenda(legenda);
            post.setAutor(autor);
            post.setCurtidas(curtidas);
            
            return post;
        }
    } catch (SQLException e) {
        throw new SelectException("Erro ao buscar post!!!");
    }
    return null;
    }

    public List<Post> selectAll() throws SelectException{

        List<Post> posts = new LinkedList<Post>();

        try{
            ResultSet rs = selectAll.executeQuery();
            while(rs.next()){
                Post post = new Post();
                post.setId(rs.getInt(1));
                post.setLegenda(rs.getString(2));
                post.setCurtidas(rs.getInt(5));

                posts.add(post);
            }
        } catch (SQLException e) {
            throw new SelectException("Erro ao buscar Usuario!!!");
        }
        return posts;
    }
    
}
