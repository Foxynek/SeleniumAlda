package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class BasePage {
    protected static WebDriver driver;
    private String w;

    public BasePage(WebDriver driver) {
        BasePage.driver = driver;
        PageFactory.initElements(driver, this);
    }
    public BasePage(){
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
    public void input(WebElement element, String message){
        element.sendKeys(message);
    }
    public void click(WebElement element){
        element.click();
    }
    public boolean isElementPresentAndVisible(String s){
        return getDriver().findElements(By.xpath(s)).isEmpty();
    }
}
