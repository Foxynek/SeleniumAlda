
package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ChatRoomPage extends BasePage {
    public ChatRoomPage(WebDriver wd){
        super(driver);
    }
    @FindBy(xpath=".//*[@id='say']")
    private WebElement inputMessage;

    @FindBy (xpath=".//*[@id='send-text']")
    private WebElement clickOnSend;

    @FindBy (xpath=".//*[@href='/k/jen-tak-na-pokec/odejit']")
    private WebElement clickOnLeaveRoom;

    public ChatSelectionPage clickOnLeaveRoomButton(){
        click(clickOnLeaveRoom);
        return new ChatSelectionPage(getDriver());
    }

    public ChatRoomPage inputMessage(String s){
        input(inputMessage, s);
        return this;
    }
    public ChatRoomPage clickOnSend(){
        click(clickOnSend);
        return this;
    }
}

