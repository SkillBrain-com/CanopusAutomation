package org.skillbrain.web.stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.skillbrain.web.pages.DemoQaPage;
import org.skillbrain.web.utils.TestContext;
import org.testng.Assert;

public class DemoQaStepDefinition {

    private WebDriver driver;
    private DemoQaPage demoQaPage;
    public TestContext testContext;

    // dependency injection with constructor !!!!
    public DemoQaStepDefinition(TestContext testContext) {
        this.testContext = testContext;
        demoQaPage = testContext.getPageObjectManager().getDemoQaPage();
        driver = testContext.getDriver();
        testContext.getTestBase().setWait();
    }

    @Given("User is on the demoqa page")
    public void userIsOnDemoQaPage() {
        demoQaPage.goToDemoQa();
    }


    //    User navigates to "forms" page
    @When("User navigates to {string} page")
    public void navigateTo(String card) {
        demoQaPage.navigate(card);
    }


    @Then("User is redirected to {string} page")
    public void userIsRedirectedToTheFormsPage(String page) {
        Assert.assertEquals(driver.getCurrentUrl().toLowerCase(), page.toLowerCase());
    }
}
