package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import tests.TestData;

import java.util.List;

public class BillingPage {
    WebDriver driver;
    WebDriverWait wait;
    ProjectsPage projectsPage;

    @FindBy(linkText = "Add new")
    private WebElement openPagePaymentMethods;
    @FindBy(className = "col-md-7")
    private List<WebElement> cards;
    @FindBy(css = "button.btn")
    private WebElement add;
    @FindBy(name = "name")
    private WebElement name;
    @FindBy(name = "cardholderName")
    private WebElement cardHolderName;
    @FindBy(name = "expirationMonth")
    private WebElement expirationMonth;
    @FindBy(name = "expirationYear")
    private WebElement expirationYear;
    @FindBy(name = "number")
    private WebElement numberCard;
    private By removePaymentMethod = By.xpath("//a[text()='Remove']");

    public BillingPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 10);
        PageFactory.initElements(driver, this);
    }

    public BillingPage openPagePaymentMethods() {
        projectsPage = new ProjectsPage(driver);  // эта и следующая для открытия страницы .../app billing
        projectsPage.billingButton();
        openPagePaymentMethods.click();
        return this;
    }

    public static int counter = 0;

    public BillingPage createPaymentMethod() {
        counter++;
        numberCard.sendKeys(TestData.numberCard1);
        expirationMonth.sendKeys("12");
        expirationYear.sendKeys(TestData.cardExp);
        cardHolderName.sendKeys(TestData.cardHolder);
        wait.until(ExpectedConditions.elementToBeClickable(add));
        add.click();
        return this;
    }

    public int checkCards() {
        return cards.size();
    }

    public void removePaymentMethod(int number) {
        driver.findElements(removePaymentMethod).get(number - 1).click();
    }

    public void makeDefaultPaymentMethod(int number) {
        driver.findElement(By.xpath("//div[@class='col-md-3']//a" + "[" + number + "]")).click();
    }

}
