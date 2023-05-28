package principal;

import javax.swing.*;
import java.awt.*;

public class Screen02 extends JFrame {

    private JPanel field;
    private JPanel fieldText;
    private JPanel fieldButton;

    private JTextField emailUsuario;
    private JTextField senhaUsuario;
    private JLabel tituloLabel;
    private JButton loginUsuario;

    public Screen02(){

        field = new JPanel();
        fieldText = new JPanel();
        fieldButton = new JPanel();
        field.setBorder(BorderFactory.createEmptyBorder(180, 10, 10, 10));
        field.setBackground(Color.GRAY);

        Container c = getContentPane();


        //TEXTFIELD
        tituloLabel = new JLabel("CADASTRO");
        fieldText.add(tituloLabel, BorderLayout.CENTER);

        emailUsuario = new JTextField("Email");
        emailUsuario.setColumns(20);
        field.add(emailUsuario, BorderLayout.CENTER);

        senhaUsuario = new JTextField("Senha");
        senhaUsuario.setColumns(20);
        field.add(senhaUsuario, BorderLayout.CENTER);

        loginUsuario = new JButton("Login");
        fieldButton.add(loginUsuario, BorderLayout.CENTER);

        c.add(field, BorderLayout.CENTER);
        c.add(fieldText, BorderLayout.NORTH);
        c.add(fieldButton, BorderLayout.SOUTH);
        setSize(400, 640);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
