package org.skillbrain.web.stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Scenario;
import io.cucumber.messages.types.Hook;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.skillbrain.web.utils.TestContext;

import java.io.File;
import java.io.IOException;

public class Hooks {

    private TestContext testContext;

//    Constructor injection
    public Hooks(TestContext testContext) {
        this.testContext = testContext;
    }

    @After
    public void afterScenario() {
        testContext.getDriver().quit();
    }

    @AfterStep
    public void addScreenshot(Scenario scenario) throws IOException {
        WebDriver driver = testContext.getDriver();
        if (scenario.isFailed()) {
            File source = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            byte[] bytes = FileUtils.readFileToByteArray(source);
            scenario.attach(bytes, "image/png", "image");
        }
    }
}
