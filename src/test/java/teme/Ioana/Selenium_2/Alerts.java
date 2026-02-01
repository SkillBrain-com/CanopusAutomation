package teme.Ioana.Selenium_2;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.skillbrain.web.utils.ScreenshotUtil;

import java.time.Duration;

public class Alerts {
    private static ChromeDriver driver = new ChromeDriver();
   private static ScreenshotUtil screenshotUtil = new ScreenshotUtil();
   private static WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(10));
    public static void main(String[] args) {
        //firstAlert();
        // secondAlert();
        // lastAlert();
        // noElementFound();
       fakeAlertTest();
    }

    public static void firstAlert() {
       try {

           driver.manage().window().maximize();
           driver.get("https://testpages.herokuapp.com/pages/basics/alerts-javascript/");
           WebElement firstAlertButton = driver.findElement(By.id("alertexamples"));
           firstAlertButton.click();
           driver.switchTo().alert().accept();

           System.out.println("Is alert open after it been closed: " + isAlertOpen(driver));

       } catch (Exception e) {
           e.printStackTrace();
           screenshotUtil.screenshot(driver);
       } finally {
           driver.quit();
       }
    }

    public static void secondAlert() {
        try {
            driver.manage().window().maximize();
            driver.get("https://testpages.herokuapp.com/pages/basics/alerts-javascript/");
            WebElement secondAlertButton = driver.findElement(By.id("confirmexample"));
            for(int i=0; i<=1; i++){
                secondAlertButton.click();
                System.out.println("Is alert open after click on button:" + isAlertOpen(driver));
                Alert alert = driver.switchTo().alert();
                switch (i){
                    case 0: alert.accept();
                    break;
                    case 1: alert.dismiss();
                    break;
                    default:
                        System.out.println("Another type of alert");
                }
                System.out.println(driver.findElement(By.xpath("(//p[@class='inline-explanation'])[2]")).getText());
                System.out.println("Is alert open after click on button:" + isAlertOpen(driver));

            }
        }
        finally {
            driver.quit();
        }

    }

    public static void lastAlert(){
        try {

            driver.manage().window().maximize();
            driver.get("https://testpages.herokuapp.com/pages/basics/alerts-javascript/");
            WebElement lastAlertButton = driver.findElement(By.id("promptexample"));
            for(int i=0; i<=2; i++){
                System.out.println("----------------------");
                System.out.println("Iteration " + i);
                lastAlertButton.click();
                System.out.println("Is alert open after click on button:" + isAlertOpen(driver));
                Alert prompt = driver.switchTo().alert();
                switch (i){
                    case 0:prompt.accept();
                        System.out.println("Accept alert button");
                        break;
                    case 1:prompt.dismiss();
                        System.out.println("Dismiss alert button");
                        break;
                    case 2:prompt.sendKeys("You can add a message");
                    break;
                    default: System.out.println("Another type of alert");

                }
            }
            System.out.println("Is alert open after click on button:" + isAlertOpen(driver));
            System.out.println("--------------");
        }
        finally {
            driver.quit();
        }
    }

    public static boolean isAlertOpen(ChromeDriver driver){
        try {
            driver.switchTo().alert();
            return true;
        }
        catch (NoAlertPresentException e){
            return false;
        }
    }

    public static void noElementFound(){
        ScreenshotUtil screenshotUtil = new ScreenshotUtil();
        try{
            driver.manage().window().maximize();
            driver.get("https://testpages.herokuapp.com/pages/basics/alerts-javascript/");
            WebElement elementNotFound = driver.findElement(By.id("element_care_nu_poate_fi_localizat"));
            elementNotFound.click();
        }
        catch (NoSuchElementException e){
            System.out.println("This element is not found on the alerts page");
            screenshotUtil.screenshot(driver);
        }
        finally {
            driver.quit();
        }
    }

    public static void fakeAlertTest(){
        driver.manage().window().maximize();

        driver.get("https://testpages.herokuapp.com/pages/basics/alerts-not-javascript/");
        WebElement fakeAlertButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("fakealert")));
        fakeAlertButton.click();
        WebElement okButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("dialog-ok")));
        okButton.click();
        System.out.println("This is a fake alert");
        driver.quit();
    }



}
