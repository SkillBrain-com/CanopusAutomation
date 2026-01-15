package org.skillbrain.web.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Properties;

public class TestBase {

    private WebDriver driver;
    private WebDriverWait wait;

    public WebDriver getDriver() {
        Properties properties = ConfigurationUtils.getProperties();
        String browser = properties.getProperty("browser");
        if (browser == null) {
            browser = "chrome";
        }
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
        }
        return driver;
    }

    public void setWait() {
        if (wait == null) {
            wait = new WebDriverWait(this.driver, Duration.ofSeconds(10));
        }
    }

    public WebDriverWait getWebDriverWait() {
        return wait;
    }
}
