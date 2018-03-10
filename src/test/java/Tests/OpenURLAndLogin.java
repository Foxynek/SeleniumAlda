
package Tests;

import Pages.AfterLoginPage;
import Pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import java.util.concurrent.TimeUnit;

public class OpenURLAndLogin extends BasePage {

    @BeforeTest
    public void setDriver(){
        System.setProperty("webdriver.gecko.driver", "A:\\Selenium\\geckodriver-v0.19.1-win64\\geckodriver.exe");
        driver = new FirefoxDriver();
        driver.get("http://www.alik.cz");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void openURL() {
        AfterLoginPage afterLoginPage = new AfterLoginPage(getDriver());
            afterLoginPage
                  .inputUserName("McCree")
                  .inputPwd("222555")
                  .clickOnLogin()
                  .clickOnChat()
                  .clickOnChatRoom()
                  .inputMessage("ahoj")
                  .clickOnSend();
            System.out.println("done");
      }

    @AfterTest
    public void afterTest() {
        driver.quit();
    }
}

