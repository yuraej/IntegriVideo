package pages;

import org.checkerframework.checker.units.qual.A;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.rmi.activation.ActivationDesc;

public class AddProjectPage {
    private WebDriver driver;
    private WebDriverWait wait;
    private By create = By.xpath("//button[text()='Create']");
    private By update = By.xpath("//button[text()='Update']");

    public AddProjectPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 10);
        PageFactory.initElements(driver, this);
    }

    public AddProjectPage createProject(String projectName, String description, String domainsName) {
        driver.findElement(By.xpath("//div[text()='Add project']")).click();
        driver.findElement(By.name("name")).sendKeys(projectName);
        driver.findElement(By.cssSelector("textarea[placeholder='Type here...']")).sendKeys(description);
        driver.findElement(By.name("domains[]")).sendKeys(domainsName);
        driver.findElement(create).click();
        return this;
    }

    public AddProjectPage choseComponent() {
        driver.findElement(By.xpath("//div[text()='Add new component']")).click();
        driver.findElement(By.className("select2-selection__arrow")).click();
        return this;
    }

    public AddProjectPage addComponentVideoChat(String nameComponent) {
        driver.findElement(By.xpath("//li[contains(text(),'Video Chat')]")).click();
        driver.findElement(By.name("name")).sendKeys(nameComponent);
        driver.findElement(create).click();
        driver.findElement(update).click();
        return this;
    }

    public AddProjectPage addComponentMultiDeviceVideoPlayer(String nameComponent) {
        driver.findElement(By.xpath("//li[contains(text(),'Multi-device Video Player')]")).click();
        driver.findElement(By.name("name")).sendKeys(nameComponent);
        driver.findElement(create).click();
        driver.findElement(update).click();
        return this;
    }

    public AddProjectPage addComponentSingleVideo(String nameComponent) {
        driver.findElement(By.xpath("//li[contains(text(),'Single Video')]")).click();
        driver.findElement(By.name("name")).sendKeys(nameComponent);
        driver.findElement(create).click();
        driver.findElement(update).click();
        return this;
    }

    public AddProjectPage addMultipartyVideo(String nameComponent) {
        driver.findElement(By.xpath("//li[contains(text(),'Multiparty Video')]")).click();
        driver.findElement(By.name("name")).sendKeys(nameComponent);
        driver.findElement(create).click();
        driver.findElement(update).click();
        return this;
    }

    public AddProjectPage choseProject(int number) {
        driver.findElements(By.cssSelector("div.col-xl-4.col-sm-6")).get(number - 1).click();
        return this;
    }
}
