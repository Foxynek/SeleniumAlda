package Pages.EmailPages;

import Pages.AfterLoginPage;
import Pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class InboxPage extends BasePage{

    public InboxPage(WebDriver wd){
        super(driver);
        switchToLastWindowHandle();
        waitForElementToLoad(emailMessage);
    }
    @FindBy (xpath = ".//a[@title='automat@alik.cz']")
    private WebElement emailMessage;

    @FindBy (xpath = ".//a[contains(.,'https://www.alik.cz/')]")
    private WebElement emailLink;

    public InboxPage clickOnEmailMessage(){
        click(emailMessage);
        return this;
    }
    public InboxPage clickOnLink(){
        click(emailLink);
        return this;
    }
}
