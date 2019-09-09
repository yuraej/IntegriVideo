package tests;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import pages.BillingPage;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertEquals;

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
        checkNumberElements(BillingPage.counter, billingPage.getNumberOfCards());
        counter = BillingPage.counter;
    }

    @Test(dependsOnMethods = "testingBillingPage")
    public void makeAndCheckDefaultPaymentMethod() {
        billingPage = new BillingPage(driver);
        billingPage.makeDefaultPaymentMethod(choiceNumberPayMethod);
        assertEquals("Default", driver.findElements(By.xpath("//div[@class='col-md-3']")).get(choiceNumberPayMethod - 1).getText());
    }

    @Test(dependsOnMethods = {"testingBillingPage", "makeAndCheckDefaultPaymentMethod"})
    public void checkRemovePaymentMethods() {
        billingPage = new BillingPage(driver);
        checkNumberElements(billingPage.getNumberOfCards(), counter);
        billingPage.removePaymentMethod(3).
                removePaymentMethod(2).
                removePaymentMethod(1);
        counter--;
    }
}
