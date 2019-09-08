package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import tests.Card;

import java.util.List;

public class BillingPage {
    private WebDriver driver;
    private WebDriverWait wait;
    private ProjectsPage projectsPage;
    public static int counter = 0;

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

    public void createPaymentMethod(Card card) {
        counter++;
        numberCard.sendKeys(card.getNumberCard());
        expirationMonth.sendKeys("12");
        expirationYear.sendKeys(card.getExpirationYear());
        cardHolderName.sendKeys(card.getCardHolderName());
        wait.until(ExpectedConditions.elementToBeClickable(add));
        add.click();
    }

    public int getNumberOfCards() {
        return cards.size();
    }

    public BillingPage removePaymentMethod(int number) {
        driver.findElements(removePaymentMethod).get(number - 1).click();
        return this;
    }

    public void makeDefaultPaymentMethod(int number) {
        driver.findElements(By.xpath("//div[@class='col-md-3']")).get(number - 1).click();
    }
}