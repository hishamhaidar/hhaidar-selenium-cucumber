package h.software;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ShoppingStepDef extends AbstractStepDefs{
    @And("the user added {string} to the basket")
    public void theUserAddedItemToTheBasket(String item) {
        homePage.addItemToCart(item);
    }

    @Then("the total price should be {string}")
    public void theTotalPriceShouldBeTotalPrice(String total) {
        assertEquals(total, homePage.getTotal());
    }

    @And("the user sign out")
    public void theUserSignOut() {
        homePage.signOut();
    }

    @Then("the check out page is open")
    public void theCheckOutPageIsOpen() {
        homePage.refreshPage();
        assertEquals("https://practice.automationtesting.in/checkout/",homePage.getCurrentUrl());
    }

    @And("zip code is {string}")
    public void zipCodeIsZip(String zip) {
        homePage.fillZipCode(zip);
    }

    @Given("the user visit check out page")
    public void theUserVisitCheckOutPage() {
        homePage.goCheckout();
    }
}
