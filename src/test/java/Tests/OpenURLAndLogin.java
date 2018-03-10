package Tests;

import Pages.AfterLoginPage;
import Pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;


public class OpenURLAndLogin extends BasePage {

    public OpenURLAndLogin(WebDriver driver) {
        super(driver);
        setDriver();
        getURL("http://www.alik.cz");
    }
    @Test
    public void OpenURL() {
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

}
