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

public class EnterByLoginPageFactory extends BaseTest {

    @Parameters({"userName", "password"})
    @Test
    public void logIn(String userName, String password) {
        LoginPageFactory openSite = new LoginPageFactory(driver);
        openSite.login(userName, password);
        assertEquals("Projects", driver.findElement(By.className("nav-link")).getText() );
    }
}
