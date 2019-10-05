package pages;

import io.qameta.allure.Allure;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import utils.AllureUtils;

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

    @Step("Открываем страницу проекта")
    public EditProjectPage enterTestProjectPage() {
        log.info("Открываем страницу проекта");
        driver.findElement(choseProject).click();
        AllureUtils.takeScreenshot(driver);
        return this;
    }

    @Step("Нажимаем кнопку Edit")
    public EditProjectPage editProject() {
        log.info("Нажимаем кнопку Edit");
        driver.findElement(editProject).click();
        return this;
    }

    @Step("Получаем название проекта")
    public String getNameProject() {
        log.info("Получаем название проекта");
        return driver.findElement(nameProject).getText();
    }

    @Step("Устанавливаем новое имя проекта")
    public EditProjectPage setNewNameProject(String text) {
        log.info("Устанавливаем новое имя проекта");
        driver.findElement(newNameProject).clear();
        driver.findElement(newNameProject).sendKeys(text);
        return this;
    }

    @Step("Получаем описание проекта")
    public String getDescriptionProject() {
        log.info("Получаем описание проекта");
        return driver.findElement(descriptionProject).getText();
    }

    @Step("Устанавливаем новое описание проекта")
    public EditProjectPage setNewtDescriptionProject(String text) {
        log.info("Устанавливаем новое описание проекта");
        driver.findElement(newDescriptionProject).sendKeys(text);
        return this;
    }

    @Step("Получаем название домена проекта")
    public String getDomains() {
        log.info("Получаем название домена проекта");
        return driver.findElement(domains).getAttribute("value");
    }

    @Step("Очистили поле домена при помощи кнопки этого поля")
    public EditProjectPage cleanDomainsArea() {
        log.info("Очистили поле домена при помощи кнопки этого поля");
        driver.findElement(cleanDomainsButton).click();
        return this;
    }

    @Step("Установили новый домен проекта")
    public EditProjectPage setNewDomainsProject(String text) {
        log.info("Установили новый домен проекта");
        driver.findElement(domains).sendKeys(text);
        return this;
    }

    @Step("Обновили проект - сохранили изменения")
    public void setEditProject() {
        log.info("Обновили проект - сохранили изменения");
        AllureUtils.takeScreenshot(driver);
        driver.findElement(updateButton).click();
    }
}
