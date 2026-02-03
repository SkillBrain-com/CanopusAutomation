package teme.beatrice.TestNg;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

public class BaseTest {
    protected static WebDriver driver;
    protected WebDriverWait wait;

    @BeforeMethod
   @Parameters
    public void setUp(@Optional("desktop")String device){
        ChromeOptions options = new ChromeOptions();
        if (device.equalsIgnoreCase("mobile")){
            Map<String, Object> mobileEmulation = new HashMap<>();
            mobileEmulation.put("deviceName", "Iphone x");

        }else {
            options.addArguments("--start-maximized");
        }
        driver = new ChromeDriver(options);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }




    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
