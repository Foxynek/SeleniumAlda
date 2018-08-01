package Pages.EmailPages;

import Pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class InboxSettingsPage extends BasePage{

    public InboxSettingsPage(WebDriver wd){
        super(wd);
    }
    @FindBy(xpath = ".//*[@id='back-to-inbox']")
    private WebElement backToInboxButton;

    public InboxPage clickOnBackToInboxButton(){
        click(backToInboxButton);
        return new InboxPage(getDriver());
    }
}
