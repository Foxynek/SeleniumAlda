package Pages.EmailPages.SeznamPages;

import Pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ConfirmRegistrationPage extends BasePage {

    public ConfirmRegistrationPage(WebDriver wd){
        super(wd);
        switchToLastWindowHandle();
        waitForPageToLoad(getDriver(), homepageButton);
    }
    @FindBy(xpath = ".//a[@class='to-homepage']")
    private WebElement homepageButton;

    public HomePage clickOnHomepageButton(){
        click(homepageButton);
        return new HomePage(getDriver());
    }
}
