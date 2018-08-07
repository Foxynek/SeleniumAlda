package Pages;

import PropertiesManager.PropertiesManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
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
    protected void setDriverPropertiesAlda(){
        String url = PropertiesManager.getInstance().getURLAlda();
        System.setProperty("webdriver.gecko.driver", "A:\\Selenium\\geckodriver-v0.19.1-win64\\geckodriver.exe");
        FirefoxOptions firefoxOptions = new FirefoxOptions();
        firefoxOptions.setCapability("marionette", true);
        wd = new FirefoxDriver();
        wd.get(url);
        wd.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
    protected void setDriverPropertiesWedos(){
        String url = PropertiesManager.getInstance().getURLWedos();
        System.setProperty("webdriver.gecko.driver", "A:\\Selenium\\geckodriver-v0.19.1-win64\\geckodriver.exe");
        FirefoxOptions firefoxOptions = new FirefoxOptions();
        firefoxOptions.setCapability("marionette", true);
        wd = new FirefoxDriver();
        wd.get(url);
        wd.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
    protected String getUserNameAlda(){
        return PropertiesManager.getInstance().getUsernameAlda();
    }
    protected String getUserPasswordAlda(){
        return PropertiesManager.getInstance().getPasswordAlda();
    }
    protected String getUserNameWedos(){
        return PropertiesManager.getInstance().getUsernameWedos();
    }
    protected String getUserPasswordWedos(){
        return PropertiesManager.getInstance().getPasswordWedos();
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
    protected void waitForPageToLoad(WebDriver wd, WebElement element){
        //wd.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        WebDriverWait wait = new WebDriverWait(wd, 10);
        wait.until(ExpectedConditions.elementToBeClickable(element));
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
    protected String getCurrentDate(){
        DateFormat dateFormat = new SimpleDateFormat("ddMMyyyy");
        Date date = new Date();
        return dateFormat.format(date);
    }
    protected String getCurrentTime(){
        DateFormat dateFormat = new SimpleDateFormat("HHmmss");
        Date date = new Date();
        return dateFormat.format(date);
    }
}
