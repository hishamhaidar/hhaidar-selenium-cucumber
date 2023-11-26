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
    @FindBy(css = "ul.woocommerce-thankyou-order-details li.total")
    private WebElement priceLabel;
    @FindBy(css = "button.fc-button.fc-cta-do-not-consent.fc-secondary-button[aria-label='Do not consent']")
    private WebElement doNotConsentCookies;
    private boolean isCookieAccepted;
    @FindBy(css = ".woocommerce-MyAccount-navigation")
    private WebElement myAccountNavigation;
    private static final Map<String, By> textFields = Map.of(
            "Username", By.id("username"),
            "Password", By.id("password"),
            "Registration email", By.id("reg_email"),
            "Registration password", By.id("reg_password"),
            "first name", By.id("billing_first_name"),
            "last name", By.id("billing_last_name"),
            "buyer mail", By.id("billing_email"),
            "buyer phone", By.id("billing_phone"),
            "buyer address", By.id("billing_address_1"),
            "buyer city", By.id("billing_city")
    );
     @FindBy(id ="billing_postcode")
     private WebElement zipCode;
    private static final Map<String, By> errorMessages = Map.of(
            "loginError", By.cssSelector("ul.woocommerce-error"),
            "regPasswordError",By.cssSelector("div.woocommerce-password-strength"),
            "registrationError", By.cssSelector("ul.woocommerce-error"),
            "checkOutError",By.cssSelector(" ul.woocommerce-error")

    );
    private static final Map<String, By> navigationButtons = Map.of(
            "My account",By.id("menu-item-50"),
            "Login", By.cssSelector("input[type='submit'][class='woocommerce-Button button'][name='login'][value='Login']"),
            "Register",By.cssSelector("input[type='submit'][class='woocommerce-Button button'][name='register'][value='Register']"),
            "Sign out",By.linkText("Logout"),
            "Shop",By.id("menu-item-40"),
            "Basket",By.id("wpmenucartli"),
            "Checkout",By.cssSelector("div.wc-proceed-to-checkout>a.checkout-button"),
            "Proceed",By.cssSelector("div.place-order>input[id='place_order']")

    );
    private static final Map<String, By> itemButtons = Map.of(
            "Android Quick Start Guide", By.cssSelector("a[data-product_id='169']"),
            "Functional Programming in JS", By.cssSelector("a[data-product_id='170']"),
            "HTML5 Forms", By.cssSelector("a[data-product_id='181']"),
            "HTML5 WebApp Develpment", By.cssSelector("a[data-product_id='182']"),
            "JS Data Structures and Algorithm", By.cssSelector("a[data-product_id='180']"),
            "Mastering JavaScript", By.cssSelector("a[data-product_id='165']"),
            "Selenium Ruby", By.cssSelector("a[data-product_id='160']"),
            "Thinking in HTML", By.cssSelector("a[data-product_id='163']")

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

    public String getErrorMessage(String field) {
        return driver.findElement(errorMessages.get(field)).getText();
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
    private String generatedMail() {
        StringBuilder generatedMail = new StringBuilder();
        generatedMail.append("h");
        generatedMail.append((int) Math.floor(Math.random()*1000));
        generatedMail.append("@h");
        generatedMail.append((int) Math.floor(Math.random()*1000));
        generatedMail.append(".com");
        return String.valueOf(generatedMail);

    }
    public void generateAndFillEmailField(String field) {
        driver.findElement(textFields.get(field)).sendKeys(generatedMail());
    }


    public void signOut() {
        driver.get(PAGE_URL+"/my-account/customer-logout");
    }

    public String getTotal() {
        return priceLabel.getText().split("\n")[1];
    }

    public void addItemToCart(String item) {
        driver.findElement(itemButtons.get(item)).click();
    }
public void refreshPage(){
    driver.navigate().refresh();
}
    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }

    public void fillZipCode(String zip) {
        zipCode.sendKeys(zip);
    }

    public void goCheckout() {
        driver.get(PAGE_URL+"/checkout/");
    }
}
