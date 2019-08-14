package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class IntegriVideoUploadFilesModal {
    WebDriver driver;
    WebDriverWait wait;
    By dragAndDrop = By.cssSelector("span.integri-chat-manual-upload.integri-pointer");
    By browse = By.className("integri-file-upload-manual-init");
    By dragAndDropStart = By.xpath("//button[text()='Start']");

    public IntegriVideoUploadFilesModal(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 7);
    }

    public void upLoadFiles(String linkToFile) {
        driver.findElement(dragAndDrop).click();
        driver.findElement(browse).sendKeys(linkToFile);
        driver.findElement(dragAndDropStart).click();
        wait.until(ExpectedConditions.elementToBeClickable(dragAndDropStart));
    }
}
