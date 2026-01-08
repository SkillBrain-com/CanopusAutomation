package org.skillbrain.web.structuredScripting;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.safari.SafariOptions;
import org.skillbrain.web.pages.AlertPage;
import org.skillbrain.web.utils.ConfigurationUtils;
import org.skillbrain.web.utils.ScreenshotUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Properties;

public class AlertTest {

    private static Properties properties = ConfigurationUtils.getProperties();
    public static final Logger LOGGER = LoggerFactory.getLogger(AlertTest.class);
    private WebDriver webdriver;
    private final String WEB_URL = properties.getProperty("url");

    @BeforeTest()
    public void initialize() {
        LOGGER.info("Initializing chrome driver....");
        String browser = properties.getProperty("browser");
        String headless = properties.getProperty("headless");
        ChromeOptions options = new ChromeOptions();
        if (Boolean.parseBoolean(headless)) {
            options.addArguments("--headless");
        }
        options.addArguments("--start-maximized");

        switch (browser.toLowerCase()) {
            case "chrome" -> webdriver = new ChromeDriver(options);
            case "firefox" -> webdriver = new FirefoxDriver();
            case "edge" -> webdriver = new EdgeDriver();
            case "safari" -> webdriver = new SafariDriver();
        }

        webdriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        LOGGER.info("Driver successfully initialized.");
    }

    @Test(testName = "Login", groups = "LoginTest")
    public void loginTest() {
        LOGGER.info("Starting Login Test Case...");
        webdriver.get(WEB_URL + "alerts");
        String currentUrl = webdriver.getCurrentUrl();
//        Assert.assertEquals(currentUrl, WEB_URL);
        LOGGER.info("Login Test Case passed.");
    }


    // TODO - fix failing test using waiting mechanisms
    @Test(dependsOnMethods = "loginTest", groups = "AlertTestGroup")
    public void secondAlertTest() {
        AlertPage alertPage = new AlertPage(webdriver);
        alertPage.getClickMeButton1().click();
        webdriver.switchTo().alert().accept();
    }

    @Test(testName = "Test Alerts on DemoQA Page", dependsOnMethods = "loginTest", groups = "AlertTestGroup")
    public void alertTestCase() {
        LOGGER.info("Starting Test Alert On DemoQA page...");
        AlertPage alertPage = new AlertPage(webdriver);
        WebElement confirmBox = alertPage.getClickMeButton3();
        confirmBox.click();
        webdriver.switchTo().alert().accept();
        WebElement confirmMessage = alertPage.getConfirmResult();
        String expectedMessage = "You selected Ok";
        String actualMessage = confirmMessage.getText();
        ScreenshotUtil screenshotUtil = new ScreenshotUtil();
        screenshotUtil.screenshot(webdriver);
        Assert.assertEquals(actualMessage, expectedMessage);
        LOGGER.info("Test passed.");
    }

    @AfterTest
    public void cleanup() {
        webdriver.quit();
    }


}
