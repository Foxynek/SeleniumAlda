
package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class AfterLoginPage extends BasePage {
    public AfterLoginPage(WebDriver wd){
        super(driver);
    }
    @FindBy (xpath=".//*[@id='login']")
    private WebElement userNameField;

    @FindBy (xpath=".//*[@id='heslo']")
    private WebElement userPwdField;

    @FindBy (xpath=".//*[@id='prihlaseni']/button")
    private WebElement loginButton;

    @FindBy (xpath=".//*[@id='cedule-k']/a/span[3]")
    private WebElement chatRoomSelectionButton;

    @FindBy(xpath = ".//a[@href='/registrace']")
    private WebElement registrationButton;

    @FindBy(xpath = ".//a[@href='/odhlasit']")
    private WebElement logoutButton;

    public String checkWhetherLoginFormIsPresent(){
        if (getDriver().findElements(By.xpath(".//form[@id='prihlaseni']")).size()>0){
            return "Login form is present";
        }
        else{
            return "Login form not present";
        }
    }

    public AccountCreationFirstPage clickOnRegistrationButton(){
        click(registrationButton);
        return new AccountCreationFirstPage(getDriver());
    }
    public boolean checkIfUserIsLoggedIn(){
        return isElementPresentAndVisible(".//a[@href='/odhlasit']");
    }

    public AfterLoginPage clickOnLogoutButton(){
        click(logoutButton);
        return this;
    }
    public AfterLoginPage inputUserName(String s){
        input(userNameField, s);
        return this;
    }
    public AfterLoginPage inputPwd(String s){
        input(userPwdField, s);
        return this;
    }
    public AfterLoginPage clickOnLogin(){
        click(loginButton);
        return new AfterLoginPage(getDriver());
    }
    public ChatSelectionPage clickOnChat(){
        click(chatRoomSelectionButton);
        return new ChatSelectionPage(getDriver());
    }

}

