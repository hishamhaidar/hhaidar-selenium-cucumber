package h.software;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.Map;

public class HomePage {
    private static final String PAGE_URL = "https://practice.automationtesting.in/";
    private final WebDriver driver;
    public HomePage(WebDriver driver) {
        this.driver = driver;
    }
    @FindBy(css = "ul.woocommerce-error")
    private WebElement errorMessage;
    @FindBy(css = "")
    private WebElement priceLabel;
    @FindBy(css = "button.fc-button.fc-cta-do-not-consent.fc-secondary-button[aria-label='Do not consent']")
    private WebElement doNotConsentCookies;
    private boolean isCookieAccepted;
    @FindBy(css = ".woocommerce-MyAccount-navigation")
    private WebElement myAccountNavigation;
    private static final Map<String, By> textFields = Map.of(
            "Username", By.id("username"),
            "Password", By.id("password")
    );
    private static final Map<String, By> navigationButtons = Map.of(
            "My account",By.id("menu-item-50"),
            "Login", By.cssSelector("input[type='submit'][class='woocommerce-Button button'][name='login'][value='Login']")

    );
    public void openPage() {
        driver.get(PAGE_URL);
        PageFactory.initElements(driver, this);
    }
    public void closePage() {
        driver.quit();
    }

    public void clickButton(String button) {
        driver.findElement(navigationButtons.get(button)).click();
    }

    public void fillOutField(String field, String text) {
        driver.findElement(textFields.get(field)).sendKeys(text);
    }

    public String getErrorMessage() {
        return errorMessage.getText();
    }

    public void acceptCookies() {
        if(!isCookieAccepted)
        { this.doNotConsentCookies.click();
           isCookieAccepted=true;
        }
    }
    public boolean isNavigationDisplayed(){
        return  this.myAccountNavigation.isDisplayed();
    }
}
