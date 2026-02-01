package teme.Ioana.Selenium_2;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.skillbrain.web.utils.ScreenshotUtil;
import java.time.Duration;

public class HtmlFormsTest {

    private static ChromeDriver driver = new ChromeDriver();
    private static ScreenshotUtil screenshotUtil = new ScreenshotUtil();
    private static WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(10));

    public static void main(String[] args) {

       fillFormDetails();
        // noElementFoundOnHtmlForms();
    }

    public static void fillFormDetails() {
        ScreenshotUtil screenshotUtil = new ScreenshotUtil();
        try {
            driver.manage().window().maximize();
            driver.get("https://testpages.herokuapp.com/pages/forms/html-form/");
            Actions actions = new Actions(driver);

            WebElement userName = driver.findElement(By.xpath("//input[@name='username']"));
            WebElement password = driver.findElement(By.xpath("//input[@name='password']"));
            WebElement textArea = driver.findElement(By.xpath("//textarea[@name='comments']"));
          //  WebElement fileUpload = driver.findElement(By.xpath("//input[@name='filename']"));
            WebElement checkBoxes = driver.findElement(By.xpath("(//input[@name='checkboxes[]'])[2]"));
            WebElement radioButtons = driver.findElement(By.xpath("//input[@type='radio'][3]"));
            Select select = new Select(driver.findElement(By.cssSelector("select[name='multipleselect[]'")));


          //  WebElement cancelButton = driver.findElement(By.cssSelector("input[type='reset']"));
            WebElement submitButton = driver.findElement(By.xpath("//input[@type='submit']"));

            userName.sendKeys("Test");
            password.sendKeys("Password");
            textArea.sendKeys("This is the text area. You can let a comment.");
            actions.scrollToElement(checkBoxes).build().perform();
             checkBoxes.click();
            actions.scrollToElement(radioButtons).build().perform();
            radioButtons.click();
            select.selectByIndex(2);
            actions.scrollToElement(submitButton).build().perform();
            submitButton.click();

            System.out.println("The html forms was successfully completed ");

        }
        catch (Exception e) {
            e.printStackTrace();
            screenshotUtil.screenshot(driver);
        } finally {
            driver.quit();
        }
    }
    public static void noElementFoundOnHtmlForms(){
        ScreenshotUtil screenshotUtil = new ScreenshotUtil();
        try{
            driver.manage().window().maximize();
            driver.get("https://testpages.herokuapp.com/pages/forms/html-form/");
            WebElement elementNotFound = driver.findElement(By.cssSelector("header[class='article-meta......']"));
            elementNotFound.click();
        }
        catch (NoSuchElementException e){
            e.printStackTrace();
            System.out.println("The element is not found in the page");
            screenshotUtil.screenshot(driver);
        }
        finally {
            driver.quit();
        }
    }
}