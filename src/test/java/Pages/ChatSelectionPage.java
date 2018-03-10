
package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ChatSelectionPage extends BasePage {
    public ChatSelectionPage(WebDriver wd){
        super(driver);
    }
    @FindBy(xpath=".//strong/a[@href='/k/jen-tak-na-pokec']")
    private WebElement clickOnChatRoom;

    public ChatRoomPage clickOnChatRoom(){
        click(clickOnChatRoom);
        return new ChatRoomPage(getDriver());
    }
}

