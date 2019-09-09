package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.LoginPageFactory;
import pages.LoginPageObject;

import java.util.concurrent.TimeUnit;

public class EnterByLoginPageObject extends BaseTest{

    @Test
    public void logIn() {
        LoginPageObject login = new LoginPageObject(driver);
        login.enterLoginData("tms1@mailinator.com", "Password01");
    }
}
