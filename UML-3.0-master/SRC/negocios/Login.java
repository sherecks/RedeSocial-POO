package negocios;

import dados.Usuario;
import dados.Post;

import java.util.ArrayList;
import java.util.List;

public class Login {

    public Usuario [] usuarios = new Usuario[500];
    int contUser = 0;

    private List<Post> posts = new ArrayList<>();

    //1°
    public void setUsuarios(Usuario[] usuarios){
        this.usuarios = usuarios;
    }

    //2°
    public Usuario[] getUsuarios() {
        return usuarios;
    }

    //Funçãozinha - Cadastro, Exibição, Curtir, Seguir, Login.

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

    public boolean fazerLogin(String email, String senha) {
        for (int i = 0; i < contUser; i++) {
            if (usuarios[i].getEmail().equals(email) && usuarios[i].getSenha().equals(senha)) {
                return true;
            }
        }
        return false;
    }

}
