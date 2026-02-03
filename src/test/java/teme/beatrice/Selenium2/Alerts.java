package teme.beatrice.Selenium2;


import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.skillbrain.web.utils.ScreenshotUtil;

import java.time.Duration;

public class Alerts {
    public static void main(String[] args) {
     fakeAlertTest();
    }

    private static ChromeDriver driver = new ChromeDriver();



    public static void alertsSectionTest() {
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));

            driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.get("https://testpages.eviltester.com/pages/basics/alerts-javascript/");
            WebElement promptBox = wait.until(ExpectedConditions.elementToBeClickable(By.id("promptexample")));
            promptBox.click();
            System.out.println("Is alert open after click on button: " + isAlertOpen(driver));
            Alert alertprompt = driver.switchTo().alert();
            alertprompt.accept();
            System.out.println(driver.findElement(By.id("promptretval")).getText());
            System.out.println("Is alert open after it has been closed: " + isAlertOpen(driver));

                driver.quit();


        }
    public static boolean isAlertOpen(ChromeDriver driver){
        try {
            Alerts.driver.switchTo().alert();
            return true;
        }catch (NoAlertPresentException e){
            return false;
        }
    }

    private static void fakeAlertTest(){
        driver.manage().window().maximize();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get("https://testpages.eviltester.com/pages/basics/alerts-not-javascript/");
        WebElement fakeAlertButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("fakealert")));
        fakeAlertButton.click();
        WebElement clickOkButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("dialog-ok")));
        clickOkButton.click();
        driver.quit();
    }
    }








