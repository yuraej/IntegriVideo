package tests;

import org.testng.annotations.Test;
import pages.BillingPage;

import java.util.concurrent.TimeUnit;

public class BillingPageTests extends BaseTest {
    BillingPage billingPage;

    @Test
    public void testingBillingPage() {
        billingPage = new BillingPage(driver);
        billingPage.openPagePaymentMethods();

        checkAndReturn(TestData.paymentMethodsPageURL);
        checkNumberElements(BillingPage.counter, billingPage.checkCards());
    }

    @Test
    public void createPayMethod() {
        billingPage = new BillingPage(driver);
        billingPage.openPagePaymentMethods();
        billingPage.createPaymentMethod();
    }
}
