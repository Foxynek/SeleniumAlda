package Pages.EmailPages;

import Pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {
    public HomePage(WebDriver wd){
        super(driver);
        switchToLastWindowHandle();
        waitForElementToLoad(seznamlogo);
    }
    @FindBy(xpath = ".//a[@href='https://registrace.seznam.cz/?hp']")
    private WebElement registrationButton;
    @FindBy(xpath = ".//a[@href='https://email.seznam.cz/?hp#inbox']")
    private WebElement receivedMessages;
    @FindBy(xpath = ".//button[@class='action action--popover']")
    private WebElement accountDropDownSelection;
    @FindBy(xpath = ".//a[@class='menu__item menu__item--logout']")
    private WebElement logoutButton;
    @FindBy(xpath = ".//a[@class='nav__item link']/following-sibling::a")
    private WebElement signInButton;
    @FindBy(xpath = ".//img[@class='seznam-logo__image']")
    private WebElement seznamlogo;

    public boolean isUserSignedIn(){
        return isElementPresentAndVisible(".//button[@class='action action--popover']");    //returns true for logged out
    }
    public SignInPage clickOnSignInButton(){
        if (isUserSignedIn())
            click(signInButton);
        else {
            clickOnAccountDropDownSelection();
            clickOnLogoutButton();
            click(signInButton);
        }
        return new SignInPage(getDriver());
    }
    public HomePage clickOnAccountDropDownSelection(){
        click(accountDropDownSelection);
        return this;
    }
    public HomePage clickOnLogoutButton(){
        click(logoutButton);
        return this;
    }
    public SignUpPage clickOnRegistrationButton(){
        if (isUserSignedIn())
        click(registrationButton);
        else {
            clickOnAccountDropDownSelection();
            clickOnLogoutButton();
            click(registrationButton);
        }
        return new SignUpPage(getDriver());
    }
    public InboxPage clickOnReceivedMessages(){
        click(receivedMessages);
        return new InboxPage(getDriver());
    }
}
