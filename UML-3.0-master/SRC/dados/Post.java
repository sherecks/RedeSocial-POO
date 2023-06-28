package dados;

import javax.swing.ImageIcon;

public class Post{

    private ImageIcon imagem;
    private String legenda;
    private Usuario autor;
    private int curtidas;

    //1° - Setters
    public void setImagem(ImageIcon imagem){
        this.imagem = imagem;
    }
    
    public void setLegenda(String legenda){
        this.legenda = legenda;
    }

    public void setAutor(Usuario autor){
        this.autor = autor;
    }

    public void setCurtidas(int curtidas){
        this.curtidas = curtidas;
    }


    //2° - Getters
    public ImageIcon getImagem(){
        return imagem;
    }
    public String getLegenda(){
        return legenda;
    }
    public Usuario getAutor(){
        return autor;
    }
    public int getCurtidas(){
        return curtidas;
    }
    public void curtir(){
        curtidas++;
    }

    //toString
    public String toString(){
        return "\nLegenda = " + legenda + "\nAutor = " + autor + "\n";
    }

}