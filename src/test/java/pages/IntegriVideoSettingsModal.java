package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class IntegriVideoSettingsModal {
    WebDriver driver;
    //WebDriverWait wait = new WebDriverWait(driver, 12);
    By settings = By.xpath("//span[text()=' Settings']");
    By guest = By.name("userName");
    By eMail = By.name("userEmail");
    By avatar = By.name("userPic");
    By save = By.className("integri-user-settings-save integri-button-blue");
    By cancel = By.linkText("Cancel");
    By cross = By.className("iv-icon iv-icon-cross close-integri-modal");
    By saveSettings = By.xpath("//button[text()='Save']");
    By dataSettings = By.className("integri-session-user-name");

    public IntegriVideoSettingsModal(WebDriver driver){
        this.driver = driver;
    }

    public void inputSettings (){
        driver.findElement(settings).click();
    }
    public  void inputUserName(String text){
        driver.findElement(guest).clear();
        driver.findElement(guest).sendKeys(text);
    }
    public void inputEmail(String text){
        driver.findElement(eMail).sendKeys(text);
    }
    public void inputAvatar(String link){
        driver.findElement(avatar).sendKeys(link);
    }
    public void setSaveSettings(){
        driver.findElement(saveSettings).click();
    }
    public String  checkDataSettings(){
        //wait.until(ExpectedConditions.textToBe(dataSettings, "editedText"));
        return driver.findElement(dataSettings).getText();
    }
}
