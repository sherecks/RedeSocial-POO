package principal;

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
    private JLabel tituloLabel, titulo1;
    private JButton cadastrarUsuario;

    public TelaCadastro() {

        field = new JPanel();
        fieldText = new JPanel();
        fieldButton = new JPanel();
        field.setBorder(BorderFactory.createEmptyBorder(180, 10, 10, 10));
        field.setBackground(Color.GRAY);

        Container c = getContentPane();

        // TEXTFIELD
        tituloLabel = new JLabel("CADASTRO");
        fieldText.add(tituloLabel, BorderLayout.CENTER);

        titulo1 = new JLabel("Digite Nome, Email e Senha:");
        field.add(titulo1);

        nomeUsuario = new JTextField();
        nomeUsuario.setColumns(20);
        field.add(nomeUsuario);

        emailUsuario = new JTextField();
        emailUsuario.setColumns(20);
        field.add(emailUsuario);

        senhaUsuario = new JTextField();
        senhaUsuario.setColumns(20);
        field.add(senhaUsuario);

        cadastrarUsuario = new JButton("Cadastrar");
        fieldButton.add(cadastrarUsuario, BorderLayout.CENTER);

        c.add(field, BorderLayout.CENTER);
        c.add(fieldText, BorderLayout.NORTH);
        c.add(fieldButton, BorderLayout.SOUTH);
        setSize(400, 640);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        //EVENTO
        cadastrarUsuario.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                TelaLogin tela = new TelaLogin();
                Login login = new Login();
                
                nome = (new String(nomeUsuario.getText()));
                email = (new String(emailUsuario.getText()));
                senha = (new String(senhaUsuario.getText()));

                if (nome.isEmpty() || senha.isEmpty() || email.isEmpty()) {
                    JOptionPane.showMessageDialog(field, "Cadastro não realizado.");
                } else {

                    login.cadastrarUser(nome, email, senha);
                    
                    // Exibir informações do usuário cadastrado!!!
                    String mensagem = "Usuário cadastrado:\n" +
                    "Nome: " + nome + "\n" +
                    "Email: " + email;
                    JOptionPane.showMessageDialog(null, mensagem);

                    tela.setVisible(true);
                    setVisible(false);
                }

            }
        });

    }
}
