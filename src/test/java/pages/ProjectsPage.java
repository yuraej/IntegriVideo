package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProjectsPage {
    WebDriver driver;

    @FindBy(xpath = "//a[@href='/app/library']")
    private WebElement libraryButton;
    @FindBy(xpath = "//a[@href='/app/billing']")
    private WebElement billingButton;
    @FindBy(xpath = "//a[@href='/logout']")
    private WebElement logOutButton;
    @FindBy(css = "img[alt='logo']")
    private WebElement integriVideoButton;
    @FindBy(xpath = "//a[@href='/app/projects']")
    private WebElement projectsButton;
    @FindBy(xpath = "//a[@href='/app/projects/new']")
    private WebElement addProjectButton;

    public ProjectsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public ProjectsPage libraryButton() {
        libraryButton.click();
        return this;
    }

    public ProjectsPage billingButton() {
        billingButton.click();
        return this;
    }

    public ProjectsPage logOutButton() {
        logOutButton.click();
        return this;
    }

    public ProjectsPage integriVideoButton() {
        integriVideoButton.click();
        return this;
    }

    public ProjectsPage projectsButton() {
        projectsButton.click();
        return this;
    }


    public ProjectsPage addProjectsButton() {
        addProjectButton.click();
        return this;
    }
}
