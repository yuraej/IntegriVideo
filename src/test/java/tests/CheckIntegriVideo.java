package tests;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.IntegriVideoChatPage;

import java.awt.*;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;
import java.sql.Driver;
import java.util.concurrent.TimeUnit;

import static org.testng.AssertJUnit.assertEquals;

public class CheckIntegriVideo {
    WebDriver driver;
    @BeforeClass
    public void startTest(){
        System.setProperty("webdriver.chrome.driver", "src/test/resources/webdrivers/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    @Test
    public void checkIntegriVideoChatPage() throws IOException, UnsupportedFlavorException {
        IntegriVideoChatPage chat = new IntegriVideoChatPage(driver);
        chat.openPage();
        chat.inviteUser();
        String link = (String) Toolkit.getDefaultToolkit().getSystemClipboard().getData(DataFlavor.stringFlavor);
        assertEquals(link, driver.getCurrentUrl());
        chat.inputMessage("test");
        chat.sendMassageByButton();
        String textMassage = chat.checkMessage();
        assertEquals(textMassage, "test");
        chat.editMassage();
        chat.inputMessage("test2");
        chat.sendMassageByEnter();
        chat.settingsInput();
        chat.dragAndDrop();
        String textCode = chat.checkCode();
        String textCodeMemory = (String) Toolkit.getDefaultToolkit().getSystemClipboard().getData(DataFlavor.stringFlavor);
        assertEquals(textCodeMemory, textCode);
    }

   @AfterClass
    public void endTest(){
        driver.quit();
    }

}
//https://avatarko.ru/img/avatar/2/cherep_kapyushon_uzhasy_1606.jpg