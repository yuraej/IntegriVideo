package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class IntegriVideoChatPage {
    WebDriver driver;
    public static final String URL ="https://dev.integrivideo.com/demo/chat/new";
    By inviteLink = By.id("invite-users-to-chat");
    By inputArea = By.xpath("//*[@placeholder='Start typing here']");
    By sendMassageButton = By.xpath("//*[@title='Send message']");
    By settings = By.cssSelector("span.integri-chat-settings.integri-pointer");
    By dragAndDrop = By.cssSelector("span.integri-chat-manual-upload.integri-pointer");
    By code = By.className("component-code");
    By text = By.className("integri-chat-message");
    By edit = By.cssSelector("span.iv-icon.iv-icon-pencil.integri-chat-edit-message");
    By editText = By.tagName("textarea");

    public IntegriVideoChatPage(WebDriver driver){
        this.driver = driver;
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
    public String checkMessage(){
        return driver.findElement(text).getText();
    }
    public void editMassage(){
        driver.findElement(edit).click();
        driver.findElement(editText).clear();
        driver.findElement(editText).sendKeys("test3");
        driver.findElement(editText).sendKeys(Keys.ENTER);
    }
    public String checkCode (){
        driver.findElement(code).click();
        String textCode =  driver.findElement(code).getText().replace("\n","")
                                                             .replace("\r","");
        return textCode;
    }

}
