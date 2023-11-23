package h.software;


import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LoginStepDef extends AbstractStepDefs {
    @Given("the {string} field is filled with {string}")
    public void theFieldIsFilledWithText(String field, String text) {
        homePage.fillOutField(field, text);
    }


    @Then("the my account navigation is visible")
    public void theMyAccountNavigationIsVisible() {
        assertTrue(homePage.isNavigationDisplayed());
    }
}
