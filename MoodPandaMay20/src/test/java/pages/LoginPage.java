package pages;

import com.codeborne.selenide.Condition;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.*;

public class LoginPage extends BasePage{

    public LoginPage openPage() {
        open("https://moodpanda.com/Login/");
        isPageOpened();
        return this;
    }

    public LoginPage isPageOpened() {
        $("[alt='MoodPanda Android App on Google Play'").waitUntil(Condition.visible, 30000);
        return this;
    }

    public FeedPage login(String email, String password) {
        //TODO придумать как убрать sleep
        sleep(2000);
        $(By.id("ContentPlaceHolderContent_TextBoxEmail")).setValue(email);
        $(By.id("ContentPlaceHolderContent_TextBoxPassword")).setValue(password);
        $(By.id("ContentPlaceHolderContent_ButtonLogin")).click();
        FeedPage feedPage = new FeedPage();
        feedPage.isPageOpened();
        return feedPage;
    }
}
