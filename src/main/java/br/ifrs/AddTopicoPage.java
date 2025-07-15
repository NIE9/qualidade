package br.ifrs;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import net.datafaker.Faker;

public class AddTopicoPage {

    private String btnMyCouses = "/html/body/div[2]/nav/div/div[1]/nav/ul/li[3]";
    private String btnProgII = "/html/body/div[2]/div[3]/div/div[2]/div/div/div/section/section/div/div/div[1]/div[2]/div/div/div[1]/div/div/div/div/div[1]/div/div/a";
    private String btnAnnouncements = "/html/body/div[2]/div[4]/div/div[3]/div/div/div/div/div/ul/li[1]/div/div[2]/ul/li/div/div[2]/div[2]/div/div/a";
    private String btnAddTopic = "/html/body/div[3]/div[4]/div/div[3]/div/div/div[2]/div[1]/div/div[2]";
    private String pathCampoSubject = "/html/body/div[3]/div[4]/div/div[3]/div/div/div[2]/div[2]/div[2]/form/div[2]/div[2]/input";
    private String pathCampoMessage = "//*[@id=\"tinymce\"]";
    private String btnPost = "/html/body/div[3]/div[4]/div/div[3]/div/div/div[2]/div[2]/div[2]/form/div[4]/div[2]/div[1]/div/div[1]/span/input";
    private String pathRequiredSubject = "/html/body/div[3]/div[4]/div/div[3]/div/div/div[2]/div[2]/div[2]/form/div[2]/div[2]/div";
    private String pathRequiredMessage = "/html/body/div[3]/div[4]/div/div[3]/div/div/div[2]/div[2]/div[2]/form/div[3]/div[2]/div[2]";
    private String txtRequired = "/html/body/div[3]/div[4]/div/div[3]/div/div/div[2]/div[2]/div[2]/form/div[3]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/iframe";
    public String pathMsgSucesso = "/html/body/div[3]/div[4]/div/div[3]/div/div/span[1]/div/p[1]";
    private String txtMsgSucesso = "Your post was successfully added.";
    private String pathMsgAlertaEdit = "/html/body/div[3]/div[4]/div/div[3]/div/div/span[1]/div/p[2]";
    private String txtMsgAlertaEdit = "You have 30 mins to edit it if you want to make any changes.";
    private String pathCampoPesquisa = "/html/body/div[3]/div[4]/div/div[3]/div/div/div[2]/div[1]/div/div[1]/div/form/div/input";
    private String btnPesquisa = "/html/body/div[3]/div[4]/div/div[3]/div/div/div[2]/div[1]/div/div[1]/div/form/div/div/button";
    public String pathResultadoSubject = "/html/body/div[2]/div[4]/div/div[3]/div/div/div[2]/h3";
    public String pathResultadoSubjectEdit = "/html/body/div[2]/div[4]/div/div[3]/div/div/div[2]/h3";
    private String pathResultadoMessage = "/html/body/div[2]/div[4]/div/div[3]/div/div/div/article/div/div/div/div[2]/div[1]/p";
    private String btnDelete = "/html/body/div[2]/div[4]/div/div[3]/div/div/div[2]/div/article/div[1]/div/div/div[2]/div[2]/div/a[3]";
    private String btnConfirmDelete = "/html/body/div[2]/div[4]/div/div[3]/div/div/div[2]/div/div/div[3]/div/div[2]/form/button";
    private String pathMsgDelete = "/html/body/div[3]/div[4]/div/div[3]/div/div/span[1]/div";
    private String txtMsgDelete = "\r\n" + "    Discussion deleted\r\n" + "    ";
    private String btnEdit = "/html/body/div[2]/div[4]/div/div[3]/div/div/div[2]/div/article/div[1]/div/div/div[2]/div[2]/div/a[2]";
    public String pathMsgEdit = "/html/body/div[2]/div[4]/div/div[3]/div/div/span[1]/div";
    private String txtMsgEdit = "Professor 10's post was updated";
    private String pathCampoEditSubject = "/html/body/div[3]/div[4]/div/div[3]/div/div/div[2]/form/fieldset[1]/div[2]/div[1]/div[2]/input";
    private String pathCampoEditMessage = "/html/body/div[3]/div[4]/div/div[3]/div/div/div[2]/form/fieldset[1]/div[2]/div[2]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/iframe";
    private String btnSaveChanges = "/html/body/div[3]/div[4]/div/div[3]/div/div/div[2]/form/div[3]/div[2]/div[1]/div/div[1]/span/input";
    public String btnItemLista = "/html/body/div[2]/div[4]/div/div[3]/div/div/div/article/div/div/header/div[2]/h4/a[2]";
    private String urlEsperada = "http://35.208.255.20/my/";

    WebDriverWait wait = new WebDriverWait(DriverFactory.getDriver(), 5);
    private DSL dsl = new DSL();
    public static Faker faker = new Faker();
	private String textoSubject = faker.lorem().maxLengthSentence(20);
    private String textoMessage = faker.lorem().sentence(20,40);

    public void reload(){
		dsl.reload();
	}

    public void login() {
        Login.login();
    }

    // Setters for the locators
    
    public void setBtnItemLista() {
        dsl.clicarBotao(By.xpath(btnItemLista));
    }
    public void setBtnMyCouses() {
        dsl.clicarBotao(By.xpath(btnMyCouses));
    }
    public void setBtnProgII() {
        dsl.clicarBotao(By.xpath(btnProgII));
    }
    public void setBtnAnnouncements() {
        dsl.clicarBotao(By.xpath(btnAnnouncements));
    }
    public void setBtnAddTopic() {
        dsl.clicarBotao(By.xpath(btnAddTopic));
    }
    public void setPathCampoSubject() {
        dsl.escrever(By.xpath(pathCampoSubject), textoSubject);
    }
    public void setPathCampoMessage() {

        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("id_message_ifr"));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/p")));
        dsl.escrever(By.xpath(pathCampoMessage), textoMessage);
        DriverFactory.getDriver().switchTo().defaultContent();

    }
    public void setBtnPost() {
        dsl.clicarBotao(By.xpath(btnPost));
    }
    public void setPathRequiredSubject(String pathRequiredSubject) { //alerta de campo obrigatório não preenchido
        this.pathRequiredSubject = pathRequiredSubject;
    }
    public void setPathRequiredMessage(String pathRequiredMessage) { //alerta de campo obrigatório não preenchido
        this.pathRequiredMessage = pathRequiredMessage;
    }
    public void setTxtRequired(String txtRequired) { //alerta de campo obrigatório não preenchido
        this.txtRequired = txtRequired;
    }
    public void setPathMsgSucesso(String pathMsgSucesso) { //mensagem de sucesso após adicionar tópico
        this.pathMsgSucesso = pathMsgSucesso;
    }
    public void setTxtMsgSucesso(String txtMsgSucesso) { //mensagem de sucesso após adicionar tópico
        this.txtMsgSucesso = txtMsgSucesso;
    }
    public void setPathMsgAlertaEdit(String pathMsgAlertaEdit) { //mensagem de alerta após editar tópico
        this.pathMsgAlertaEdit = pathMsgAlertaEdit;
    }
    public void setTxtMsgAlertaEdit(String txtMsgAlertaEdit) { 
        this.txtMsgAlertaEdit = txtMsgAlertaEdit;
    }
    public void setPathCampoPesquisa(String CampoPesquisa) {
        dsl.escrever(By.xpath(pathCampoPesquisa), CampoPesquisa);
    }
    public void setBtnPesquisa() {
        dsl.clicarBotao(By.xpath(btnPesquisa));
    }
    public void setPathResultadoSubject(String pathResultadoSubject) {
        this.pathResultadoSubject = pathResultadoSubject;
    }
    public void setPathResultadoMessage(String pathResultadoMessage) {
        this.pathResultadoMessage = pathResultadoMessage;
    }
    public void setBtnDelete() {
        dsl.clicarBotao(By.xpath(btnDelete));
    }
    public void setBtnConfirmDelete() {
        dsl.clicarBotao(By.xpath(btnConfirmDelete));
    }
    public void setPathMsgDelete(String pathMsgDelete) {
        this.pathMsgDelete = pathMsgDelete;
    }
    public void setTxtMsgDelete(String txtMsgDelete) {
        this.txtMsgDelete = txtMsgDelete;
    }
    public void setBtnEdit() {
        dsl.clicarBotao(By.xpath(btnEdit));
    }
    public void setPathMsgEdit(String pathMsgEdit) {
        this.pathMsgEdit = pathMsgEdit;
    }
    public void setTxtMsgEdit(String txtMsgEdit) {
        this.txtMsgEdit = txtMsgEdit;
    }
    public void setPathCampoEditSubject(String CampoEditSubject) {
        dsl.escrever(By.xpath(pathCampoEditSubject), CampoEditSubject);
    }
    public void setPathCampoEditMessage(String CampoEditMessage) {
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("id_message_ifr"));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/p")));
        dsl.escrever(By.xpath(pathCampoEditMessage), CampoEditMessage);
        DriverFactory.getDriver().switchTo().defaultContent();
    }
    public void setBtnSaveChanges() {
        dsl.scrollAteElemento(By.xpath(btnSaveChanges));
        dsl.clicarBotao(By.xpath(btnSaveChanges));
    }
    
    // Getters for the locators

    public String getUrlEsperada() {
        return urlEsperada;
    }
    public String getTextoSubject() {
        return textoSubject;
    }
    public String getTextoMessage() {
        return textoMessage;
    }
    public String getBtnMyCouses() {
        return btnMyCouses;
    }
    public String getBtnProgII() {
        return btnProgII;
    }
    public String getBtnAnnouncements() {
        return btnAnnouncements;
    }
    public String getBtnAddTopic() {
        return btnAddTopic;
    }
    public String getCampoSubject() {
        return pathCampoSubject;
    }
    public String getCampoMessage() {
        return pathCampoMessage;
    }
    public String getBtnPost() {
        return btnPost;
    }
    public String getPathRequiredSubject() {
        return pathRequiredSubject;
    }
    public String getPathRequiredMessage() {
        return pathRequiredMessage;
    }
    public String getTxtRequired() {
        return txtRequired;
    }
    public String getPathMsgSucesso() {
        this.pathMsgSucesso = dsl.obterTexto(By.xpath(pathMsgSucesso));
        return pathMsgSucesso;
    }
    public String getTxtMsgSucesso() {
        return txtMsgSucesso;
    }
    public String getPathMsgAlertaEdit() {
        this.pathMsgAlertaEdit = dsl.obterTexto(By.xpath(pathMsgAlertaEdit));
        return pathMsgAlertaEdit;
    }
    public String getTxtMsgAlertaEdit() {
        return txtMsgAlertaEdit;
    }
    public String getPathCampoPesquisa() {
        this.pathCampoPesquisa = dsl.obterTexto(By.xpath(pathCampoPesquisa));
        return pathCampoPesquisa;
    }
    public String getBtnPesquisa() {
        return btnPesquisa;
    }
    public String getPathResultadoSubject() {
        return pathResultadoSubject;
    }
    public String getPathResultadoMessage() {
        return pathResultadoMessage;
    }
    public String getBtnDelete() {
        return btnDelete;
    }
    public String getBtnConfirmDelete() {
        return btnConfirmDelete;
    }
    public String getPathMsgDelete() {
        return pathMsgDelete;
    }
    public String getTxtMsgDelete() {
        return txtMsgDelete;
    }
    public String getBtnEdit() {
        return btnEdit;
    }
    public String getPathMsgEdit() {
        this.pathMsgEdit = dsl.obterTexto(By.xpath(pathMsgEdit));
        return pathMsgEdit;
    }
    public String getTxtMsgEdit() {
        return txtMsgEdit;
    }
    public String getPathCampoEditSubject() {
        return pathCampoEditSubject;
    }
    public String getPathCampoEditMessage() {
        return pathCampoEditMessage;
    }
    public String getBtnSaveChanges() {
        return btnSaveChanges;
    }
    public String getItemLista() {
        //wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[2]/div[4]/div/div[3]/div/div/div[2]/h3")));
        this.pathResultadoSubject = dsl.obterTexto(By.xpath(pathResultadoSubject));
        return pathResultadoSubject;
    }

    public String getItemListaEdit() {
        //wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[2]/div[4]/div/div[3]/div/div/div[2]/h3")));
        this.pathResultadoSubjectEdit = dsl.obterTexto(By.xpath(pathResultadoSubjectEdit));
        return pathResultadoSubjectEdit;
    }
}
