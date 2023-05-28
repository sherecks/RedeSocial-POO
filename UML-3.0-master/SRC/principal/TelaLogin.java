package principal;

import dados.Usuario;
import negocios.Login;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaLogin extends JFrame {

    private JPanel field;
    private JPanel fieldText;
    private JPanel fieldButton;

    private JTextField emailUsuario;
    private JTextField senhaUsuario;
    private JLabel tituloLabel;
    private JButton loginUsuario;

    public TelaLogin(){

        field = new JPanel();
        fieldText = new JPanel();
        fieldButton = new JPanel();
        field.setBorder(BorderFactory.createEmptyBorder(180, 10, 10, 10));
        field.setBackground(Color.GRAY);

        Container c = getContentPane();
        Login sistema = new Login();


        //TEXTFIELD
        tituloLabel = new JLabel("LOGIN");
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


        loginUsuario.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e){
                TelaPrincipal tela = new TelaPrincipal();

                String email = emailUsuario.getText();
                String senha = senhaUsuario.getText();

                sistema.fazerLogin(email, senha);

                if(email != null || senha != null){
                    tela.setVisible(true);
                    setVisible(false);
                    JOptionPane.showMessageDialog(field, "Login realizado com sucesso.");
                }else{
                    JOptionPane.showMessageDialog(field, "Login não realizado com sucesso.");           
                }
            }
        });
    }
}
