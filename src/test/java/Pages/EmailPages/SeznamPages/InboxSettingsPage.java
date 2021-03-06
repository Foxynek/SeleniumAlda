package Pages.EmailPages.SeznamPages;

import Pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class InboxSettingsPage extends BasePage{

    public InboxSettingsPage(WebDriver wd){
        super(wd);
        switchToLastWindowHandle();
        waitForPageToLoad(getDriver(), backToInboxButton);
    }
    @FindBy(xpath = ".//*[@id='back-to-inbox']")
    private WebElement backToInboxButton;

    public InboxPage clickOnBackToInboxButton(){
        click(backToInboxButton);
        return new InboxPage(getDriver());
    }
}
