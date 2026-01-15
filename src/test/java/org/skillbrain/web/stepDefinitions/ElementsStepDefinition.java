package org.skillbrain.web.stepDefinitions;

import io.cucumber.java.PendingException;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.skillbrain.web.pages.ElementsPage;
import org.skillbrain.web.utils.TestContext;

public class ElementsStepDefinition {

    private TestContext testContext;
    private ElementsPage elementsPage;

    public ElementsStepDefinition(TestContext testContext) {
        this.testContext = testContext;
        elementsPage = testContext.getPageObjectManager().getElementsPage();
    }

    @When("User clicks on the text box element")
    public void clickTextBox() {
        elementsPage.clickTextBox();
    }

    @When("User fills user name with {string}")
    public void userFillsUserNameWith(String name) {
        elementsPage.fillInUserName(name);
    }

    @When("User fills email with {string}")
    public void user_fills_email_with(String string) {
      elementsPage.fillInEmail(string);
    }
    @When("User fills in address with {string}")
    public void user_fills_in_address_with(String string) {
        elementsPage.fillInAddress(string);
    }

    @When("User fills in permanent address {int}")
    public void user_fills_in_permanent_address(int number) {
     elementsPage.fillInPermanentAddress(number);
    }
    @When("User clicks submit")
    public void user_clicks_submit() {
        elementsPage.clickSubmit();
    }

    @Then("I check the correct information is returned on the page")
    public void iCheckTheCorrectInformationIsReturnedOnThePage() {
        elementsPage.checkSubmit();
    }
}
