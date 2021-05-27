package com.PAW.Tool;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import static org.junit.jupiter.api.Assertions.assertTrue;
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import java.util.NoSuchElementException;
//import java.util.concurrent.TimeUnit;
//import java.util.function.Function;
//import java.util.concurrent.TimeUnit;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.FluentWait;
//import org.openqa.selenium.support.ui.Wait;
//import org.openqa.selenium.support.ui.WebDriverWait;
import io.github.bonigarcia.wdm.WebDriverManager;

//@SpringBootTest
@TestInstance(Lifecycle.PER_CLASS)
public class GoogleSearchTest extends HelpersConnection {

    public GoogleSearchTest(WebDriver driver) {
        super(driver);
       
    }

    private WebDriver driver;
    /* Siempre se debe declarar un driver de tipo WebDriver para utilizar */

    By pageLinkLocator = By.id("tads");

    @BeforeAll
    public void SetUp() {
        /*
         * En esta seccion se reailzan las configuraciones previas para realizar las
         * automatizaciones
         */

        WebDriverManager.chromedriver().setup();
        /*
         * La clase WebDriverManager nos ahorra el tema de descargar/actualizar los
         * ejecutables de los browsers a utilizar
         */

        driver = new ChromeDriver();
        /* Declaramos el driver de tipo chromedriver */

        driver.manage().window().maximize();
        /* Le decimos al browser que maximize su ventana cuando se ejecute */

        driver.get("https://www.google.com/");
        /* Le enviamos la url que queremos abrir al navegador */


    }

    @Test
    public void testGooglePage() {
        /* Los pasos que vamos a dar para ejecutar la prueba */

        WebElement searchbox = driver.findElement(By.name("q"));
        /*
         * Los elementos de las web son de tipo WebElement, y tenemos el metodo
         * findElement para encontrar algun elemento de la web a traves de su nombre,
         * tag, etc
         */

        searchbox.clear();
        /* Con este metodo limpiamos la casilla si esta llena */

        searchbox.sendKeys("Udemy");
        /*
         * Como el elemento es una caja de busqueda, le enviamos a traves del metodo
         * sendKey la palabra que deceamos buscar"
         */

        searchbox.submit();
        /*
         * Con este metodo enviamos definitivamente lo escrito con sendKey, es como
         * darle enter
         */

        // Implicit Wait
        // driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        /*
         * Le vamos a decir el tiempo que queremos que espere, hay que esperar siempre
         * un tiempo de carga de busqueda para que luego me traiga los resultados
         */

        // Explicit Wait
        //WebDriverWait ewait = new WebDriverWait(driver, 10);
        //ewait.until(ExpectedConditions.titleContains("Udemy"));

        //assertEquals("Udemy - Buscar con Google", driver.getTitle());
        /*Para saber si el resultado es el esperado, y nos devolvio los datos que queriamos, utilizamos un asertEqual comprando el valor esperado con el titulo de la pagina*/

        //FluentWait
        //Wait<WebDriver> fwait = new FluentWait<WebDriver>(driver).withTimeout(10, TimeUnit.SECONDS).pollingEvery(2, TimeUnit.SECONDS).ignoring(NoSuchElementException.class);
        //WebElement page = fwait.until(new Function<WebDriver, WebElement>(){
        //    public WebElement apply(WebDriver driver){
        //        return driver.findElement(pageLinkLocator);
        //    }
        //});

        assertTrue(driver.findElement(pageLinkLocator).isDisplayed());

    }

    @AfterAll
    public void tearDown() {

        /*Realizamos el cierre del driver antes de terminar*/
        driver.quit();

    }

}

/* Locators
-- id = By.id("id of element");
-- name = By.name("name of element");
-- className = By.className("class of element");
-- tagName = By.tagName("tag");
-- linkText = By.linkText("text of link");
-- partialLinkText = By.partialLinkText("part from text of link");
-- CssSelector = By.cssSelector("inpt[name='q']");
-- Xpath = By.xpath("//nombreEtiqueta[@atributo='valor']");
*/