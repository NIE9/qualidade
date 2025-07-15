package br.ifrs;

public class Login {

    public static void login() {
        DriverFactory.getDriver().get("http://35.208.255.20/");
        LoginPg login = new LoginPg();
        login.setUser(login.getUser());
        login.setSenha(login.getSenha());

        login.logar();
    }
}