package principal;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.*;


public class Screen01 extends JFrame{

    private JButton usuariosButton;
    private JButton publicarButton;
    private JButton exibirPostsButton;
    private JButton curtirButton;
    private JButton seguirButton;
    private JButton desseguirButton;
    private JPanel interactionPanel;

    private JPanel vision;

    public Screen01(){
        Container c = getContentPane();

        vision = new JPanel();
        vision.setLayout(new BorderLayout());

       
        usuariosButton = new JButton("1 - Usuários");
        vision.add(usuariosButton, BorderLayout.NORTH);

    
        publicarButton = new JButton("2 - Publicar");
        vision.add(publicarButton, BorderLayout.CENTER);
        publicarButton.setBackground(Color.GRAY);
       
        interactionPanel = new JPanel();
    
        exibirPostsButton = new JButton("3 - Exibir Posts");
        interactionPanel.add(exibirPostsButton);
       
    
        curtirButton = new JButton("4 - Curtir");
        interactionPanel.add(curtirButton);
        
    
        seguirButton = new JButton("5 - Seguir");
        interactionPanel.add(seguirButton);
        
       
        desseguirButton = new JButton("6 - Desseguir");
        interactionPanel.add(desseguirButton);
        
    
        c.add(vision, BorderLayout.CENTER);
        c.add(interactionPanel, BorderLayout.SOUTH);
        setSize(480, 640);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
    }
    

    
}
