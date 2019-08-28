package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import tests.TestData;

public class LoginPageFactory {
    WebDriver driver;

    @FindBy(name = "email")
    private WebElement emailField;
    @FindBy(name = "password")
    private WebElement passwordField;
    @FindBy(css = "button.btn.btn-primary")
    private WebElement loginButton;

    public LoginPageFactory(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public LoginPageFactory login(String userName, String password) {
        emailField.sendKeys(userName);
        passwordField.sendKeys(password);
        loginButton.click();
        return this;
    }

    public void openLoginPage() {
        driver.get(TestData.urlLoginPage);
    }
}
