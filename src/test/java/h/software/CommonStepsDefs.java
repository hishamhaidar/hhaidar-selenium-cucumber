package h.software;

import io.cucumber.java.AfterAll;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CommonStepsDefs extends AbstractStepDefs{
    @Given("the home page is opened")
    public void theHomePageIsOpened() {
        homePage.openPage();
    }
    @And("the user clicked on the {string} button")
    public void theUserClickedOnTheButton(String button) {
        homePage.clickButton(button);
    }
    @When("the {string} button is clicked")
    public void theLoginButtonIsClicked(String button) {
        homePage.clickButton(button);
    }


    @And("the cookies is accepted")
    public void theCookiesIsAccepted() {
        homePage.acceptCookies();
    }

    @AfterAll
    public static void cleanUp() {
        homePage.closePage();
    }

    @Then("the {string} message is shown in {string} section")
    public void theErrorMessageMessageIsShownInLoginErrorSection(String errorMessage, String field) {
        assertEquals(errorMessage, homePage.getErrorMessage(field));
    }
    @Then("the my account navigation is visible")
    public void theMyAccountNavigationIsVisible() {
        assertTrue(homePage.isNavigationDisplayed());
    }

}
