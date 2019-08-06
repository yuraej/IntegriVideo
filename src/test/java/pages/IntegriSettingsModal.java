package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class IntegriSettingsModal {
    WebDriver driver;
    By guest = By.name("userName");
    By eMail = By.name("userEmail");
    By avatar = By.name("userPic");
    By save = By.className("integri-user-settings-save integri-button-blue");
    By cancel = By.linkText("Cancel");
    By cross = By.className("iv-icon iv-icon-cross close-integri-modal");
}
