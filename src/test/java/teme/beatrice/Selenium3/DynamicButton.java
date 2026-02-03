package teme.beatrice.Selenium3;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import teme.beatrice.TestNg.BaseTest;

import java.time.Duration;

public class DynamicButton extends BaseTest {

    @Test
    public void testAllButton() {
        driver.get("https://testpages.eviltester.com/challenges/synchronization/dynamic-buttons-01/");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        JavascriptExecutor js = (JavascriptExecutor) driver;


        for (int i = 0; i < 4; i++) {

            By button = By.id("button0" + i);
            wait.until(ExpectedConditions.presenceOfElementLocated(button));
            wait.until(ExpectedConditions.visibilityOfElementLocated(button));
            wait.until(d -> d.findElement(button).isEnabled());
            clickSafely(wait, js, button);
        }
        wait.until(ExpectedConditions.textToBePresentInElementLocated(By.id("buttonmessage"), "All Buttons Clicked"));
        String text = driver.findElement(By.id("buttonmessage")).getText();
        Assert.assertEquals(text, "All Buttons Clicked");

    }

    private void clickSafely(WebDriverWait wait, JavascriptExecutor js, By locator) {

        wait.until((WebDriver d) -> {

            WebElement el = d.findElement(locator);

            js.executeScript("arguments[0].scrollIntoView({block:'center'});", el);

            try {
                el.click();
                return true;
            } catch (ElementClickInterceptedException e1) {
                try {
                    new Actions(d).moveToElement(el).click().perform();
                    return true;
                } catch (ElementClickInterceptedException e2) {
                    js.executeScript("arguments[0].click();", el);
                    return true;
                }
            }
        });
    }
}







