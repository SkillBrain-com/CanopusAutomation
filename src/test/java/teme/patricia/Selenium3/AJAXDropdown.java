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


public class AJAXDropdown {

    @Test
    public void ajaxDropdownTest() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        WebDriver driver = new ChromeDriver(options);

        driver.get("https://testpages.herokuapp.com/styled/basic-ajax-test.html");


        Select category = new Select(driver.findElement(By.id("combo1")));
        category.selectByVisibleText("Server");


        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.presenceOfElementLocated(
                        By.xpath("//select[@id='combo2']/option[text()='Java']")
                ));


        Select language = new Select(driver.findElement(By.id("combo2")));
        language.selectByVisibleText("Java");


        driver.findElement(By.name("submitbutton")).click();


        String simpleId = driver.findElement(By.id("_valueid")).getText();
        Assert.assertEquals(simpleId, "3");
        System.out.println(simpleId);

        String languageId = driver.findElement(By.id("_valuelanguage_id")).getText();
        Assert.assertEquals(languageId, "23");
        System.out.println(languageId);
        driver.quit();
    }
}