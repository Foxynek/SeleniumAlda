package Pages.EmailPages.FoxinPages;

import Pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class WedosPage extends BasePage {

    public WedosPage(WebDriver wd){
        super(wd);
        waitForPageToLoad(getDriver(), menu_label);
    }

    @FindBy(xpath = ".//*[@id='user_login']")
    private WebElement loginName_textField;

    @FindBy(xpath= ".//*[@id='user_passwd']")
    private WebElement paswword_textField;

    @FindBy(xpath = ".//*[@id='frm_input_']")
    private WebElement login_button;

    @FindBy(xpath = ".//*[@id='menu']")
    private WebElement menu_label;

    @FindBy(xpath = ".//*[@id='content']/h1")
    private WebElement message_label;

    @FindBy(xpath = ".//*[text()='Webhosting']")
    private WebElement webHosting_button;

    @FindBy(xpath = ".//*[text()='foxin.cz']")
    private WebElement domainName_button;

    @FindBy(xpath = ".//*[text()='Informace']")
    private WebElement informationTable_label;

    @FindBy(xpath = ".//*[@id='menu']/div[1]/div/ul/li[9]/a")
    private WebElement newEmail_link;

    @FindBy(xpath = ".//*[@id='frm_input_u_alias']")
    private WebElement newEmailName_textField;

    @FindBy(xpath = ".//*[@id='frm_input_u_aliases']")
    private WebElement alianame_textField;

    @FindBy(xpath = ".//*[contains(@id,'passwd_input')]")
    private WebElement emailPassword_textField;

    @FindBy(xpath = ".//*[@id='frm_input_u_password_cnf']")
    private WebElement emailPasswordConfirm_textField;

    @FindBy(xpath= ".//*[@id='frm_input_u_create']")
    private WebElement createEmail_button;

    @FindBy(xpath = ".//*[@id='menu']/div[1]/div/ul/li[7]/a/strong")
    private WebElement emailList_button;

    @FindBy(xpath = ".//*[@id='content']/div[3]/div/ul/li")
    private WebElement confirmationMessage_label;

    public WedosPage inputLoginName(String input){
        input(loginName_textField, input);
        return this;
    }
    public WedosPage inputLoginPassword(String input){
        input(paswword_textField, input);
        return this;
    }
    public WedosPage clickOnLoginButton(){
        click(login_button);
        waitForPageToLoad(getDriver(), message_label);
        return this;
    }
    public WedosPage clickOnWebHostingButton(){
        click(webHosting_button);
        waitForPageToLoad(getDriver(), domainName_button);
        return this;
    }
    public WedosPage clickOnDomainNameButton(){
        click(domainName_button);
        waitForPageToLoad(getDriver(), informationTable_label);
        return this;
    }
    public WedosPage clickOnNewEmailAdressButton(){
        click(newEmail_link);
        waitForPageToLoad(getDriver(), createEmail_button);
        return this;
    }
    public WedosPage inputNewEmailName(String input){
        input(newEmailName_textField, input);
        return this;
    }
    public WedosPage inputNewEmailPassword(String input){
        input(emailPassword_textField, input);
        return this;
    }
    public WedosPage inputNewEmailConfirmPassword(String input){
        input(emailPasswordConfirm_textField, input);
        return this;
    }
    public WedosPage clearAliasNames(){
        input(alianame_textField, "");
        return this;
    }
    public WedosPage clickOnCreateEmailButton(){
        click(createEmail_button);
        return this;
    }
    public WedosPage clickOnEmailListButton(){
        click(emailList_button);
        return this;
    }
    public WedosPage deleteAnEmail(String emailName){
        if (getDriver().findElements(By.xpath(".//*[text()='"+emailName+"']/preceding-sibling::td/img")).size()>0) {
            click(getDriver().findElement(By.xpath(".//*[text()='" + emailName + "']/preceding-sibling::td/img")));
            getDriver().switchTo().alert().accept();
            return this;
        }
        else throw new NullPointerException();
    }
    public String getConfirmationMessage(){return confirmationMessage_label.getText();}
    public String getMessage(){return message_label.getText();}
}
