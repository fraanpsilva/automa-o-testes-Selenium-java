package br.com.fps.tests;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import br.com.fps.resources.page.LoginPo;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class LoginTest extends BaseTest{

    private static LoginPo loginPage;

//    private void logarSistema(String email, String senha){
//        loginPage.escreveTexto(loginPage.inputEmail,email );
//        loginPage.inputSenha.sendKeys(senha);
//        loginPage.buttonEntrar.click();
//    }

    @BeforeClass
    public static void preparaTestes(){
        loginPage = new LoginPo(driver);
    }

    @Test
    public void TC01_naoLogarComCamposEmailESenhaVazios(){
        loginPage.logarSistema("", "");
        String mensagem = loginPage.obterMensagem();
        Assert.assertTrue(mensagem, mensagem.contains("campos não podem ser brancos."));
    }

    @Test
    public void TC02_naoLogarComCampoSenhaVazio(){
        loginPage.logarSistema("admin@admin.com", "");
        String mensagem = loginPage.obterMensagem();
        Assert.assertEquals(mensagem, "Informe usuário e senha, os campos não podem ser brancos.");
    }

    @Test
    public void TC03_naoLogarComCampoEmailVazio(){

        //loginPage.inputEmail.clear();
        loginPage.logarSistema("", "123456");
        String mensagem = loginPage.spanMensagem.getText();
        Assert.assertEquals(mensagem, "Informe usuário e senha, os campos não podem ser brancos.");
    }

    @Test
    public void TC04_naoLogarComSenhaInvalida(){
        loginPage.logarSistema("admin@admin.com", "123456");
        String mensagem = loginPage.obterMensagem();
        Assert.assertEquals(mensagem, "E-mail ou senha inválidos");
    }

    @Test
    public void TC05_naoLogarComEmailInvalido(){
        loginPage.logarSistema("admin123@admin.com", "admin@123");
        String mensagem = loginPage.obterMensagem();
        Assert.assertEquals(mensagem, "E-mail ou senha inválidos");
    }

    @Test
    public void TC06_LogarComEmailEsenhavalidos(){
        loginPage.logarSistema("admin@admin.com", "admin@123" );
        String tituloPage = loginPage.obterTituloDaPagina();
        Assert.assertEquals(tituloPage, "Controle de Produtos");
    }

































}
