package org.skillbrain.web.structuredScripting;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.skillbrain.web.utils.ConfigurationUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

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

        switch (browser.toLowerCase()) {
            case "chrome" -> webdriver = new ChromeDriver();
            case "firefox" -> webdriver = new FirefoxDriver();
            case "edge" -> webdriver = new EdgeDriver();
            case "safari" -> webdriver = new SafariDriver();
        }

        webdriver.manage().window().maximize();
        LOGGER.info("Driver successfully initialized.");
    }

    @Test(testName = "Login", groups = "LoginTest")
    public void loginTest() {
        LOGGER.info("Starting Login Test Case...");
        webdriver.get(WEB_URL);
        String currentUrl = webdriver.getCurrentUrl();
        Assert.assertEquals(currentUrl, WEB_URL);
        LOGGER.info("Login Test Case passed.");
    }


    // TODO - fix failing test using waiting mechanisms
    @Test(dependsOnMethods = "loginTest", groups = "AlertTestGroup")
    public void secondAlertTest() {
        Assert.assertEquals(webdriver.getCurrentUrl(), WEB_URL);
        webdriver.findElement(By.xpath("(//button[text()='Click me'])[2]")).click();
//        NO NO!
//        try {
//            Thread.sleep(Duration.ofSeconds(6));
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
        webdriver.switchTo().alert().accept();
    }

    @Test(testName = "Test Alerts on DemoQA Page", dependsOnMethods = "loginTest", groups = "AlertTestGroup")
    public void alertTestCase() {
        LOGGER.info("Starting Test Alert On DemoQA page...");
        WebElement confirmBox = webdriver.findElement(By.xpath("(//button[text()='Click me'])[3]"));
        confirmBox.click();
        webdriver.switchTo().alert().accept();
        WebElement confirmMessage = webdriver.findElement(By.xpath("//span[@id='confirmResult']"));
        String expectedMessage = "You selected Ok";
        String actualMessage = confirmMessage.getText();
        Assert.assertEquals(actualMessage, expectedMessage);
        LOGGER.info("Test passed.");
    }

    @AfterTest
    public void cleanup() {
        webdriver.quit();
    }


}
