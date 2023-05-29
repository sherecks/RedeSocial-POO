package principal;

import javax.swing.*;
import java.awt.*;

public class TelaPrincipal extends JFrame {

    private JButton usuariosButton;
    private JButton publicarButton;
    private JLabel exibirPosts;
    private JButton curtirButton;
    private JButton seguirButton;
    private JButton desseguirButton;
    private ImageIcon icon;

    private JPanel field;
    private JPanel interactionPanel;
    private JPanel vision;

    public TelaPrincipal() {
        Container c = getContentPane();

        vision = new JPanel();
        field = new JPanel();
        vision.setLayout(new BorderLayout());
        vision.setBackground(Color.GRAY);
        vision.setBorder(BorderFactory.createEmptyBorder(10, 22, 10, 22));

        usuariosButton = new JButton("Usuário");
        field.add(usuariosButton, BorderLayout.NORTH);

        icon = new ImageIcon(getClass().getResource("IMAGEM.png"));
        exibirPosts = new JLabel(icon);
        icon.setImage(icon.getImage().getScaledInstance(220, 220, 100));
        vision.add(exibirPosts);
 

        interactionPanel = new JPanel();

        publicarButton = new JButton("Publicar");
        interactionPanel.add(publicarButton);

        curtirButton = new JButton("Curtir");
        interactionPanel.add(curtirButton);

        seguirButton = new JButton("Seguir");
        interactionPanel.add(seguirButton);

        desseguirButton = new JButton("Desseguir");
        interactionPanel.add(desseguirButton);

        c.add(field, BorderLayout.NORTH);
        c.add(vision, BorderLayout.CENTER);
        c.add(interactionPanel, BorderLayout.SOUTH);
        setSize(480, 640);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

    }

}
