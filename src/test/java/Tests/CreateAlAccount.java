package Tests;

import Pages.BasePage;
import Pages.EmailPages.HomePage;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class CreateAlAccount extends BasePage {

    @BeforeTest
    public void setDriver() {
        System.setProperty("webdriver.gecko.driver", "A:\\Selenium\\geckodriver-v0.19.1-win64\\geckodriver.exe");
        driver = new FirefoxDriver();
        driver.get("http://www.seznam.cz");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }
    @AfterTest
    public void afterTest() {
        driver.quit();
    }

    @Test
    public void createAlAccount() {
        HomePage homePage = new HomePage(getDriver());
            homePage
                    .clickOnSignInButton()
                    .inputEmailAdress("SeleniumAlda")
                    .inputPwd("fox22555")
                    .clickOnSignInButton()
                    .clickOnReceivedMessages()
                    .clickOnEmailMessage()
                    .clickOnLink();
    }
}
