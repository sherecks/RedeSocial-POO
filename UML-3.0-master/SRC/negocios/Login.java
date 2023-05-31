package negocios;

import dados.Usuario;
import dados.Post;

import java.util.ArrayList;
import java.util.List;

public class Login {

    public Usuario [] usuarios = new Usuario[500];
    int contUser = 0;

    private Usuario usuarioLogado;

    public int getContUser(){
        return contUser;
    }

    public Usuario getUsuarioLogado() {
        return usuarioLogado;
    }
    
    public void setUsuarioLogado(Usuario usuario) {
        usuarioLogado = usuario;
    }

    private List<Post> posts = new ArrayList<>();

    //1°
    public void setUsuarios(Usuario[] usuarios){
        this.usuarios = usuarios;
    }

    //2°
    public Usuario[] getUsuarios() {
        return usuarios;
    }

    //Funçãozinha - Cadastro, Curtir, Seguir, Login.

    public void cadastrarUser(String nome, String email, String senha) {
        Usuario user = new Usuario();
        user.setNome(nome);
        user.setEmail(email);
        user.setSenha(senha);
        usuarios[contUser] = user;
        contUser++;
    }

    public Usuario [] mostrarUsuarios(){
        return usuarios;
    }

    public void publicar(Post post) {
        posts.add(post);
    }

    public List<Post> mostrarPosts() { 
        return posts;
    }

    public void darLike(Usuario usuario, Post post){
        usuario.darLike(post);
    }

    public void seguir(Usuario usuario){
        usuario.seguir(usuario);
    }

    public void desseguir(Usuario usuario){
        usuario.desseguir(usuario);
    }

    public Usuario fazerLogin(String email, String senha) {
        for (int i = 0; i < contUser; i++) {
            if (usuarios[i].getEmail().trim().equals(email.trim()) && usuarios[i].getSenha().trim().equals(senha.trim())) {
                setUsuarioLogado(usuarios[i]);
                return usuarios[i];
            }
        }
        return null;
    }

}
