
package Tests;

import Pages.AlikPages.AfterLoginPage;
import Pages.BasePage;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class OpenURLAndLogin extends BasePage {

    @BeforeTest
    public void setDriver(){
        setDriverPropertiesAlda();
    }
    @AfterTest
    public void afterTest() {
        wd.quit();
    }

    @Test
    public void openURL() {
        AfterLoginPage afterLoginPage = new AfterLoginPage(getDriver());
            afterLoginPage
                  .inputUserName(getUserNameAlda())
                  .inputPwd(getUserPasswordAlda())
                  .clickOnLogin()
                  .clickOnChat()
                  .clickOnChatRoom()
                  .inputMessage("test")
                  .clickOnSend()
                  .inputMessage("test done")
                  .clickOnSend()
                  .clickOnLeaveRoomButton()
                  .clickOnLogoutButton();
        Assert.assertEquals(afterLoginPage.checkWhetherLoginFormIsPresent(), "Login form is present");
      }
}

