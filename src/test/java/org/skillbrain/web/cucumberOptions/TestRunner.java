package org.skillbrain.web.cucumberOptions;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/java/org/skillbrain/web/features",
        glue = "org.skillbrain.web.stepDefinitions",
        tags = "@test"
)
public class TestRunner extends AbstractTestNGCucumberTests {

}
