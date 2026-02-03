package teme.beatrice.Selenium3;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import teme.beatrice.TestNg.BaseTest;

public class BasicAjax extends BaseTest {
    @Test
    public void testBasicAjax() {
        driver.get("https://testpages.eviltester.com/styled/basic-ajax-test.html");
        Select category = new Select(driver.findElement(By.id("combo1")));
        category.selectByVisibleText("Desktop");

        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//select[@id='combo2']/option[normalize-space()='C++']")));

        Select language = new Select(driver.findElement(By.id("combo2")));
        language.selectByVisibleText("C++");


        WebElement submit = wait.until(ExpectedConditions.elementToBeClickable(By.name("submitbutton")));

        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block:'center'});", submit);
        wait.until(ExpectedConditions.elementToBeClickable(submit));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", submit);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("rendered-form-results")));

        String idValue = driver.findElement(By.cssSelector("#_id ul li")).getText().trim();
        String languageValue = driver.findElement(By.cssSelector("#_language_id ul li")).getText().trim();
        String submitValue = driver.findElement(By.cssSelector("#_submitbutton ul li")).getText().trim();

        Assert.assertEquals(idValue, "2");
        Assert.assertEquals(languageValue, "10");
        Assert.assertEquals(submitValue, "Code In It");
    }
}
