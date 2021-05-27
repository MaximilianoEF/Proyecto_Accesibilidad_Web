package com.PAW.Tool;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class HelpersConnection {
    
    private WebDriver driver;

    public HelpersConnection(WebDriver driver){
        this.driver = driver;
    }

    private void Connection(String url) {
        WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
        driver.manage().window().setSize(new Dimension(0,0));
        driver.get(url);
    }

    public WebDriver getInstancia(String url) {
		if (driver == null)
			Connection(url);
		return driver;
	}
	
	public void close() {
		if (driver != null) 
			driver.quit();
	}

    public WebElement findElement(By locator){
        return driver.findElement(locator);
    }

    public List<WebElement> findElements(By locator){
        return driver.findElements(locator);
    }

    public String getText(WebElement element){
        return element.getText();
    }

    public String title(){
        return driver.getTitle();
    }
    
    public String getText(By locator){
        return driver.findElement(locator).getText();
    }

    public void type(String inputText, By locator){
        driver.findElement(locator).sendKeys(inputText);
    }

    public void click(By locator){
        driver.findElement(locator).click();
    }

    public Boolean isDisplayed(By locator){
        try{
            return driver.findElement(locator).isDisplayed();
        } catch (org.openqa.selenium.NoSuchElementException e){
            return false;
        }
    }

    public Boolean isComparable(String texta, String textb){
        if (texta.indexOf(textb) != -1){
            return true;
        }
        else{
            return false;
        }
    }

    public Boolean isComparable(String texta, String textb, String textc, String textd){
        if (texta.indexOf(textb) != -1){
            return true;
        }
        if (texta.indexOf(textc) != -1){
            return true;
        }
        if (texta.indexOf(textd) != -1){
            return true;
        }
        else{
            return false;
        }
    }

}
