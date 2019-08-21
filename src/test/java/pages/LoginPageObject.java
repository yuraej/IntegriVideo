package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import tests.TestData;

public class LoginPageObject {
    WebDriver driver;

    By enterUserName = By.name("name");
    By enterPassword = By.name("password");
    By buttonEnter = By.cssSelector("button.btn.btn-primary");

    public LoginPageObject(WebDriver driver) {
        this.driver = driver;
    }

    public void enterLoginData(String userName, String password) {
        driver.findElement(enterPassword).sendKeys(userName);
        driver.findElement(enterPassword).sendKeys(password);
    }

    public void openLoginPage() {
        driver.get(TestData.urlLoginPage);
    }
}
