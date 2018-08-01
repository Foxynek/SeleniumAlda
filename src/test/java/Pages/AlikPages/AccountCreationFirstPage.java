package Pages.AlikPages;

import Pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountCreationFirstPage extends BasePage {

    public AccountCreationFirstPage(WebDriver wd){
        super(wd);
    }

    @FindBy(xpath = ".//*[@id='prezdivka']")
    private WebElement nickNameField;

    @FindBy(xpath = ".//*[@id='heslo']")
    private WebElement pwdField;

    @FindBy(xpath = ".//*[@id='heslo2']")
    private WebElement pwdConfirmField;

    @FindBy(xpath = ".//*[@id='email']")
    private WebElement emailField;

    @FindBy(xpath = ".//*[@id='souhlas']")
    private WebElement consentTickBox;

    @FindBy(xpath = ".//*[@id='bkrok1']")
    private WebElement confirmButton;

    public AccountCreationFirstPage inputNickName(String s){
        input(nickNameField, s);
        return this;
    }
    public AccountCreationFirstPage inputPwd(String s){
        input(pwdField, s);
        return this;
    }
    public AccountCreationFirstPage inputConfirmPwd(String s){
        input(pwdConfirmField, s);
        return this;
    }
    public AccountCreationFirstPage inputEmail(String s){
        input(emailField, s);
        return this;
    }
    public AccountCreationFirstPage clickOnConsentTickBox(){
        click(consentTickBox);
        return this;
    }
    public AccountCreationSecondPage clickOnConfirmButton(){
        click(confirmButton);
        return new AccountCreationSecondPage(getDriver());
    }
}
