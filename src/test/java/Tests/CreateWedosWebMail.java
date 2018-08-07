package Tests;

import CSVHelper.CSVHelper;
import Pages.BasePage;
import Pages.EmailPages.FoxinPages.WedosPage;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class CreateWedosWebMail extends BasePage{

    @BeforeTest
    public void setDriver() {
        setDriverPropertiesWedos();
    }
    @AfterTest
    public void afterTest() {
        wd.quit();
    }
    @Test(
            description = "Create New Wedos WebMail"
    )
    public void createNewWedosWebMail(ITestContext context){
        context.setAttribute("emailName", "bot"+getCurrentDate().substring(0,4)+getCurrentTime());
        WedosPage wedosPage = new WedosPage(getDriver());
        String message = wedosPage
                .inputLoginName(getUserNameWedos())
                .inputLoginPassword(getUserPasswordWedos())
                .clickOnLoginButton()
                .clickOnWebHostingButton()
                .clickOnDomainNameButton()
                .clickOnNewEmailAdressButton()
                .inputNewEmailName(context.getAttribute("emailName").toString())
                .inputNewEmailPassword("bot#Alik00")
                .inputNewEmailConfirmPassword("bot#Alik00")
                .clearAliasNames()
                .clickOnCreateEmailButton()
                .getMessage();
        Assert.assertTrue(message.contains(context.getAttribute("emailName").toString()), message);
        CSVHelper.findDuplicatesInCSVFileAndReplace("wedosMails", "account"+getCurrentDate()+getCurrentTime(), context.getAttribute("emailName").toString());
    }
}
