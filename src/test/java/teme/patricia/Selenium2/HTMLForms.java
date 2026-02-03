package teme.patricia.Selenium2;

import io.cucumber.java.en_old.Ac;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.skillbrain.web.utils.ScreenshotUtil;

import java.time.Duration;

public class HTMLForms {

    private static ChromeDriver driver = new ChromeDriver();
    private static ScreenshotUtil screenshotUtil = new ScreenshotUtil();
    private static WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    public static void main(String[] args) {
        fillFormDetails();
        noSuchElement();
    }

    public static void fillFormDetails(){
        ScreenshotUtil screenshotUtil = new ScreenshotUtil();
        try {
            driver.manage().window().maximize();
            driver.get("https://testpages.eviltester.com/pages/forms/html-form/");
            Actions actions = new Actions(driver);

            WebElement userName = driver.findElement(By.xpath("//input[@name='username']"));
            WebElement password = driver.findElement(By.xpath("//input[@name='password']"));
            WebElement textArea = driver.findElement(By.xpath("//textarea[@name='comments']"));
//            WebElement fileUpload = driver.findElement(By.xpath("//input[@name='filename']"));
            WebElement checkBoxes = driver.findElement(By.xpath("(//input[@name='checkboxes[]'])[1]"));
            WebElement radioButtons = driver.findElement(By.xpath("(//input[@type='radio'])[3]"));
            Select select = new Select(driver.findElement(By.cssSelector("select[name='multipleselect[]'")));

//            WebElement cancelButton = driver.findElement(By.cssSelector("input[value='cancel']"));
            WebElement submitButton = driver.findElement(By.cssSelector("input[value='submit']"));

            userName.sendKeys("Test");
            password.sendKeys("1a2b3c");
            textArea.sendKeys("Custom comment");
            actions.scrollToElement(checkBoxes).build().perform();
            checkBoxes.click();
            actions.scrollToElement(radioButtons).build().perform();
            radioButtons.click();
            select.selectByIndex(2);
            actions.scrollToElement(submitButton).build().perform();
            submitButton.click();

            System.out.println("The HTML form was successfully filled in");
        } catch (Exception e) {
            e.printStackTrace();
            screenshotUtil.screenshot(driver);
        }finally {
            driver.quit();
        }


    }

    public static void noSuchElement(){
        WebDriver driver =null;
        ScreenshotUtil screenshotUtil = new ScreenshotUtil();
        try{
            driver.manage().window().maximize();
            driver.get("https://testpages.eviltester.com/pages/forms/html-form/");
            WebElement noElement = driver.findElement(By.id("no-element"));
            noElement.click();

        }catch (NoSuchElementException e){
            e.printStackTrace();
            screenshotUtil.screenshot(driver);
        }finally {
            if (driver != null) {
                try {
                    driver.quit();
                } catch (Exception ignored) {}
            }
        }
    }

}
