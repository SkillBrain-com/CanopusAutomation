package teme.Ioana.Selenium_3;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.time.Duration;

public class Basetest {

    protected static WebDriver driver;
    protected static WebDriverWait wait;

    @BeforeTest
    public void setup(){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        driver = new ChromeDriver(options);
        wait= new WebDriverWait(driver, Duration.ofSeconds(6));

    }

  //  @Test
    public void ajaxtest(){
        driver.get("https://testpages.eviltester.com/pages/forms/ajax/");

        Ajax_XmlHttpRequest ajaxPage = new Ajax_XmlHttpRequest(driver,wait);
        ajaxPage.selectCategory("Desktop");
        ajaxPage.selectLanguage("Javascript");
        ajaxPage.submit();

        Ajax_XmlHttpResult ajaxResult = new Ajax_XmlHttpResult(driver,wait);
        Assert.assertTrue(ajaxResult.getCategory().contains("Desktop"));
        Assert.assertTrue(ajaxResult.getLanguage().contains("Javascript"));

        ajaxResult.submitButton();
        System.out.println("This is the page ajax Xml Http");
    }


    @AfterTest(alwaysRun = true)
    public void driverQuit(){
        if(driver!=null){
            driver.quit();
        }
    }


}
