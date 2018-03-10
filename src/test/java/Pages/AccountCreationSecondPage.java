package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountCreationSecondPage extends BasePage {

    public AccountCreationSecondPage(WebDriver wd){
        super(driver);
    }

    @FindBy(xpath = ".//*[@id='bkrok2']")
    private WebElement confirmButton;

    public AccountCreationSecondPage clickOnConfirmButton(){
        click(confirmButton);
        return this;
    }
}
