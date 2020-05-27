package tests;

import com.codeborne.selenide.Configuration;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import pages.LoginPage;

import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

@Listeners(TestListener.class)
public class BaseTest {

    LoginPage loginPage;

    @BeforeMethod
    public void setupBrowser() {
        Configuration.headless = true;
        Configuration.startMaximized = true;
        Configuration.timeout = 20000;
        Configuration.browser = "chrome";
        Configuration.clickViaJs = false;
        loginPage = new LoginPage();
    }

    @AfterMethod (alwaysRun = true)
    public void closeBrowser() {
        getWebDriver().quit();
    }
}
