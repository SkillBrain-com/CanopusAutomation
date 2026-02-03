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
import java.util.Set;

public class JavaScript extends BaseTest {


    public static void testRedirected(By buttonLocator){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        String initialUrl = driver.getWindowHandle();
        WebElement button = wait.until(ExpectedConditions.elementToBeClickable(buttonLocator));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block:'center'});", button);
        button.click();
        wait.until(ExpectedConditions.not(ExpectedConditions.urlToBe(initialUrl)));
        String currentUrl = driver.getCurrentUrl();
        Assert.assertNotEquals(currentUrl, initialUrl, "Redirected did not happen correctly");

    }

    @Test
    public void JavaScriptButton(){
        driver.get("https://testpages.herokuapp.com/styled/javascript-redirect-test.html");
        testRedirected(By.id("delaygotobasic"));
        testRedirected(By.id("delaygotobounce"));
    }


}
