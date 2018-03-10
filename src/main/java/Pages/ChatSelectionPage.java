package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ChatSelectionPage extends BasePage {
    public ChatSelectionPage(WebDriver driver){
        super(driver);
    }
    @FindBy(xpath=".//*[@id='content']/div[3]/div[3]/ul[1]/li[5]/div[2]/div[1]/strong/a")
    private WebElement clickOnChatRoom;

    public ChatRoomPage clickOnChatRoom(){
        click(clickOnChatRoom);
        return new ChatRoomPage(getDriver());
    }
}
