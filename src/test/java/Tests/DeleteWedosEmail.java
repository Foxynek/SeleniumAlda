package Tests;

import Pages.BasePage;
import Pages.EmailPages.FoxinPages.WedosPage;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class DeleteWedosEmail extends BasePage {
    @BeforeTest
    public void setDriver() {
        setDriverPropertiesWedos();
    }
    @AfterTest
    public void afterTest() {
        wd.quit();
    }
    @Test(
            description = "Delete Wedos WebMail"
    )
    public void deleteWedosEmail(){
        WedosPage wedosPage = new WedosPage(getDriver());
        String message = wedosPage
                .inputLoginName(getUserNameWedos())
                .inputLoginPassword(getUserPasswordWedos())
                .clickOnLoginButton()
                .clickOnWebHostingButton()
                .clickOnDomainNameButton()
                .clickOnEmailListButton()
                .deleteAnEmail("")
                .getConfirmationMessage();
        Assert.assertEquals(message, "Schránka odstraněna");
    }
}
