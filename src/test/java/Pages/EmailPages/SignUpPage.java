package Pages.EmailPages;

import Pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SignUpPage extends BasePage {
    public SignUpPage(WebDriver wd){
        super(wd);
        switchToLastWindowHandle();
        waitForPageToLoad(getDriver(), emailAdressField);
    }
    @FindBy(xpath = ".//*[@id='register-username']")
    private WebElement emailAdressField;
    @FindBy(xpath = ".//parent::form[@class='main']/input[@data-placeholder='register.password1']")
    private WebElement passwordField;
    @FindBy(xpath = ".//parent::form[@class='main']/input[@data-placeholder='register.password2']")
    private WebElement passwordConfirmField;
    @FindBy(xpath = ".//*[@id='register-year']")
    private WebElement yearOfBirth;
    @FindBy(xpath = ".//parent::form[@class='main']/fieldset/label/span[@data-locale='register.male']")
    private WebElement genderRadioButton;
    @FindBy(xpath = ".//*[@id='register']/div/form[1]/label/span")
    private WebElement termsOfUseTickBox;
    @FindBy(xpath = ".//button[@data-locale='register.submit']")
    private WebElement confirmButton;

    public SignUpPage inputEmailAdress(String s){
        input(emailAdressField, s);
        return this;
    }
    public SignUpPage inputPassword(String s){
        input(passwordField, s);
        return this;
    }
    public SignUpPage inputConfirmPassword(String s){
        input(passwordConfirmField, s);
        return this;
    }
    public SignUpPage inputYearOfBirth(String s){
        input(yearOfBirth, s);
        return this;
    }
    public SignUpPage clickOnGender(){
        click(genderRadioButton);
        return this;
    }
    public SignUpPage clickTickBox(){
        click(termsOfUseTickBox);
        return this;
    }
    public ConfirmRegistrationPage clickOnConfirmButton(){
        try{
            Thread.sleep(5000);
            click(confirmButton);
        }
        catch (InterruptedException e){
            e.printStackTrace();
        }
        return new ConfirmRegistrationPage(getDriver());
    }
}
