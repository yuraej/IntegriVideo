package pages;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

// этот класс описывает элементы страницы проекта
@Log4j2
public class EditProjectPage {
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


    public EditProjectPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public EditProjectPage enterTestProjectPage() {
        log.info("Открываем страницу проектов");
        driver.findElement(choseProject).click();
        return this;
    }

    public EditProjectPage editProject() {
        driver.findElement(editProject).click();
        return this;
    }

    public String getNameProject() {
        log.info("Получаем название проекта");
        return driver.findElement(nameProject).getText();
    }

    public EditProjectPage setNewNameProject(String text) {
        log.info("Устанавливаем новое имя проекта");
        driver.findElement(newNameProject).clear();
        driver.findElement(newNameProject).sendKeys(text);
        return this;
    }

    public String getDescriptionProject() {
        log.info("Получаем описание проекта");
        return driver.findElement(descriptionProject).getText();
    }

    public EditProjectPage setNewtDescriptionProject(String text) {
        log.info("Устанавливаем новое описание проекта");
        driver.findElement(newDescriptionProject).sendKeys(text);
        return this;
    }

    public String getDomains() {
        log.info("Получаем название домена проекта");
        return driver.findElement(domains).getAttribute("value");
    }

    public EditProjectPage cleanDomainsArea() {
        log.info("Очистили поле домена при помощи кнопки этого поля");
        driver.findElement(cleanDomainsButton).click();
        return this;
    }

    public EditProjectPage setNewDomainsProject(String text) {
        log.info("Установили новый домен проекта");
        driver.findElement(domains).sendKeys(text);
        return this;
    }

    public EditProjectPage setEditProject() {
        log.info("Обновили проект - сохранили изменения");
        driver.findElement(updateButton).click();
        return this;
    }
}
