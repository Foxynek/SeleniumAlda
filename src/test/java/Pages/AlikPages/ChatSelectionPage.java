
package Pages.AlikPages;

import Pages.AlikPages.AfterLoginPage;
import Pages.AlikPages.ChatRoomPage;
import Pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ChatSelectionPage extends BasePage {
    public ChatSelectionPage(WebDriver wd){
        super(wd);
    }
    @FindBy(xpath=".//strong/a[@href='/k/jen-tak-na-pokec']")
    private WebElement clickOnChatRoom;
    @FindBy(xpath = ".//a[@href='/odhlasit']")
    private WebElement logoutButton;

    public ChatRoomPage clickOnChatRoom(){
        click(clickOnChatRoom);
        return new ChatRoomPage(getDriver());
    }
    public AfterLoginPage clickOnLogoutButton(){
        click(logoutButton);
        return new AfterLoginPage(getDriver());
    }
}

