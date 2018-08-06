package Tests;

import Pages.BasePage;
import Pages.EmailPages.FoxinPages.WedosPage;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Debug extends BasePage {

    @BeforeTest
    public void setDriver() {
        setDriverPropertiesWedos();
    }
    @AfterTest
    public void afterTest() {
        wd.quit();
    }

    @Test(
            description = "Test"
    )
    public void test() {
        WedosPage wedosPage = new WedosPage(getDriver());
        wedosPage
                .inputLoginName(getCurrentDate().substring(0,4));
        try{
            Thread.sleep(50000);
        }
        catch (InterruptedException e){
            e.printStackTrace();
        }
    }

}
