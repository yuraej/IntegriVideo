package tests;

import io.qameta.allure.Description;
import org.testng.annotations.Test;

public class MoodPandaTest extends BaseTest {

    @Test
    @Description("Описание теста")
    public void login() {
        loginPage
                .openPage()
                .login("dmitryr@mailinator.com", "password01")
                .openRateHappinessModal()
                .updateMood(9)
                .goToMyDiary();
    }
}
