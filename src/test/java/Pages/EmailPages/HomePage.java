package Pages.EmailPages;

import Pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {
    public HomePage(WebDriver wd){
        super(driver);
    }
    @FindBy(xpath = ".//a[@href='https://registrace.seznam.cz/?hp']")
    private WebElement registrationButton;
    @FindBy(xpath = ".//a[@href='https://email.seznam.cz/?hp#inbox']")
    private WebElement receivedMessages;

    public SignUpPage clickOnRegistrationButton(){
        click(registrationButton);
        return new SignUpPage(getDriver());
    }
    public InboxSettingsPage clickOnReceivedMessages(){
        click(receivedMessages);
        return new InboxSettingsPage(getDriver());
    }
}
