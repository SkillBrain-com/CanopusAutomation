package teme.Ioana.TODO;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.skillbrain.web.utils.ScreenshotUtil;

public class ClickMeButton_Homework {
// Create test for simple click me button
    public static void main(String[] args) {
        clickMeButton();

    }
    private static void clickMeButton() {
        ChromeDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        ScreenshotUtil screenshotUtil = new ScreenshotUtil();
        try {
            driver.get("https://demoqa.com/buttons");
            WebElement clickMeElement = driver.findElement(By.xpath("//button[text()='Click Me']"));
            Actions actions = new Actions(driver);
            actions.click(clickMeElement).build().perform();
            WebElement dynamicText = driver.findElement(By.xpath("//p[@id='dynamicClickMessage']"));
            System.out.println(dynamicText.getText());
            screenshotUtil.screenshot(driver);
        }
        catch (Exception e){
            e.getMessage();
        }
        finally {
            driver.quit();
        }

    }

    }


