package principal;

import negocios.Login;

public class Main {

    // O IMPORTANTE!!!
    public static void main(String[] args) {
        Login login = new Login();
        Screen frame1 = new Screen(login);
        frame1.setVisible(true);
    }

}
