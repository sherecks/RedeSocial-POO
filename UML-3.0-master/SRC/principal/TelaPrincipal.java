package principal;

import javax.swing.*;
import java.awt.*;
import dados.*;
import negocios.Login;
import javax.swing.filechooser.FileNameExtensionFilter;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

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


        //EVENTO

        seguirButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Login sistema = new Login();
                String nomeSeguido = JOptionPane.showInputDialog(null, "Digite o nome do usuário a ser seguido:");
                String nomeSeguidor = JOptionPane.showInputDialog(null, "Digite o nome do usuário seguidor:");
        
                if (nomeSeguido != null && nomeSeguidor != null) {
                    
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
                        JOptionPane.showMessageDialog(null, "Usuário não encontrado.");
                    } else {
                        seguidor.seguir(seguido);
                        JOptionPane.showMessageDialog(null, "Usuário seguido com sucesso!");
                    }
                } else {
                    // O usuário cancelou a entrada dos nomes
                }
            }
        });


        publicarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Login sistema = new Login();
                Post poster = new Post();

                String legenda = JOptionPane.showInputDialog(null, "Digite a legenda:");
                String autor = JOptionPane.showInputDialog(null, "Digite o autor:");

                if (legenda != null && autor != null) {
                    poster.setLegenda(legenda);
                    poster.setAutor(autor);

                    // Selecionar a imagem usando JFileChooser
                    JFileChooser fileChooser = new JFileChooser();
                    fileChooser.setFileFilter(new FileNameExtensionFilter("Imagens", "jpg", "jpeg", "png", "gif"));
                    int result = fileChooser.showOpenDialog(null);

                    if (result == JFileChooser.APPROVE_OPTION) {
                        String imagePath = fileChooser.getSelectedFile().getPath();
                        poster.setImagem(imagePath);
                        sistema.publicar(poster);
                        JOptionPane.showMessageDialog(null, "Post publicado com sucesso!");
                    } else {
                        // O usuário cancelou a seleção da imagem
                    }
                                
                    JOptionPane.showMessageDialog(null, "Post publicado com sucesso!");
                } else {
                    // O usuário cancelou a entrada dos dados
                    JOptionPane.showMessageDialog(null, "Erro!");
                }
             }
        });

    }

}
