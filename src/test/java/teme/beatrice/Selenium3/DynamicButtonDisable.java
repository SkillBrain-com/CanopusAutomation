package teme.beatrice.Selenium3;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import teme.beatrice.TestNg.BaseTest;

import java.time.Duration;

public class DynamicButtonDisable extends BaseTest {
    @Test
    public void testAllButtonClicked(){
        driver.get("https://testpages.eviltester.com/challenges/synchronization/dynamic-buttons-02/");

        JavascriptExecutor js = (JavascriptExecutor) driver;

        for (int i = 0; i < 4; i++){
            By button = By.id("button0" + i);
            wait.until(ExpectedConditions.presenceOfElementLocated(button));
            wait.until(driver -> driver.findElement(button).isEnabled());
            WebElement btn = wait.until(ExpectedConditions.elementToBeClickable(button));
            js.executeScript("arguments[0].scrollIntoView(true);", btn);
            js.executeScript("arguments[0].click();", btn);
        }
        String message =  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("buttonmessage"))).getText();
        Assert.assertEquals(message, "All Buttons Clicked");
    }
}
