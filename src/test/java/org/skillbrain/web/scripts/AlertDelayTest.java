package org.skillbrain.web.scripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.skillbrain.web.structuredScripting.AlertTest;
import org.skillbrain.web.utils.ConfigurationUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;
import java.util.Properties;

public class AlertDelayTest {

    private static Properties properties = ConfigurationUtils.getProperties();
    public static final Logger LOGGER = LoggerFactory.getLogger(AlertTest.class);
    private WebDriver webdriver;
    private WebDriverWait wait;
    private final String WEB_URL = properties.getProperty("url");

//    @BeforeTest()
    public void initialize() {
        LOGGER.info("Initializing chrome driver....");
        String browser = properties.getProperty("browser");
        String headless = properties.getProperty("headless");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        if (Boolean.parseBoolean(headless)) {
            options.addArguments("--headless");
        }

        switch (browser.toLowerCase()) {
            case "chrome" -> webdriver = new ChromeDriver(options);
            case "firefox" -> webdriver = new FirefoxDriver();
            case "edge" -> webdriver = new EdgeDriver();
            case "safari" -> webdriver = new SafariDriver();
        }

        webdriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        wait = new WebDriverWait(webdriver, Duration.ofSeconds(20));

        LOGGER.info("Driver successfully initialized.");
    }

//    @Test(testName = "Alert with Delay", groups = "LoginTest")
    public void loginTest() {
        LOGGER.info("Starting Login Test Case...");

        String alertsPage = String.format("https://demoqa.com/%s", "alerts");
        webdriver.get(alertsPage);

//        WebElement alertWithDelay = webdriver.findElement(By.xpath("//button[@id='timerAlertButton']"));

        wait.until(ExpectedConditions
                        .visibilityOfElementLocated(By.xpath("//button[@id='timerAlertButton']")))
                .click();

        LOGGER.debug("Clicked on alert with delay button.");

        wait.until(ExpectedConditions.alertIsPresent());

    }


//    @AfterTest
    public void cleanup() {
        webdriver.quit();
    }


}
