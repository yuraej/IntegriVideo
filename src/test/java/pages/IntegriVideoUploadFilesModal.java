package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class IntegriVideoUploadFilesModal {

    WebDriver driver;
    By dragAndDrop = By.cssSelector("span.integri-chat-manual-upload.integri-pointer");
    By browse = By.cssSelector("integri-file-upload-manual-init");

    public IntegriVideoUploadFilesModal(WebDriver driver) {
        this.driver = driver;
    }

    public void setDragAndDrop (){
        driver.findElement(dragAndDrop).click();
    }
}
