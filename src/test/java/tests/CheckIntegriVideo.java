package tests;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
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
    public void startTest() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/webdrivers/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://dev.integrivideo.com/demo/chat/new");
        driver.manage().timeouts().implicitlyWait(12, TimeUnit.SECONDS);
    }

    @Test
    public void checkInputMessageByButton() {
        IntegriVideoChatPage chat = new IntegriVideoChatPage(driver);
        chat.openPage();
        chat.inputMessage(System.getProperty("testProp"));
        chat.sendMassageByButton();
        assertEquals(chat.checkMessage("test123"), "test123");
    }

    @Test
    public void checkInputMessageByEnter() {
        IntegriVideoChatPage chat = new IntegriVideoChatPage(driver);
        chat.openPage();
        chat.inputMessage("test2");
        chat.sendMassageByEnter();
        assertEquals(chat.checkMessage("test2"), "test2");
    }

    @Test
    public void checkEditMessage() {
        IntegriVideoChatPage chat = new IntegriVideoChatPage(driver);
        chat.openPage();
        chat.inputMessage("test");
        chat.sendMassageByButton();
        chat.editMassage("test3");
        assertEquals(chat.checkMessage("test3"), "test3");
    }

    @Test
    public void checkDeleteMessage() {
        IntegriVideoChatPage chat = new IntegriVideoChatPage(driver);
        chat.openPage();
        chat.inputMessage("test");
        chat.sendMassageByEnter();
        chat.deleteMessage();
        assertEquals(chat.checkMessage("removed..."), "removed...");
    }

    @Test
    public void checkInviteUser() throws IOException, UnsupportedFlavorException {
        IntegriVideoChatPage chat = new IntegriVideoChatPage(driver);
        chat.inviteUser();
        String link = (String) Toolkit.getDefaultToolkit().getSystemClipboard().getData(DataFlavor.stringFlavor);
        assertEquals(link, driver.getCurrentUrl());
    }

    @Test
    public void checkCopyCode() throws IOException, UnsupportedFlavorException {
        IntegriVideoChatPage chat = new IntegriVideoChatPage(driver);
        String textCode = chat.checkCode();
        String textCodeMemory = (String) Toolkit.getDefaultToolkit().getSystemClipboard().getData(DataFlavor.stringFlavor);
        assertEquals(textCodeMemory, textCode);
    }

    @Test
    public void checkSendEmptyMessage() {
        IntegriVideoChatPage chat = new IntegriVideoChatPage(driver);
        chat.openPage();
        chat.inputMessage("test");
        chat.sendMassageByEnter();
        chat.checkEmptyMessage();
        assertEquals("Message cannot be empty!", chat.checkEmptyMessage());
    }

    @Test
    public void checkSendThousandWords() {
        IntegriVideoChatPage chat = new IntegriVideoChatPage(driver);
        chat.openPage();
        chat.inputMessage(TestData.thousandOfWords);
        chat.sendMassageByButton();
        assertEquals(TestData.thousandOfWords, driver.findElement(By.className("integri-chat-message-text")).getText().concat(" "));
    }

    @Test
    public void checkSendElevenMessage() {
        IntegriVideoChatPage chat = new IntegriVideoChatPage(driver);
        chat.openPage();
        chat.inputMessage(TestData.elevenMessages);
        chat.sendMassageByEnter();
        assertEquals(chat.checkSendElevenMassages(), "This is trial version\n" +
                "Sign up or Skip");
    }

    @Test
    public void checkSendLinkMessage() {
        IntegriVideoChatPage chat = new IntegriVideoChatPage(driver);
        chat.openPage();
        chat.inputMessage("tut.by");
        chat.sendMassageByEnter();
        assertEquals(chat.checkLinkByMassage("tut.by"), "http://tut.by/");
        chat.openPage();
    }

    @Test
    public void checkSendCodeMessage() {
        IntegriVideoChatPage chat = new IntegriVideoChatPage(driver);
        chat.openPage();
        chat.inputMessage("<html><body><p>test</p></body></html>");
        chat.sendMassageByEnter();
        assertEquals("<html><body><p>test</p></body></html>", chat.checkMessage("<html><body><p>test</p></body></html>"));
        chat.settingsInput();
        chat.dragAndDrop();
    }

    @Test
    public void inputSettingsModal() {
        IntegriVideoSettingsModal settingsModal = new IntegriVideoSettingsModal(driver);
        settingsModal.inputSettings();
        settingsModal.inputUserName("BONE");
        settingsModal.inputEmail("yura@tut.by");
        settingsModal.inputAvatar("https://avatarko.ru/img/avatar/2/cherep_kapyushon_uzhasy_1606.jpg");
        settingsModal.setSaveSettings();
        assertEquals("BONE", settingsModal.checkDataSettings("BONE"));
    }

    @Test
    public void renameSettingsModal() {
        IntegriVideoSettingsModal settingsModal = new IntegriVideoSettingsModal(driver);
        settingsModal.inputSettings();
        settingsModal.inputUserName("MAN");
        settingsModal.inputEmail("yurick@tut.by");
        settingsModal.inputAvatar("https://avatarko.ru/img/avatar/11/film_10038.jpg");
        settingsModal.setSaveSettings();
        assertEquals("MAN", settingsModal.checkDataSettings("MAN"));
    }

    @Test
    public void checkUploadFilesModal() {
        IntegriVideoUploadFilesModal loadFiles = new IntegriVideoUploadFilesModal(driver);
        loadFiles.upLoadFiles(TestData.linkFile1);
        loadFiles.upLoadFiles(TestData.linkFile2);
    }

  /*  @AfterClass
    public void endTest() {
        driver.quit();
    }*/
}
