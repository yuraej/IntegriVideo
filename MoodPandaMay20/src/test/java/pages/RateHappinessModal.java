package pages;

import com.codeborne.selenide.Condition;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import static com.codeborne.selenide.Selenide.$;

public class RateHappinessModal extends BaseModal {

    By sliderCss = By.cssSelector(".ui-slider-handle");
    By updateButtonCss = By.cssSelector(".ButtonUpdate");
    By goToMyDiaryCss = By.cssSelector(".ButtonMyDiary");

    public RateHappinessModal isModalOpened() {
        $(updateButtonCss).waitUntil(Condition.visible, 30000);
        return this;
    }

    public RateHappinessModal updateMood(int moodRating) {
        $(sliderCss).click();
        int currentMoodCount = 5;
        int difference = moodRating - currentMoodCount;
        Keys arrowValue;
        if(difference > 0) {
            arrowValue = Keys.ARROW_RIGHT;
        } else {
            arrowValue = Keys.ARROW_LEFT;
        }
        for(int i = 0; i < Math.abs(difference); i++) {
            $(sliderCss).sendKeys(arrowValue);
        }
        $(updateButtonCss).click();
        return this;
    }

    public MyDiaryPage goToMyDiary() {
        $(goToMyDiaryCss).click();
        MyDiaryPage myDiaryPage = new MyDiaryPage();
        myDiaryPage.isPageOpened();
        return myDiaryPage;
    }
}
