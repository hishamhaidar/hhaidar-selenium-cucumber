package h.software;

import io.cucumber.java.en.Given;

public class RegistrationStepDef extends AbstractStepDefs {

    @Given("the {string} is filled with randomly generated email")
    public void theRegistrationEmailIsFilledWithRandomlyGeneratedEmail(String field) {
        homePage.generateAndFillEmailField(field);
    }
}
