package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ChatRoomPage extends BasePage{
    public ChatRoomPage(WebDriver driver){
        this.driver = driver;
    }
    @FindBy(xpath=".//*[@id='say']")
    private WebElement inputMessage;

    @FindBy (xpath=".//*[@id='send-text']")
    private WebElement clickOnSend;

    public ChatRoomPage inputMessage(String s){
        input(inputMessage, s);
        return new ChatRoomPage(getDriver());
    }
    public ChatRoomPage clickOnSend(){
        click(clickOnSend);
        return new ChatRoomPage(getDriver());
    }
}
