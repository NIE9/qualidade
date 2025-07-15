package br.ifrs;

import org.openqa.selenium.By;

public class LoginPg {

	private String pathBotaoUser = "/html/body/div[2]/div[2]/div/div/div/div/div/div/div/form[1]/div[1]/input";
    private String pathBotaoSenha = "/html/body/div[2]/div[2]/div/div/div/div/div/div/div/form[1]/div[2]/input";
	private String pathBotaoLogin = "/html/body/div[2]/div[2]/div/div/div/div/div/div/div/form[1]/div[3]/button";
	private String user = "professor10";
	private String senha = "@Pf31c74d99c26b533a37aeb860325fe1d";
	private DSL dsl = new DSL();
	
	public void setUser(String user) {
		dsl.escrever(By.xpath(pathBotaoUser), user);
	}

	public void setSenha(String senha) {
		dsl.escrever(By.xpath(pathBotaoSenha), senha);
	}

	public String getPathBotaoUser() {
		return pathBotaoUser;
	}

	public String getPathBotaoSenha() {
		return pathBotaoSenha;
	}

	public String getUser() {
		return user;
	}

	public String getSenha() {
		return senha;
	}

	public void logar() {
		dsl.clicarBotao(pathBotaoLogin);
	}	
}
