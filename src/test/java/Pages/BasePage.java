package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

public class BasePage {
    protected static WebDriver wd;
    private String w;

    public BasePage(WebDriver wd) {
        BasePage.wd = wd;
        PageFactory.initElements(wd, this);
    }
    public BasePage(){
    }
    protected void setDriverProperties(){
        System.setProperty("webdriver.gecko.driver", "A:\\Selenium\\geckodriver-v0.19.1-win64\\geckodriver.exe");
        FirefoxOptions firefoxOptions = new FirefoxOptions();
        firefoxOptions.setCapability("marionette", true);
        wd = new FirefoxDriver();
        wd.get("http://www.alik.cz");
        wd.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
    protected static WebDriver getDriver(){
        return wd;
    }
    protected static void switchToLastWindowHandle(){
        for(String winHandle : wd.getWindowHandles()){
            wd.switchTo().window(winHandle);
        }
    }
    protected void getWindowHandle(){
        w = wd.getWindowHandle();
    }
    protected void switchToCustomHandle(){
        wd.switchTo().window(w);
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
