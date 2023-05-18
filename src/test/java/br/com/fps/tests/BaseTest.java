package br.com.fps.tests;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public abstract class BaseTest {

    protected static WebDriver driver;
    private static final String URL_BASE = "http://127.0.0.1:5500/login.html";
    private static final String PATH_DRIVER = "src/test/java/br/com/fps/resources/chromedriver-v1130567263";
    
    @BeforeClass
    public static void iniciaBrowser(){
        System.setProperty("webdriver.chrome.driver", PATH_DRIVER);
        driver = new ChromeDriver();
        driver.manage().window().setSize(new Dimension(1200, 765));
        driver.get(URL_BASE);
    }


    @AfterClass
    public static void fechaBrowser(){
        driver.close();
    }
}
