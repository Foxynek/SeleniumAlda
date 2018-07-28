package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

public class BasePage {
    protected static WebDriver driver;
    private String w;

    public BasePage(WebDriver driver) {
        BasePage.driver = driver;
        PageFactory.initElements(driver, this);
    }
    public BasePage(){
    }
    protected void setDriverProperties(){
        System.setProperty("webdriver.gecko.driver", "A:\\Selenium\\geckodriver-v0.19.1-win64\\geckodriver.exe");
        FirefoxOptions firefoxOptions = new FirefoxOptions();
        firefoxOptions.setCapability("marionette", true);
        driver = new FirefoxDriver();
        driver.get("http://www.alik.cz");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
    protected static WebDriver getDriver(){
        return driver;
    }
    protected static void switchToLastWindowHandle(){
        for(String winHandle : driver.getWindowHandles()){
            driver.switchTo().window(winHandle);
        }
    }
    protected void getWindowHandle(){
        w = driver.getWindowHandle();
    }
    protected void switchToCustomHandle(){
        driver.switchTo().window(w);
    }
    protected void waitForElementToLoad(WebElement element){    //fix this wait shit
        /*do{
            try{
                Thread.sleep(500);
            }
            catch(InterruptedException e){
                e.printStackTrace();
            }
        }while(element.isEnabled());*/
    }
    protected static void getURL(String s){
        driver.get(s);
    }
    protected void input(WebElement element, String message){
        element.sendKeys(message);
    }
    public void click(WebElement element){
        element.click();
    }
    protected boolean isElementPresentAndVisible(String s){
        return getDriver().findElements(By.xpath(s)).isEmpty();
    }
}
