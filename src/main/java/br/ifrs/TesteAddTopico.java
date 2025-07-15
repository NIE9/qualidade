package br.ifrs;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collection;

import org.junit.After;

import org.junit.Assert;
import org.junit.Before;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@RunWith(Parameterized.class)
public class TesteAddTopico {
	
    private static AddTopicoPage page = new AddTopicoPage();

    @Parameter
	public String subject;
	@Parameter(value=1)
	public String message;
	@Parameter(value=2)
	public String txtMsgSucesso;
	@Parameter(value=3)
	public String txtMsgAlertaEdit;
	@Parameter(value=4)
	public String msgDelete;
	@Parameter(value=5)
	public String txtMsgEdit;
	@Parameter(value=6)
	public String txtMsgDelete;
	@Parameter(value=7)
	public String esperarUrl;

	@Before
	public void setup() {
		page.login();
	}
	
	
	@Parameters
	public static Collection<Object[]> getCollection() {
		return Arrays.asList(new Object[][] {
			{page.getTextoSubject(), page.getTextoMessage(), page.getTxtMsgSucesso(), page.getTxtMsgAlertaEdit(), page.getPathMsgDelete(), page.getTxtMsgEdit(), page.getTxtMsgDelete(), page.getUrlEsperada()},
		});
	}
	
	@Test
	public void t1DeveValidarCadastroTopico() throws IOException, InterruptedException {
		WebDriverWait wait = new WebDriverWait(DriverFactory.getDriver(), 9);
		wait.until(ExpectedConditions.urlToBe(page.getUrlEsperada()));
		page.setBtnMyCouses();
		page.setBtnProgII();
		page.setBtnAnnouncements();
		page.setBtnAddTopic();
		page.setPathCampoSubject();
		page.setPathCampoMessage();
		page.setBtnPost();
		Assert.assertEquals(page.getTxtMsgSucesso(), txtMsgSucesso);
	}

	@Test
	public void t2DeveVerificarCadastroTopico() throws IOException, InterruptedException {
		WebDriverWait wait = new WebDriverWait(DriverFactory.getDriver(), 9);
		wait.until(ExpectedConditions.urlToBe(page.getUrlEsperada()));
		page.setBtnMyCouses();
		page.setBtnProgII();
		page.setBtnAnnouncements();
		page.setPathCampoPesquisa(subject);
		page.setBtnPesquisa();
		System.out.println("btnPesquisa: ");
		page.setBtnItemLista();
		System.out.println("btnItemLista: ");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(page.pathResultadoSubject)));
		System.out.println("wait");
		Assert.assertEquals(subject, page.getItemLista());
		System.out.println("fim");
	}

	@Test
	public void t3DeveValidarEdicaoTopico() throws IOException, InterruptedException {
		WebDriverWait wait = new WebDriverWait(DriverFactory.getDriver(), 9);
		wait.until(ExpectedConditions.urlToBe(page.getUrlEsperada()));
		page.setBtnMyCouses();
		page.setBtnProgII();
		page.setBtnAnnouncements();
		page.setPathCampoPesquisa(subject);
		page.setBtnPesquisa();
		page.setBtnItemLista();
		page.setBtnEdit();
		page.setPathCampoEditSubject(subject + " Editado");
		page.setBtnSaveChanges();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(page.pathMsgEdit)));
		//System.out.println("msg: " + page.getPathMsgEdit());
		System.out.println("txt: " + txtMsgEdit);
		Assert.assertTrue(page.getPathMsgEdit().contains("Professor 10's post was updated"));
	}

	@Test
	public void t4DeveVerificarEdiçãoTopico() throws IOException, InterruptedException {
		WebDriverWait wait = new WebDriverWait(DriverFactory.getDriver(), 9);
		wait.until(ExpectedConditions.urlToBe(page.getUrlEsperada()));
		page.setBtnMyCouses();
		page.setBtnProgII();
		page.setBtnAnnouncements();
		page.setPathCampoPesquisa(subject);
		page.setBtnPesquisa();
		page.setBtnItemLista();
		System.out.println("btnItemLista: ");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(page.pathResultadoSubjectEdit)));
		System.out.println("wait");
		Assert.assertEquals(subject + " Editado", page.getItemListaEdit());
		System.out.println("fim");
	}

	@Test
	public void t5DeveValidarExclusaoTopico() throws IOException, InterruptedException {
		WebDriverWait wait = new WebDriverWait(DriverFactory.getDriver(), 9);
		wait.until(ExpectedConditions.urlToBe(page.getUrlEsperada()));
		page.setBtnMyCouses();
		page.setBtnProgII();
		page.setBtnAnnouncements();
		page.setPathCampoPesquisa(subject + " Editado");
		page.setBtnPesquisa();
		page.setBtnItemLista();
		page.setBtnDelete();
		page.setBtnConfirmDelete();
		Assert.assertEquals(page.getTxtMsgDelete(), txtMsgDelete);
	}

	@After
	public void reload() {
		DriverFactory.killDriver();
	}

}
