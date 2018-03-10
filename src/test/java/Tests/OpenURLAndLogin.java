package Tests;

import Pages.AfterLoginPage;
import Pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class OpenURLAndLogin extends BasePage {

    public OpenURLAndLogin(WebDriver driver) {
        super(driver);
    }
    @Test (description = "test")
      public void OpenURL() {
        getURL("http://www.alik.cz");
        AfterLoginPage afterLoginPage = new AfterLoginPage(getDriver());
            afterLoginPage
                  .inputUserName("McCree")
                  .inputPwd("222555")
                  .clickOnLogin()
                  .clickOnChat()
                  .clickOnChatRoom()
                  .inputMessage("ahoj")
                  .clickOnSend();
      }
}
