package tests;

import org.testng.annotations.Test;
import pages.BillingPage;

import java.util.concurrent.TimeUnit;

public class BillingPageTests extends BaseTest {
    BillingPage billingPage;
    private int counter;

    @Test(invocationCount = 3)
    public void testingBillingPage() {
        billingPage = new BillingPage(driver);
        billingPage.openPagePaymentMethods();
        checkAndReturn(TestData.paymentMethodsPageURL);
        billingPage.openPagePaymentMethods();
        billingPage.createPaymentMethod();
        checkNumberElements(BillingPage.counter, billingPage.checkCards());
        counter = BillingPage.counter;
    }

    @Test(dependsOnMethods = "testingBillingPage",
            invocationCount = 3)
    public void checkRemovePaymentMethods() {
        billingPage = new BillingPage(driver);
        checkNumberElements(billingPage.checkCards(), counter);
        billingPage.removePaymentMethod(1);                 // метод может удалять карты в любой последовательности
        counter--;
    }

 /*   @Test(dependsOnMethods = "testingBillingPage")
    public void test2() {
        billingPage = new BillingPage(driver);
        driver.get("https://dev.integrivideo.com/app/billing");
        billingPage.makeDefaultPaymentMethod(2);
    }*/
}
