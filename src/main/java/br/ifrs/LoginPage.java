package br.ifrs;

import org.openqa.selenium.By;

public class LoginPage {

	private String pathBotaoUser = "/html/body/div[2]/div[2]/div/div/div/div/div/div/div/form[1]/div[1]/input";
    private String pathBotaoSenha = "/html/body/div[2]/div[2]/div/div/div/div/div/div/div/form[1]/div[2]/input";
	private String pathBotaoLogin = "/html/body/div[2]/div[2]/div/div/div/div/div/div/div/form[1]/div[3]/button";
	private String pathMensagemLoginInvalido = "/html/body/div[2]/div[2]/div/div/div/div/div/div/div/div[1]";
	private String MensagemLoginInvalido = "Invalid login, please try again";

	private DSL dsl = new DSL();

	private String urlAtual = DriverFactory.getDriver().getCurrentUrl();
	private String urlEsperada = "http://35.208.255.20/login/index.php";
	private String urlEsperadaSucesso = "http://35.208.255.20/my/";
	private String urlEsperadaFalha = "http://35.208.255.20/login/index.php?loginredirect=1";

	public String getPathMensagemLoginInvalido() {
		return pathMensagemLoginInvalido;
	}

	public void setEmail(String user) {
		dsl.escrever(By.xpath(pathBotaoUser), user);
	}

	public void setSenha(String senha) {
		dsl.escrever(By.xpath(pathBotaoSenha), senha);
	}

	public void logar() {
		dsl.clicarBotao(By.xpath(pathBotaoLogin));
	}
	
	public String getUrlAtual() {
		return urlAtual;
	}

	public String getUrlEsperadaSucesso() {
		return urlEsperadaSucesso;
	}

	public String getUrlEsperadaFalha() {
		return urlEsperadaFalha;
	}

	public String getUrlEsperada() {
		return urlEsperada;
	}

	public String getMensagemLoginInvalido() {
		return MensagemLoginInvalido;
	}

}
