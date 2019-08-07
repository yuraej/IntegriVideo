package tests;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.IntegriVideoSettingsModal;
import pages.IntegriVideoChatPage;
import pages.IntegriVideoUploadFilesModal;

import java.awt.*;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import static org.testng.AssertJUnit.assertEquals;

public class CheckIntegriVideo {
    WebDriver driver;
    @BeforeClass
    public void startTest(){
        System.setProperty("webdriver.chrome.driver", "src/test/resources/webdrivers/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://dev.integrivideo.com/demo/chat/new");
        driver.manage().timeouts().implicitlyWait(12, TimeUnit.SECONDS);

    }

   @Test
    public void checkIntegriVideoChatPage() throws IOException, UnsupportedFlavorException {
        IntegriVideoChatPage chat = new IntegriVideoChatPage(driver);
        chat.inviteUser();
        String link = (String) Toolkit.getDefaultToolkit().getSystemClipboard().getData(DataFlavor.stringFlavor);
        assertEquals(link, driver.getCurrentUrl());
        chat.inputMessage("test");
        chat.sendMassageByButton();
        assertEquals(chat.checkMessage(), "test");
        chat.editMassage();
        chat.inputMessage("test2");
        chat.sendMassageByEnter();
        chat.settingsInput();
        chat.dragAndDrop();
        String textCode = chat.checkCode();
        String textCodeMemory = (String) Toolkit.getDefaultToolkit().getSystemClipboard().getData(DataFlavor.stringFlavor);
        assertEquals(textCodeMemory, textCode);
    }
    @Test
    public void checkIntegriVideoSettingsModal(){
        IntegriVideoSettingsModal settingsModal = new IntegriVideoSettingsModal(driver);
        settingsModal.inputSettings();
        settingsModal.inputUserName("BONE");
        settingsModal.inputEmail("yura@tut.by");
        settingsModal.inputAvatar("https://avatarko.ru/img/avatar/2/cherep_kapyushon_uzhasy_1606.jpg");
        settingsModal.setSaveSettings();

        //assertEquals("BONE", settingsModal.checkDataSettings());
    }

    @Test
    public void checkIntegriVideoUploadFilesModal(){
        IntegriVideoUploadFilesModal loadFiles = new IntegriVideoUploadFilesModal(driver);
        loadFiles.setDragAndDrop();
    }

   @AfterClass
    public void endTest(){
        driver.quit();
    }

}
