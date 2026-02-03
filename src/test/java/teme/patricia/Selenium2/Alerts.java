package teme.patricia.Selenium2;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.skillbrain.web.utils.ScreenshotUtil;
import org.testng.Assert;
import java.time.Duration;

public class Alerts {

    private static ChromeDriver driver = new ChromeDriver();
    private static ScreenshotUtil screenshotUtil = new ScreenshotUtil();
    private static WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    public static void main(String[] args) {
//        firstAlert();
//        secondAlert();
        lastAlert();
        noElement();
    }


    public static void firstAlert(){

        try {
          driver.manage().window().maximize();
          driver.get("https://testpages.herokuapp.com/pages/basics/alerts-javascript/");
          WebElement firstAlertButton = driver.findElement(By.id("alertexamples"));
          firstAlertButton.click();
          Alert firstAlert = driver.switchTo().alert();
          System.out.println(firstAlert.getText());
          firstAlert.accept();

          System.out.println("Is alert opened after it has been closed: " + isAlertOpened(driver));


         } catch (Exception e) {
            screenshotUtil.screenshot(driver);
         }finally {
            driver.quit();
         }
    }

    public static boolean isAlertOpened( ChromeDriver driver) {
        try {
            driver.switchTo().alert();
            return true;
        } catch (NoAlertPresentException e) {
            return false;
        }
    }

    public static void secondAlert(){

        try {
          driver.manage().window().maximize();
          driver.get("https://testpages.eviltester.com/pages/basics/alerts-javascript/");

          WebElement confirmButton = driver.findElement(By.id("confirmexample"));
          confirmButton.click();
          System.out.println("The confirm button was successfully clicked");
          Alert alert = driver.switchTo().alert();
          Assert.assertEquals(alert.getText(), "I am a confirm alert");
          alert.accept();

          WebElement resultText = driver.findElement(By.id("confirmexplanation"));
          Assert.assertTrue(resultText.getText().contains("confirm returned true"));
          System.out.println(driver.findElement(By.xpath("(//p[@id='confirmexplanation'])[1]")).getText());

          } catch (NoAlertPresentException e) {
                Assert.fail("Confirm alert did not appear: " + e.getMessage());
          } finally {
                driver.quit();
          }
    }

        public static void lastAlert(){

        try {
            driver.manage().window().maximize();
            driver.get("https://testpages.eviltester.com/pages/basics/alerts-javascript/");

            WebElement lastAlertButton = driver.findElement(By.id("promptexample"));
            Actions actions = new Actions(driver);
            for (int i = 0; i<=2; i++){

            System.out.println("Is alert opened after it has been closed: " + isAlertOpened(driver));
            actions.moveToElement(lastAlertButton).click().build().perform();
            Alert promptAlert = driver.switchTo().alert();

             switch (i){
                      case 1: promptAlert.accept();
                              System.out.println("OK button was clicked");
                               break;
                      case 2: promptAlert.dismiss();
                               System.out.println("Cancel button was clicked");
                               break;
                      default:
                               System.out.println("Another type of alert");
                        }

                    }
                        System.out.println("Is alert opened after it has been closed: " + isAlertOpened(driver));

         } finally {
               driver.quit();
         }
}

        public static void noElement(){
            ScreenshotUtil screenshotUtil1 = new ScreenshotUtil();
        try{
             driver.manage().window().maximize();
             driver.get("https://testpages.eviltester.com/pages/basics/alerts-javascript/");

             WebElement noSuchElement = driver.findElement(By.id("no-element"));
             noSuchElement.click();


          }catch (NoSuchElementException e) {
                System.out.println("No such element found on alerts page");
                screenshotUtil1.screenshot(driver);

          }finally {
                driver.quit();
          }
    }
}







