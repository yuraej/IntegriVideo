package tests;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import pages.LoginPageObject;
import java.util.concurrent.TimeUnit;
import static org.testng.AssertJUnit.assertEquals;

@Log4j2
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
        log.info("Подключаем драйвер для браузера Хром");
        System.setProperty("webdriver.chrome.driver", "src/test/resources/webdrivers/chromedriver");
        driver = new ChromeDriver();
        log.info("Устанавливаем временные задержки для неявного ожидания - 5 сек.");
        log.info("Устанавливаем максимальный размер окна браузера");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        login = new LoginPageObject(driver);
        log.info("Вводим имя пользователя и пароль");
        login.enterLoginData("tms1@mailinator.com", "Password01");
    }

   /* @AfterClass
    void quitBrowser() {
        log.info("Тест отработал, выходим из браузера");
        driver.quit();
    }*/
}
