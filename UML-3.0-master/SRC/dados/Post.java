package dados;

import java.awt.Image;
import java.util.ArrayList;
import java.util.List;

public class Post{

    private Image imagem;
    private String legenda;
    private String autor;
    private List<Usuario> likes = new ArrayList<>();

    //1° - Setters
    public void setImagem(Image imagem){
        this.imagem = imagem;
    }
    
    public void setLegenda(String legenda){
        this.legenda = legenda;
    }

    public void setAutor(String autor){
        this.autor = autor;
    }

    public void setCurtidas(List<Usuario> likes){
        this.likes = likes;
    }


    //2° - Getters
    public Image getImagem(){
        return imagem;
    }
    public String getLegenda(){
        return legenda;
    }
    public String getAutor(){
        return autor;
    }
    public List<Usuario> getCurtidas(){
        return likes;
    }


    //Funçãozinha
    public void adicionarLike(Usuario usuario){
        likes.add(usuario);
    }

    //toString
    public String toString(){
        return "\nLegenda = " + legenda + "\nAutor = " + autor + "\n" + "\nLikes = " + likes;
    }

}