package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import pages.LoginPageObject;

import java.util.concurrent.TimeUnit;

import static org.testng.AssertJUnit.assertEquals;

public class BaseTest {
    WebDriver driver;
    LoginPageObject login;

    protected void checkNumberElements(int numberExpect, int numberActual) {
        assertEquals(numberExpect, numberActual);
    }

    protected void checkCurrentURLAndGoBack(String pageLink) {
        assertEquals(pageLink, driver.getCurrentUrl());
        driver.navigate().back();
    }

    @BeforeTest
    void inputParameters() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/webdrivers/chromedriver");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        login = new LoginPageObject(driver);
        login.enterLoginData("tms1@mailinator.com", "Password01");
    }

  /*  @AfterClass
    void quitBrowser() {
        driver.quit();
    }*/
}
