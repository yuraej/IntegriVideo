package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

// этот класс описывает элементы страницы проекта
public class TestProjectPage {
    private WebDriver driver;

    private By choseProject = By.cssSelector("div.circle");
    private By editProject = By.linkText("Edit");
    private By nameProject = By.xpath("//div//h1");                            // элемент доступен со страницы пакета
    private By descriptionProject = By.cssSelector("div.col-12.description");  // элемент доступен со страницы пакета
    private By newNameProject = By.name("name");                                      // элемент доступен со страницы редактирования
    private By newDescriptionProject = By.cssSelector("textarea[name='description']");      // элемент доступен со страницы редоктирования
    private By domains = By.name("domains[]");
    private By cleanDomainsButton = By.className("input-group-text");
    private By updateButton = By.xpath("//button[text()='Update']");


    public TestProjectPage(WebDriver driver) {
        this.driver = driver;
    }

    public void enterTestProjectPage() {
        driver.findElement(choseProject).click();
    }

    public void editProject() {
        driver.findElement(editProject).click();
    }

    public String getNameProject() {
        return driver.findElement(nameProject).getText();
    }

    public void setNewNameProject(String text) {
        driver.findElement(newNameProject).clear();
        driver.findElement(newNameProject).sendKeys(text);
    }

    public String getDescriptionProject() {
        return driver.findElement(descriptionProject).getText();
    }

    public void setNewtDescriptionProject(String text) {
        driver.findElement(newDescriptionProject).sendKeys(text);
    }

    public String getDomains() {
        return driver.findElement(domains).getAttribute("value");
    }

    public void cleanDomainsArea() {
        driver.findElement(cleanDomainsButton).click();
    }

    public void setNewDomainsProject(String text) {
        driver.findElement(domains).sendKeys(text);
    }

    public void setEditProject() {
        driver.findElement(updateButton).click();
    }
}
