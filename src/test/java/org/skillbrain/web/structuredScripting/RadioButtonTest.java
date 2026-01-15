package org.skillbrain.web.structuredScripting;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.skillbrain.web.pages.RadioButtonPage;
import org.skillbrain.web.utils.ConfigurationUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.Properties;

public class RadioButtonTest {

    private static Properties properties = ConfigurationUtils.getProperties();
    public static final Logger LOGGER = LoggerFactory.getLogger(AlertTest.class);
    private WebDriver driver;
    private final String WEB_URL = properties.getProperty("url");

//    @BeforeTest()
    public void initialize() throws MalformedURLException {
        LOGGER.info("Initializing chrome driver....");
        String browser = properties.getProperty("browser");
        String headless = properties.getProperty("headless");
        ChromeOptions options = new ChromeOptions();
        if (Boolean.parseBoolean(headless)) {
            options.addArguments("--headless");
        }
        options.addArguments("--start-maximized");

        switch (browser.toLowerCase()) {
            case "chrome" -> driver = new ChromeDriver(options);
            case "firefox" -> driver = new FirefoxDriver();
            case "edge" -> driver = new EdgeDriver();
            case "safari" -> driver = new SafariDriver();
            case "remote" -> driver = new RemoteWebDriver(new URL("http://192.168.68.56:4444"), options);
        }

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        LOGGER.info("Driver successfully initialized.");
    }

//    @Test(testName = "RadioButtonTest")
    public void radioButtonTest() {
        RadioButtonPage radioButtonPage = new RadioButtonPage(driver);
        driver.get(WEB_URL + "radio-button");

        WebElement noRadio = radioButtonPage.getNoRadio();
        WebElement noRadioLabel = radioButtonPage.getNoRadioLabel();
        WebElement impressiveLabel = radioButtonPage.getNoRadioImpressive();
        noRadioLabel.click();
        impressiveLabel.click();
        boolean isEnabled = noRadio.isEnabled();

        if (isEnabled) {
            System.out.println("Button is enabled");
        } else {
            System.out.println("Button is disabled");
        }

        WebElement element = radioButtonPage.getMt3Element();

        Assert.assertEquals(element.getText(), "You have selected Impressive");

    }

//    @AfterTest
    public void cleanup() {
        driver.quit();
    }
}
