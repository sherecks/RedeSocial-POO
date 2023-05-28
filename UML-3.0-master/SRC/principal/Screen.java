package principal;

import javax.swing.*;

import java.awt.*;


import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Screen extends JFrame {

    private JPanel tags;
    private JPanel tagsText;
    private JLabel tituloLabel;
    private JButton cadastrarUsuarioButton;
    private JButton fazerLoginButton;
    private JLabel imagem;

    public Screen() {
       Container c = getContentPane();
       tags = new JPanel();
       tagsText = new JPanel();
       tags.setBorder(BorderFactory.createEmptyBorder(460, 10, 10, 10));
       tags.setBackground(Color.GRAY);

        tituloLabel = new JLabel("MENU");
        tagsText.add(tituloLabel, BorderLayout.CENTER);

        imagem = new JLabel(new ImageIcon("imagem.png"));
        tags.add(imagem);

        cadastrarUsuarioButton = new JButton("Cadastrar Usuario");
        tags.add(cadastrarUsuarioButton, BorderLayout.CENTER);

        fazerLoginButton = new JButton("Fazer Login");
        tags.add(fazerLoginButton, BorderLayout.CENTER);

        c.add(tags, BorderLayout.CENTER);
        c.add(tagsText, BorderLayout.NORTH);
        setSize(400, 640);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        


        //TESTE!!!

        cadastrarUsuarioButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed( ActionEvent arg0){
                TelaCadastro tela = new TelaCadastro();

                tela.setVisible(true);

                setVisible(false);
                
            }
        });

        //TESTE!!

        fazerLoginButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed( ActionEvent arg0){
                Screen01 screen = new Screen01();

                screen.setVisible(true);

                setVisible(false);
            }
        });

    }

}
