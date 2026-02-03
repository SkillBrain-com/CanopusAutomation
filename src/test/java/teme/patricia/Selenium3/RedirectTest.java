package teme.patricia.Selenium3;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.time.Duration;



public class RedirectTest {

    @Test
public void javascriptRedirectTest() {
    ChromeOptions options = new ChromeOptions();
    options.addArguments("--start-maximized");
    options.addArguments("--remote-allow-origins=*");
    WebDriver driver = new ChromeDriver(options);

    driver.get("https://testpages.herokuapp.com/styled/javascript-redirect-test.html");


    driver.findElement(By.id("delaygotobounce")).click();
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(driver1 -> driver1.getCurrentUrl().contains("redirected"));


    Assert.assertTrue(driver.getCurrentUrl().contains("redirected"));

    driver.quit();
}
}
