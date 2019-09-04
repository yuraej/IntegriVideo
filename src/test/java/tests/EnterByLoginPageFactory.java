package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.LoginPageFactory;

import java.util.concurrent.TimeUnit;

import static org.testng.AssertJUnit.assertEquals;

public class EnterByLoginPageFactory {
    WebDriver driver;

    @Parameters({"userName", "password"})
    @Test
    public void logIn(String userName, String password) {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/webdrivers/chromedriver");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        LoginPageFactory openSite = new LoginPageFactory(driver);
        openSite.login(userName, password);
        assertEquals("Projects", driver.findElement(By.className("nav-link")).getText());
    }

    @AfterClass
    void quitBrowser() {
        driver.quit();
    }
}
