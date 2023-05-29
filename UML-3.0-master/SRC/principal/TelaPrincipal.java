package principal;

import javax.swing.*;
import java.awt.*;


public class TelaPrincipal extends JFrame{

    private JButton usuariosButton;
    private JButton publicarButton;
    private JLabel exibirPosts;
    private JButton curtirButton;
    private JButton seguirButton;
    private JButton desseguirButton;
    private JPanel interactionPanel;

    private JPanel vision;

    public TelaPrincipal(){
        Container c = getContentPane();

        vision = new JPanel();
        vision.setLayout(new BorderLayout());

       
        usuariosButton = new JButton("Usuário");
        vision.add(usuariosButton, BorderLayout.NORTH);

    
        publicarButton = new JButton("Publicar");
        vision.add(publicarButton, BorderLayout.CENTER); 
       
        interactionPanel = new JPanel();
    
        exibirPosts = new JLabel(new ImageIcon("SRC/principal/IMAGEM.jpg"));
        vision.add(exibirPosts);
        exibirPosts.setBackground(Color.GRAY);
       
    
        curtirButton = new JButton("Curtir");
        interactionPanel.add(curtirButton);
        
    
        seguirButton = new JButton("Seguir");
        interactionPanel.add(seguirButton);
        
       
        desseguirButton = new JButton("Desseguir");
        interactionPanel.add(desseguirButton);
        
    
        c.add(vision, BorderLayout.CENTER);
        c.add(interactionPanel, BorderLayout.SOUTH);
        setSize(480, 640);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        
    }
    

    
}
