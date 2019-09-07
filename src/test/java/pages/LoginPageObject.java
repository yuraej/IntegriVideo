package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import tests.TestData;

public class LoginPageObject {
    WebDriver driver;

    private By enterUserName = By.name("email");
    private By enterPassword = By.name("password");
    private By buttonEnter = By.cssSelector("button.btn.btn-primary");

    public LoginPageObject(WebDriver driver) {
        this.driver = driver;
    }

    public void enterLoginData(String userName, String password) {
        driver.get(TestData.loginPageURL);
        driver.findElement(enterUserName).sendKeys(userName);
        driver.findElement(enterPassword).sendKeys(password);
        driver.findElement(buttonEnter).click();
    }
}
