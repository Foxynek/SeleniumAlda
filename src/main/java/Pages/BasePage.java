package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import java.io.File;
import java.util.List;
import java.util.Set;

public class BasePage {
    public static WebDriver driver;
    public BasePage() {
        System.setProperty("webdriver.gecko.driver", "A:\\Selenium\\geckodriver-v0.19.1-win64\\geckodriver.exe");
        driver = new FirefoxDriver();

    }
    public WebDriver getDriver(){
        return driver;
    }
    public static void getURL(String s){
        driver.get(s);
    }
    public void input(WebElement xPath, String message){
        xPath.sendKeys(message);
    }
    public void click(WebElement xPath){
        xPath.click();
    }
}
