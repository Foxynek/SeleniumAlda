package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AfterLoginPage extends BasePage {
    public AfterLoginPage(WebDriver driver){
        super(driver);
    }
    @FindBy (xpath=".//*[@id='login']")
    private WebElement inputUserName;

    @FindBy (xpath=".//*[@id='heslo']")
    private WebElement inputUserPwd;

    @FindBy (xpath=".//*[@id='prihlaseni']/button")
    private WebElement clickOnLogin;

    @FindBy (xpath=".//*[@id='cedule-k']/a/span[3]")
    private WebElement clickOnChat;

    public AfterLoginPage inputUserName(String s){
        input(inputUserName, s);
        return this;
    }
    public AfterLoginPage inputPwd(String s){
        input(inputUserPwd, s);
        return this;
    }
    public AfterLoginPage clickOnLogin(){
        click(clickOnLogin);
        return new AfterLoginPage(getDriver());
    }
    public ChatSelectionPage clickOnChat(){
        click(clickOnChat);
        return new ChatSelectionPage(getDriver());
    }

}
