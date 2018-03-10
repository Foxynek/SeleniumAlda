package Pages.EmailPages;

import Pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ConfirmRegistrationPage extends BasePage {

    public ConfirmRegistrationPage(WebDriver wd){
        super(driver);
    }
    @FindBy(xpath = ".//a[@class='to-homepage']")
    private WebElement homepageButton;

    public HomePage clickOnHomepageButton(){
        click(homepageButton);
        return new HomePage(getDriver());
    }
}