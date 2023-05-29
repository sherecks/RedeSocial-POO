package principal;

import dados.Usuario;
import dados.Post;
import negocios.Login;

import java.util.Scanner;
//import javax.swing.JFrame;
//import javax.swing.JPanel;


//import java.awt.BorderLayout;
//import java.awt.Container;

public class Main {

    static Scanner s = new Scanner(System.in);
    private static Login sistema = new Login();

    // Cadastro!!!
    public static void cadastrarUser() {
        Usuario user = new Usuario();

        System.out.println("\nNome do Usuario: ");
        user.setNome(s.nextLine());

        System.out.println("\nEmail do Usuario: ");
        user.setEmail(s.nextLine());

        System.out.println("\nSenha do Usuario: ");
        user.setSenha(s.nextLine());

        sistema.cadastrarUser(user);
    }

    public static void logar() {
        Login login = new Login();

        System.out.println("\nEmail do Usuario: ");
        String x1 = s.nextLine();

        System.out.println("\nSenha do Usuario: ");
        String x2 = (s.nextLine());

        Usuario usuarioLogado = login.fazerLogin(x1, x2);

        if (usuarioLogado != null) {
            System.out.println("Login realizado com sucesso!");
        } else {
            System.out.println("Usuário não encontrado ou senha incorreta.");
        }

    }

    // Publicar!!!
    public static void publicar() {
        Post poster = new Post();

        System.out.println("Legenda: ");
        poster.setLegenda(s.nextLine());

        System.out.println("Autor: ");
        poster.setAutor(s.nextLine());

        sistema.publicar(poster);
    }

    // Exibir Users
    public static void exibirUsuarios() {
        Usuario[] usuarios = sistema.mostrarUsuarios();

        if (usuarios == null) {
            System.out.println("Não há usuários cadastrados!!");
        } else {
            for (int i = 0; i < usuarios.length; i++) {
                if (usuarios[i] == null) {
                    break;
                } else {
                    System.out.println(usuarios[i].toString());
                }
            }
        }
    }

    // Exibir Posts
    public static void exibirPosts() {
        Post[] posts = sistema.mostrarPosts();

        if (posts == null) {
            System.out.println("Não há Posts!!");
        } else {
            for (int i = 0; i < posts.length; i++) {
                if (posts[i] == null) {
                    break;
                } else {
                    System.out.println(posts[i].toString());
                }
            }
        }

    }

    // Seguir
    public static void seguir() {

        System.out.println("Digite o nome do usuário que deseja seguir: ");
        String nomeSeguido = s.nextLine();

        System.out.println("Digite o seu nome de usuário: ");
        String nomeSeguidor = s.nextLine();

        Usuario seguido = null;
        for (Usuario u : sistema.mostrarUsuarios()) {
            if (u != null && u.getNome().equals(nomeSeguido)) {
                seguido = u;
                break;
            }
        }

        Usuario seguidor = null;
        for (Usuario u : sistema.mostrarUsuarios()) {
            if (u != null && u.getNome().equals(nomeSeguidor)) {
                seguidor = u;
                break;
            }
        }

        if (seguido == null || seguidor == null) {
            System.out.println("Usuário não encontrado.");
            return;
        }

        seguidor.seguir(seguido);
        System.out.println("Usuário seguido com sucesso!");

    }

    // Desseguir
    public static void desseguir() {

        System.out.println("Digite o nome do usuário que deseja desvincular: ");
        String nomeDesseguido = s.nextLine();

        System.out.println("Digite o seu nome de usuário: ");
        String nomeDsseguidor = s.nextLine();

        Usuario seguido = null;
        for (Usuario u : sistema.mostrarUsuarios()) {
            if (u != null && u.getNome().equals(nomeDesseguido)) {
                seguido = u;
                break;
            }
        }

        Usuario seguidor = null;
        for (Usuario u : sistema.mostrarUsuarios()) {
            if (u != null && u.getNome().equals(nomeDsseguidor)) {
                seguidor = u;
                break;
            }
        }

        if (seguido == null || seguidor == null) {
            System.out.println("Usuário não encontrado.");
            return;
        }

        seguidor.desseguir(seguido);
        System.out.println("Usuário desvinculado com sucesso!");

    }

    // DarLike no Post
    public static void darLike() {
        // Usuario
        System.out.println(("Digite o nome do usuario: "));
        String x1 = s.nextLine();
        Usuario usuario = null;
        for (Usuario u : sistema.mostrarUsuarios()) {
            if (u != null && u.getNome().equals(x1)) {
                usuario = u;
                break;
            }
        }

        if (usuario == null) {
            System.out.println("Usuário não encontrado.");
            return;
        }
        // Post
        System.out.println(("Digite o autor: "));
        String x2 = s.nextLine();
        Post post = null;
        for (Post p : sistema.mostrarPosts()) {
            if (p != null && p.getAutor().equals(x2)) {
                post = p;
                break;
            }
        }

        if (post == null) {
            System.out.println("Post não encontrado.");
            return;
        }

        post.adicionarLike(usuario);
        System.out.println("Like adicionado com sucesso!");
    }


    // O IMPORTANTE!!!
    public static void main(String[] args) {

        cadastrarUser();
        logar();

        TelaCadastro frame2 = new TelaCadastro();
        Screen frame1 = new Screen();
        TelaPrincipal frame3 = new TelaPrincipal();
        TelaLogin frame4 = new TelaLogin();

        frame1.setVisible(true);
        frame2.setVisible(false);
        frame3.setVisible(false);
        frame4.setVisible(false);
    }

}
