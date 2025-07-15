package br.ifrs;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collection;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class TesteLogin {
	
	private static LoginPage page = new LoginPage();
	
	@Parameter
	public String urlAtual;
	@Parameter(value=1)
	public String urlEsperada;
	@Parameter(value=2)
	public String msgLoginInvalido;
	@Parameter(value=3)
	public String mensagemLoginInvalido;
	@Parameter(value=4)
	public String user;
	@Parameter(value=5)
	public String senha;
	@Parameter(value=6)
	public String esperarUrl;

	@Before
	public void setup() {
		DriverFactory.getDriver().get("http://35.208.255.20/");
	}
	
	
	@Parameters
	public static Collection<Object[]> getCollection() {
		return Arrays.asList(new Object[][] {
			{page.getUrlAtual(), page.getUrlEsperadaSucesso(), page.getPathMensagemLoginInvalido(), page.getMensagemLoginInvalido(), "professor10", "@Pf31c74d99c26b533a37aeb860325fe1d", page.getUrlEsperada()},
			{page.getUrlAtual(), page.getUrlEsperadaFalha(), page.getPathMensagemLoginInvalido(), page.getMensagemLoginInvalido(), "professor10", "senhaErrada", page.getUrlEsperada()},
			{page.getUrlAtual(), page.getUrlEsperadaFalha(), page.getPathMensagemLoginInvalido(), page.getMensagemLoginInvalido(), "UsuarioInexistente", "@Pf31c74d99c26b533a37aeb860325fe1d", page.getUrlEsperada()},
		});
	}
	
	@Test
	public void deveValidarLogin() throws IOException, InterruptedException {
		WebDriverWait wait = new WebDriverWait(DriverFactory.getDriver(), 10);
		wait.until(ExpectedConditions.urlToBe(esperarUrl));
		page.setEmail(user);
		page.setSenha(senha);
		page.logar();
		Assert.assertEquals(DriverFactory.getDriver().getCurrentUrl(), urlEsperada);
	}

	@After
	public void finalizar() {
		DriverFactory.killDriver();
	}
}
