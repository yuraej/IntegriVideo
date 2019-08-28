package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.LoginPageFactory;
import pages.LoginPageObject;

import java.util.concurrent.TimeUnit;

public class EnterByLoginPageObject {
    WebDriver driver;

    @BeforeClass
    public void startTest() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/webdrivers/chromedriver");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @Test
    public void logIn() {
        LoginPageObject login = new LoginPageObject(driver);
        login.openLoginPage();
        login.enterLoginData("tms1@mailinator.com", "Password01");
    }

    @AfterClass
    public void closeBrowser() {
        driver.quit();
    }
}
