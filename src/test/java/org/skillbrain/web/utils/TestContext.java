package org.skillbrain.web.utils;

import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.skillbrain.web.pages.PageObjectManager;

@Getter
public class TestContext {

    private WebDriver driver;
    private PageObjectManager pageObjectManager;
    private TestBase testBase;

    public TestContext() {
        testBase = new TestBase();
        driver = testBase.getDriver();
        pageObjectManager = new PageObjectManager(driver);
    }

}
