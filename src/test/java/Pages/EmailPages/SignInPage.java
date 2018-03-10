package Pages.EmailPages;

import Pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SignInPage extends BasePage{

    public SignInPage(WebDriver wd){
        super(driver);
        switchToLastWindowHandle();
        waitForElementToLoad(emailAdressField);
    }

    @FindBy(xpath = ".//*[@id='login-username']")
    private WebElement emailAdressField;

    @FindBy(xpath = ".//form[@class='login']/input[@data-placeholder='login.password']")
    private WebElement pwdField;

    @FindBy(xpath = ".//button[@data-locale='login.submit']")
    private WebElement signinButton;

    public SignInPage inputEmailAdress(String s){
        input(emailAdressField, s);
        return this;
    }
    public SignInPage inputPwd(String s){
        input(pwdField, s);
        return this;
    }
    public HomePage clickOnSignInButton(){
        click(signinButton);
        return new HomePage(getDriver());
    }
}
