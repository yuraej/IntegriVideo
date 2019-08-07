package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class IntegriVideoUploadFilesModal {

    WebDriver driver;
    WebDriverWait wait;
    By dragAndDrop = By.cssSelector("span.integri-chat-manual-upload.integri-pointer");
    By browse = By.cssSelector("integri-file-upload-manual-init");

    public IntegriVideoUploadFilesModal(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 7);
    }

    public void setDragAndDrop (String linkToFile){
        driver.findElement(dragAndDrop).click();
        driver.findElement(By.xpath("//input[@type='file']")).sendKeys(linkToFile);
        driver.findElement(By.xpath("//button[text()='Start']")).click();
       // wait.until(ExpectedConditions.invisibilityOfElementLocated()
    }
}
