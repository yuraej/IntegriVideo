package tests;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import pages.BillingPage;

import static org.testng.Assert.assertEquals;

@Log4j2
public class BillingPageTests extends BaseTest {
    private BillingPage billingPage;
    private int counter;
    private Card card = new Card(TestData.numberCard1, TestData.cardExp, TestData.cardHolder);
    private int choiceNumberPayMethod = 2;

    @Test(invocationCount = 3)          // invocation добавлено в учебных целях: для закрепления материала
    public void testingBillingPage() {
        billingPage = new BillingPage(driver).
                openPagePaymentMethods();
        checkCurrentURLAndGoBack(TestData.paymentMethodsPageURL);
        billingPage.openPagePaymentMethods().
                createPaymentMethod(card);
        try {
            checkNumberElements(BillingPage.counter, billingPage.getNumberOfCards());
        } catch (AssertionError e) {
            log.error("Ошибка теста добавления кредиток:\n" + e);
        }
        counter = BillingPage.counter;
    }

    @Test(dependsOnMethods = "testingBillingPage")
    public void makeAndCheckDefaultPaymentMethod() {
        billingPage = new BillingPage(driver);
        billingPage.makeDefaultPaymentMethod(choiceNumberPayMethod);
        try {
            assertEquals("Default", driver.findElements(By.xpath("//div[@class='col-md-3']")).get(choiceNumberPayMethod - 1).getText());
        } catch (AssertionError e) {
            log.error("Ошибка теста проверки установки карты оплаты по умолчанию\n" + e);
        }
    }

    @Test(dependsOnMethods = {"testingBillingPage", "makeAndCheckDefaultPaymentMethod"})
    public void checkRemovePaymentMethods() {
        billingPage = new BillingPage(driver);
        try {
            checkNumberElements(billingPage.getNumberOfCards(), counter);
        } catch (AssertionError e) {
            log.error("Ошибка теста удаления кредиток:\n" + e);
        }
        billingPage.removePaymentMethod(3).
                removePaymentMethod(2).
                removePaymentMethod(1);
        counter--;
    }
}
