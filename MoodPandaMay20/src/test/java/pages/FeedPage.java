package pages;

import com.codeborne.selenide.Condition;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class FeedPage extends BasePage {
    By updateButton = By.id("LinkUpdate");

    public FeedPage openPage() {
        open("https://moodpanda.com/Feed/");
        return this;
    }

    public FeedPage isPageOpened() {
        $(byText("Control my privacy")).waitUntil(Condition.visible, 30000);
        return this;
    }

    public RateHappinessModal openRateHappinessModal() {
        $(updateButton).click();
        RateHappinessModal rateHappinessModal = new RateHappinessModal();
        rateHappinessModal.isModalOpened();
        return rateHappinessModal;
    }
}
