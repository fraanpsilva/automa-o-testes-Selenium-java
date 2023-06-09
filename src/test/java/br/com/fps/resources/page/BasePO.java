package br.com.fps.resources.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

/**
 * Classe base para a criação de novas PageObjects <br/>
 * Todas as pages devem ser herdadas dessa classe
 */

public abstract class BasePO {

    // driver base que será usado pelas pages
    protected WebDriver driver;


    /**
     * Construtor base para criação da "fábrica de elementos" (PageFactory) 
     * @param driver Driver da página atual
    */
    public BasePO(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    
}
