package h.software;

import io.cucumber.java.AfterAll;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

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
    @AfterAll
    public static void cleanUp() {
        homePage.closePage();
    }

    @And("the cookies is accepted")
    public void theCookiesIsAccepted() {
        homePage.acceptCookies();
    }
}
