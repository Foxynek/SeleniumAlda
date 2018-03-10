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
    private static WebDriver driver;
    public BasePage(WebDriver driver) {
        BasePage.driver = driver;
    }
    protected static void setDriver(){
        System.setProperty("webdriver.gecko.driver", "A:\\Selenium\\geckodriver-v0.19.1-win64\\geckodriver.exe");
        driver = new FirefoxDriver();
    }
    protected static WebDriver getDriver(){
        return driver;
    }
    protected static void getURL(String s){
        driver.get(s);
    }
    public void input(WebElement xPath, String message){
        xPath.sendKeys(message);
    }
    public void click(WebElement xPath){
        xPath.click();
    }
}
