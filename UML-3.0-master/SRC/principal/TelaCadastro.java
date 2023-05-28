package principal;

import dados.Usuario;
import negocios.Login;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;



public class TelaCadastro extends JFrame {

    public String nome;
    public String email;
    public String senha;

    private JPanel field;
    private JPanel fieldText;
    private JPanel fieldButton;

    private JTextField emailUsuario;
    private JTextField nomeUsuario;
    private JTextField senhaUsuario;
    private JLabel tituloLabel;
    private JButton cadastrarUsuario;

    public TelaCadastro(){

        field = new JPanel();
        fieldText = new JPanel();
        fieldButton = new JPanel();
        field.setBorder(BorderFactory.createEmptyBorder(180, 10, 10, 10));
        field.setBackground(Color.GRAY);

        Container c = getContentPane(); 
        Login sistema = new Login();


        //TEXTFIELD
        tituloLabel = new JLabel("CADASTRO");
        fieldText.add(tituloLabel, BorderLayout.CENTER);

        nomeUsuario = new JTextField("Nome");
        nomeUsuario.setColumns(20);
        field.add(nomeUsuario, BorderLayout.CENTER);

        emailUsuario = new JTextField("Email");
        emailUsuario.setColumns(20);
        field.add(emailUsuario, BorderLayout.CENTER);

        senhaUsuario = new JTextField("Senha");
        senhaUsuario.setColumns(20);
        field.add(senhaUsuario, BorderLayout.CENTER);

        cadastrarUsuario = new JButton("Cadastrar");
        fieldButton.add(cadastrarUsuario, BorderLayout.CENTER);

        c.add(field, BorderLayout.CENTER);
        c.add(fieldText, BorderLayout.NORTH);
        c.add(fieldButton, BorderLayout.SOUTH);
        setSize(400, 640);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        cadastrarUsuario.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed( ActionEvent e){
                Screen01 tela = new Screen01();

                String nome = nomeUsuario.getText();
                String email = emailUsuario.getText();
                String senha = senhaUsuario.getText();
                
                if(nome.length() == 0 || email.length() == 0 || senha.length() == 0){
                    Usuario user = new Usuario();
                    sistema.cadastrarUser(user);
    
                    JOptionPane.showMessageDialog(field, "Cadastro realizado com sucesso.");
                    tela.setVisible(true);
                    setVisible(false);
                }else{
    
                    JOptionPane.showMessageDialog(field, "Cadastro não realizado com sucesso.");
                   
                }
                
            }
        });

    }
}
