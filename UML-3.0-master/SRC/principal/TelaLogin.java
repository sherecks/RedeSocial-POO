package principal;

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
    private JLabel tituloLabel, titulo1;
    private JButton loginUsuario; 

    public TelaLogin(){

        field = new JPanel();
        fieldText = new JPanel();
        fieldButton = new JPanel();
        field.setBorder(BorderFactory.createEmptyBorder(200, 20, 10, 20));
        field.setBackground(Color.GRAY);

        Container c = getContentPane();
        Login sistema = new Login();

        titulo1 = new JLabel("Digite Email e Senha:");
        field.add(titulo1);

        //TEXTFIELD
        tituloLabel = new JLabel("LOGIN");
        fieldText.add(tituloLabel, BorderLayout.CENTER);

        emailUsuario = new JTextField();
        emailUsuario.setColumns(20);
        field.add(emailUsuario, BorderLayout.CENTER);

        senhaUsuario = new JTextField();
        senhaUsuario.setColumns(20);
        field.add(senhaUsuario, BorderLayout.CENTER);

        loginUsuario = new JButton("Login");
        fieldButton.add(loginUsuario, BorderLayout.CENTER); 

        c.add(field, BorderLayout.CENTER);
        c.add(fieldText, BorderLayout.NORTH);
        c.add(fieldButton, BorderLayout.SOUTH);
        setSize(400, 640);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);


        loginUsuario.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e){
                TelaPrincipal tela = new TelaPrincipal();

                String email = emailUsuario.getText();
                String senha = senhaUsuario.getText();

                sistema.fazerLogin(email, senha);

                if(email.isEmpty() || senha.isEmpty()){
                    JOptionPane.showMessageDialog(field, "Login não realizado com sucesso.");
                }else{ 
                    tela.setVisible(true);
                    setVisible(false);
                    JOptionPane.showMessageDialog(field, "Login realizado com sucesso.");         
                }
            }
        });
    }
}
