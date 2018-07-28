
package Tests;

import Pages.AfterLoginPage;
import Pages.BasePage;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class OpenURLAndLogin extends BasePage {

    @BeforeTest
    public void setDriver(){
        setDriverProperties();
    }
    @AfterTest
    public void afterTest() {
        driver.quit();
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
}

