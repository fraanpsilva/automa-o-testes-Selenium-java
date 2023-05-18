package br.com.fps.resources.page;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPo extends BasePO {

    /**
     * Construtor padrão para criação de uma nova página de login
     * @param driver driver da página de login
     */
    public LoginPo(WebDriver driver) {
        super(driver);
    }

    // mapeando elementos da tela de login

    @FindBy(id = "email")
    public WebElement inputEmail;

    @FindBy(id = "senha")
    public WebElement inputSenha;

    @FindBy(id = "btn-entrar")
    public WebElement buttonEntrar;

    @FindBy(id = "mensagem")
    public WebElement spanMensagem;

    @FindBy(css = "form.form-login>div.alert>span")
    public WebElement spanMensagemDadosInvalidos;

    //form.form-login>div.alert>span

    /**
     * Método que tenta executar a ação de logar no sistema
     * @param email email para tentativa de login
     * @param senha senha para tentativa de login
     */
    public void logarSistema(String email, String senha){
        escreveTexto(inputEmail,email );
        inputSenha.sendKeys(senha);
        buttonEntrar.click();
    }

    public String obterMensagem(){
        return spanMensagem.getText();

    }

    public void escreveTexto(WebElement input, String texto){
        input.clear();
        input.sendKeys(texto + Keys.TAB);
    }

    public String obterTituloDaPagina(){
        return driver.getTitle();

    }
    
}
