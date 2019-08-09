package pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class IntegriVideoChatPage {
    WebDriver driver;
    WebDriverWait wait;
    public static final String URL ="https://dev.integrivideo.com/demo/chat/new";
    By inviteLink = By.id("invite-users-to-chat");
    By inputArea = By.xpath("//*[@placeholder='Start typing here']");
    By sendMassageButton = By.xpath("//*[@title='Send message']");
    By settings = By.cssSelector("span.integri-chat-settings.integri-pointer");
    By dragAndDrop = By.cssSelector("span.integri-chat-manual-upload.integri-pointer");
    By code = By.className("component-code");
    By textMassage = By.className("integri-chat-message-text");
    By edit = By.cssSelector("span.iv-icon.iv-icon-pencil.integri-chat-edit-message");
    By editText = By.tagName("textarea");
    By delete = By.cssSelector("span.iv-icon.iv-icon-trash2.integri-chat-remove-message");
    By emptyMessage = By.cssSelector("div.integri-notify.integri-notify-error");
    By sendElevenMassages = By.className("integri-demo-version");

    public IntegriVideoChatPage(WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(driver,5);
    }

    public void openPage(){
        driver.get(URL);
    }
    public void inviteUser(){
        driver.findElement(inviteLink).click();
    }
    public void inputMessage(String massage){
        driver.findElement(inputArea).sendKeys(massage);
    }
    public void sendMassageByButton(){
        driver.findElement(sendMassageButton).click();
    }
    public void sendMassageByEnter(){
        driver.findElement(inputArea).sendKeys(Keys.ENTER);
    }
    public void settingsInput(){
        driver.findElement(settings).click();
        driver.findElement(By.linkText("Cancel")).click();
    }
    public void dragAndDrop(){
        driver.findElement(dragAndDrop).click();
        driver.findElement(By.xpath("//button[text()='Cancel']")).click();
    }
    public String checkMessage(String text){
        wait.until(ExpectedConditions.textToBe(textMassage, text));
       return driver.findElement(textMassage).getText();
    }
    public String  checkLinkByMassage(String link){
        return driver.findElement(By.linkText(link)).getAttribute("href");
    }
    public void editMassage(String text){
        driver.findElement(edit).click();
        driver.findElement(editText).clear();
        driver.findElement(editText).sendKeys(text);
        driver.findElement(editText).sendKeys(Keys.ENTER);

    }
    public String checkCode (){
        driver.findElement(code).click();
        String textCode =  driver.findElement(code).getText().replace("\n","")
                                                             .replace("\r","");
        return textCode;
    }
    public void deleteMessage(){
        driver.findElement(delete).click();
        Alert alert = driver.switchTo().alert();
        alert.accept();
    }
    public String checkEmptyMessage(){
        driver.findElement(edit).click();
        driver.findElement(editText).clear();
        driver.findElement(editText).sendKeys(Keys.ENTER);
        return driver.findElement(emptyMessage).getText();
    }
    public String checkSendElevenMassages(){
        return driver.findElement(sendElevenMassages).getText();
    }


}
