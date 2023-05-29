package negocios;

import dados.Usuario;
import dados.Post;

public class Login {

    public Usuario [] usuarios = new Usuario[500];
    int contUser = 0;

    public Post [] posts = new Post[500];
    int contPost = 0;

    //1°
    public void setUsuarios(Usuario[] usuarios){
        this.usuarios = usuarios;
    }

    public void setPosts(Post[] posts){
        this.posts = posts;
    }

    //2°
    public Usuario[] getUsuarios() {
        return usuarios;
    }

    public Post[] getPosts() {
        return posts;
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

    public void publicar(Post post){
        posts[contPost] = post;
        contPost++;
    }

    public Post [] mostrarPosts(){
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
