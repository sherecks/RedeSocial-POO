package negocios;

import dados.Usuario;
import excecoes.InsertException;
import excecoes.SelectException;
import excecoes.UpdateException;
import persistencia.PostDAO;
import persistencia.UsuarioDAO;

import java.sql.Connection;
import java.sql.SQLException;

import java.util.ArrayList;
import java.util.List;

public class Metodo {

    private List<Usuario> usuarios = new ArrayList<>();
    int contUser = 0;

    private UsuarioDAO usuarioDAO;
    private PostDAO postDAO;
    private Usuario usuarioLogado;

    public List<Usuario> getUsuarios() {
        return this.usuarios;
    }

    public Usuario getUsuarioLogado() {
        return usuarioLogado;
    }
    
    public void setUsuarioLogado(Usuario usuario) {
        usuarioLogado = usuario;
    }   

    // Metodo!!!
    public Metodo(Connection conexao) {
        try {
            usuarioDAO = UsuarioDAO.getInstance();
            postDAO = PostDAO.getInstance();
            usuarios = usuarioDAO.selectAll();
        } catch (ClassNotFoundException | SQLException | SelectException e) {
            e.printStackTrace();
        }
    }

    
    // Funçãozinha
    public void cadastrarUser(String nome, String email, String senha) {
       try {
            Usuario usuario = new Usuario();
            usuario.setNome(nome);
            usuario.setEmail(email);
            usuario.setSenha(senha);

            // Obter novo ID do banco de dados
            int novoId = usuarioDAO.selectNewId();
            usuario.setId(novoId);

            // Inserir o usuário no banco de dados
            usuarioDAO.insert(usuario);

            usuarios.add(usuario);
        } catch (InsertException | SelectException e) {
            e.printStackTrace();
        }
    }

    public List<Usuario> mostrarUsuarios() {
        return this.usuarios;
    }

    public void seguir(Usuario seguido) {
        if (usuarioLogado != null && seguido != null) {
            usuarioLogado.seguir(seguido);
            try {
                usuarioDAO.updateUsuario(usuarioLogado);
            } catch (UpdateException e) {
                e.printStackTrace();
            }
        }
    }

    public void desseguir(Usuario seguido) {
        if (usuarioLogado != null && seguido != null) {
            usuarioLogado.desseguir(seguido);
            try {
                usuarioDAO.updateUsuario(usuarioLogado);
            } catch (UpdateException e) {
                e.printStackTrace();
            }
        }
    }

    public Usuario fazerLogin(String email, String senha) {
        try {
            for (Usuario user : this.usuarios) {
                if (user.getEmail().trim().equals(email.trim()) && user.getSenha().trim().equals(senha.trim())) {
                    setUsuarioLogado(user);
                    return user;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
