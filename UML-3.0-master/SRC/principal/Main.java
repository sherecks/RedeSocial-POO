package principal;

import dados.Usuario;
import dados.Post;
import negocios.Login;

import java.util.Scanner;


public class Main {

    static Scanner s = new Scanner(System.in);
    private static Login sistema = new Login();

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
        Login login = new Login();
        Screen frame1 = new Screen(login);
        frame1.setVisible(true);
    }

}
