package negocios;

import dados.Usuario;

import java.util.ArrayList;
import java.util.List;

public class Metodo {

    private List<Usuario> usuarios = new ArrayList<>();
    int contUser = 0;

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


    // Funçãozinha
    public void cadastrarUser(String nome, String email, String senha) {
        Usuario user = new Usuario();
        user.setNome(nome);
        user.setEmail(email);
        user.setSenha(senha);
        this.usuarios.add(user);
    }

    public List<Usuario> mostrarUsuarios() {
        return this.usuarios;
    }

    public void seguir(Usuario usuario){
        usuario.seguir(usuario);
    }

    public void desseguir(Usuario usuario){
        usuario.desseguir(usuario);
    }

    public Usuario fazerLogin(String email, String senha) {
        for (Usuario user : this.usuarios) {
            if (user.getEmail().trim().equals(email.trim()) && user.getSenha().trim().equals(senha.trim())) {
                setUsuarioLogado(user);
                return user;
            }
        }
        return null;
    }

}
