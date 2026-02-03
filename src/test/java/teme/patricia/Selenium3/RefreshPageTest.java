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
public class RefreshPageTest {


    @Test
    public void refreshIdTest() throws InterruptedException {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);

        driver.get("https://testpages.herokuapp.com/styled/refresh");

        String before = driver.findElement(By.tagName("h1"))
                .getText()
                .replaceAll("\\D+", "");

        driver.navigate().refresh();

        String after = driver.findElement(By.tagName("h1"))
                .getText()
                .replaceAll("\\D+", "");

        Assert.assertNotEquals(before, after);

        long now = System.currentTimeMillis() / 1000;
        long idValue = Long.parseLong(after);
        Assert.assertTrue(Math.abs(now - idValue) <= 2);
        driver.quit();
    }
}