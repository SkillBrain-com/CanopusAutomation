package org.skillbrain.web.stepDefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.skillbrain.web.pages.RadioButtonPage;
import org.skillbrain.web.utils.TestContext;
import org.testng.Assert;

public class RadioButtonStepDefinition {

    private TestContext testContext;
    private WebDriver driver;
    private RadioButtonPage radioButtonPage;

    public RadioButtonStepDefinition(TestContext testContext) {
        this.testContext = testContext;
        this.driver = testContext.getDriver();
        radioButtonPage = testContext.getPageObjectManager().getRadioButtonPage();
    }


    @When("User clicks on {string} radio button")
    public void userClicksOnRadioButton(String button) {
        radioButtonPage.clickOnRadio(button);
    }


    @Then("User checks the following message is displayed: {string}")
    public void userChecksTheFollowingMessgesIsDisplayed(String message) {
        String output = driver.findElement(By.xpath("//p")).getText();
        Assert.assertEquals(output, message);
    }
}
