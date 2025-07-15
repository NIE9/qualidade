package br.ifrs;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

//import com.gargoylesoftware.htmlunit.javascript.host.Console;

// https://www.selenium.dev/documentation/pt-br/guidelines_and_recommendations/domain_specific_language/

public class DSL {
	
	private void wait(By by) {
		WebDriverWait wait = new WebDriverWait(DriverFactory.getDriver(), DriverProperty.WAIT_TIME);
		wait.until(ExpectedConditions.visibilityOfElementLocated(by));
	}
	
	public void reload() {
		DriverFactory.getDriver().navigate().refresh();
	}

	public void scrollAteElemento(By by) {
    WebElement elemento = DriverFactory.getDriver().findElement(by);
    ((JavascriptExecutor) DriverFactory.getDriver()).executeScript("arguments[0].scrollIntoView(true);", elemento);
}
	
	// TextFields e TextAreas
	public void escrever(By by, String texto){
		wait(by);
		DriverFactory.getDriver().findElement(by).clear();
		DriverFactory.getDriver().findElement(by).sendKeys(texto);
	}
	public void escrever(String idCampo, String texto){
		escrever(By.id(idCampo), texto);
	}
	public String obterValorCampo(String idCampo) {
		wait(By.id(idCampo));
		return DriverFactory.getDriver().findElement(By.id(idCampo)).getAttribute("value");
	}
	public String obterValorCampo(By by) {
		wait(by);
		return DriverFactory.getDriver().findElement(by).getAttribute("value");
	}
	
	// Radio buttons e Checkboxes 
	public void clicarRadio(String id) {
		DriverFactory.getDriver().findElement(By.id(id)).click();
	}
	public boolean isRadioMarcado(String id){
		wait(By.id(id));
		return DriverFactory.getDriver().findElement(By.id(id)).isSelected();
	}
	public void clicarCheck(String id) {
		DriverFactory.getDriver().findElement(By.id(id)).click();
	}
	public boolean isCheckMarcado(String id){
		wait(By.id(id));
		return DriverFactory.getDriver().findElement(By.id(id)).isSelected();
	}
	
	// Combos
	public void selecionarCombo(String id, String valor) {
		WebElement element = DriverFactory.getDriver().findElement(By.id(id));
		Select combo = new Select(element);
		combo.selectByVisibleText(valor);
	}
	
	public void selecionarComboByValue(String id, String valor) {
		waitUntilOptionsPopulated(id);
		WebElement element = DriverFactory.getDriver().findElement(By.id(id));
		Select combo = new Select(element);
		combo.selectByValue(valor);
	}
	
	public void selecionarComboXPath(String xpath, String valor) {
		WebElement element = DriverFactory.getDriver().findElement(By.xpath(xpath));
		Select combo = new Select(element);
		combo.selectByVisibleText(valor);
	}
	
	
	public void deselecionarCombo(String id, String valor) {
		WebElement element = DriverFactory.getDriver().findElement(By.id(id));
		Select combo = new Select(element);
		combo.deselectByVisibleText(valor);
	}
	
	public String obterValorCombo(String id) {
		wait(By.id(id));
		WebElement element = DriverFactory.getDriver().findElement(By.id(id));
		Select combo = new Select(element);
		return combo.getFirstSelectedOption().getText();
	}
	
	public String obterValueCombo(String id) {
		waitUntilOptionsPopulated(id);
		WebElement element = DriverFactory.getDriver().findElement(By.id(id));
		Select combo = new Select(element);
		return combo.getFirstSelectedOption().getAttribute("value");
	}
	public String obterValueCombo(By by) {
		waitUntilOptionsPopulated(by);
		WebElement element = DriverFactory.getDriver().findElement(by);
		Select combo = new Select(element);
		return combo.getFirstSelectedOption().getAttribute("value");
	}
	
	private void waitUntilOptionsPopulated(By by) {
	    WebDriverWait wait = new WebDriverWait(DriverFactory.getDriver(), DriverProperty.WAIT_TIME);
	    wait.until(driver -> {
	        WebElement selectElem = driver.findElement(by);
	        Select select = new Select(selectElem);
	        return select.getOptions().size() > 0;
	    });
	}
	private void waitUntilOptionsPopulated(String id) {
	    WebDriverWait wait = new WebDriverWait(DriverFactory.getDriver(), DriverProperty.WAIT_TIME);
	    wait.until(driver -> {
	        WebElement selectElem = driver.findElement(By.id(id));
	        Select select = new Select(selectElem);
	        return select.getOptions().size() > 0;
	    });
	}
	
	
	public List<String> obterValoresCombo(String id) {
		WebElement element = DriverFactory.getDriver().findElement(By.id(id));
		Select combo = new Select(element);
		List<WebElement> allSelectedOptions = combo.getAllSelectedOptions();
		List<String> valores = new ArrayList<String>();
		for(WebElement opcao: allSelectedOptions) {
			valores.add(opcao.getText());
		}
		return valores;
	}
	public int obterQuantidadeOpcoesCombo(String id){
		WebElement element =  DriverFactory.getDriver().findElement(By.id(id));	
		Select combo = new Select(element);
		return combo.getAllSelectedOptions().size();		
	}
	public boolean verificarOpcaoCombo(String id, String opcao){
		WebElement element = DriverFactory.getDriver().findElement(By.id(id));
		Select combo = new Select(element);
		List<WebElement> options = combo.getOptions();
		for(WebElement option: options) {
			if(option.getText().equals(opcao)){
				return true;
			}
		}
		return false;
	}
	
	// Buttons
	public void clicarBotao(String id) {
		wait(By.xpath(id));
		DriverFactory.getDriver().findElement(By.xpath(id)).click();
	}

	public void clicarBotao(By by) {
		wait(by);
		DriverFactory.getDriver().findElement(by).click();
	}
	
	
	// Links
	public void clicarLink(String link) {
		DriverFactory.getDriver().findElement(By.linkText(link)).click();
	}
	
	// Textos
	public String obterTexto(By by) {
		wait(by);
		return DriverFactory.getDriver().findElement(by).getText();
	}
	public String obterTexto(String id) {
		return obterTexto(By.id(id));
	}
	
    // Alertas 
	public String alertaObterTexto(){
		Alert alert = DriverFactory.getDriver().switchTo().alert();
		return alert.getText();
	}
	public String alertaObterTextoEAceita(){
		Alert alert = DriverFactory.getDriver().switchTo().alert();
		String valor = alert.getText();
		alert.accept();
		return valor;
	}
}

