package teme.beatrice.Selenium3;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import teme.beatrice.TestNg.BaseTest;

import java.time.Duration;

public class RefreshTest extends BaseTest {

    @Test
    public void testTimesTampChangesOnRefresh(){
        driver.get("https://testpages.herokuapp.com/styled/refresh");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        By title = By.tagName("h1");

        String firstText = wait.until(ExpectedConditions.presenceOfElementLocated(title)).getText();
        long firstValue = Long.parseLong(firstText.replaceAll("\\D+", ""));

        long now1 = System.currentTimeMillis() / 1000;
        Assert.assertTrue(Math.abs(firstValue - now1) < 10, "First timestamp not close to now");
        driver.navigate().refresh();
        String secondText = driver.findElement(title).getText();
        long secondValue = Long.parseLong(secondText.replaceAll("\\D+", ""));
        Assert.assertNotEquals(secondValue, firstValue, "Timestamp did not change after refresh");
        long now2 = System.currentTimeMillis() / 1000;
        Assert.assertTrue(Math.abs(secondValue - now2) < 10, "Second timestamp not close to now");


    }
}
