package teme.beatrice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.skillbrain.web.utils.ScreenshotUtil;
import org.w3c.dom.html.HTMLInputElement;

public class ActionDemoTODO {
    public static void main(String[] args) {
   simpleClickTest();
    }
    private static void simpleClickTest(){
        ChromeDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        ScreenshotUtil screenshotUtil = new ScreenshotUtil();
        try {
            driver.get("https://demoqa.com/buttons");
            WebElement simpleclickMeButton = driver.findElement(By.xpath("//button[normalize-space()='Click Me']"));
            simpleclickMeButton.click();
            String message = driver.findElement(By.id("dynamicClickMessage")).getText();
            System.out.println(message);
            screenshotUtil.screenshot(driver);
        } catch (Exception e){
            screenshotUtil.screenshot(driver);
            e.printStackTrace();

        }finally {
            driver.quit();
        }
    }
}
