package teme.patricia.Selenium3;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.time.Duration;

public class DynamicButtonsSimple {

        @Test
        public void dynamicButtonsSimpleTest() {
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--start-maximized");
            options.addArguments("--remote-allow-origins=*");
            WebDriver driver = new ChromeDriver(options);

            driver.get("https://testpages.herokuapp.com/styled/dynamic-buttons-simple.html");

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));


            wait.until(ExpectedConditions.elementToBeClickable(By.id("button00"))).click();
            wait.until(ExpectedConditions.elementToBeClickable(By.id("button01"))).click();
            wait.until(ExpectedConditions.elementToBeClickable(By.id("button02"))).click();
            wait.until(ExpectedConditions.elementToBeClickable(By.id("button03"))).click();


            String message = driver.findElement(By.id("buttonmessage")).getText();
            Assert.assertEquals(message, "All Buttons Clicked");

            driver.quit();
        }
    }

