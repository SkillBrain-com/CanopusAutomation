package teme.Ioana.Selenium_2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.skillbrain.web.utils.ScreenshotUtil;
import org.testng.Assert;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

public class DemoQaBrowser {

    private static ChromeDriver driver = new ChromeDriver();
    private static   ScreenshotUtil screenshotUtil = new ScreenshotUtil();
    private static ChromeOptions options = new ChromeOptions();

    public static void main(String[] args) {
       // browserWindowsDemoQA();
       // newWindow();
       // newWindowMessage();
    }

    private static void browserWindowsDemoQA() {

        try {
            options.addArguments("--start-maximized");
            driver.get("https://demoqa.com/browser-windows");
            Set<String> windowHandles = driver.getWindowHandles();
            System.out.println(windowHandles);
            WebElement tabButton = driver.findElement(By.id("tabButton"));
            tabButton.click();
            windowHandles = driver.getWindowHandles();
            System.out.println(windowHandles);

            Iterator<String> iterator = windowHandles.iterator();
            String parentWindow = iterator.next();
            String childWindow = iterator.next();
            driver.switchTo().window(childWindow);

            String newPageHeading = driver.findElement(By.id("sampleHeading")).getText();
            Assert.assertEquals(newPageHeading, "This is a sample page");
           System.out.println(driver.switchTo().window(parentWindow));

        } catch (Exception e) {
            e.printStackTrace();
            screenshotUtil.screenshot(driver);
        } finally {
            driver.quit();
        }
    }

    private static void newWindow() {
        try {
            driver.manage().window().maximize();
            driver.get("https://demoqa.com/browser-windows");
            Set<String> windowHandlesPage = driver.getWindowHandles();
            System.out.println(windowHandlesPage);
            WebElement newWindowsPage = driver.findElement(By.id("windowButton"));
            newWindowsPage.click();
            windowHandlesPage = driver.getWindowHandles();
            System.out.println(windowHandlesPage);
            Iterator<String> iterator = windowHandlesPage.iterator();
            String parentWindow = iterator.next();
            String newWindow = iterator.next();
            driver.switchTo().window(newWindow);

            WebElement newPageHeading = driver.findElement(By.id("sampleHeading"));
            System.out.println(newPageHeading.getText());
            driver.switchTo().window(parentWindow);

        } catch (Exception e) {
            e.printStackTrace();
            screenshotUtil.screenshot(driver);
        } finally {
            driver.quit();
        }
    }

//    private static void newWindowMessage(){
//        try{
//            options.addArguments("--start-maximized");
//            driver.get("https://demoqa.com/browser-windows");
//            Set<String> windowHandles = driver.getWindowHandles();
//            System.out.println(windowHandles);
//            WebElement newWindowMessage = driver.findElement(By.id("messageWindowButton"));
//            newWindowMessage.click();
//
//            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
//            wait.until(driver->driver.getWindowHandles().size() > windowHandles.size());
//            windowHandles = driver.getWindowHandles();
//            System.out.println(windowHandles);
//
//            Iterator<String> iterator = windowHandles.iterator();
//            String parentWindow = iterator.next();
//            String childWindow = iterator.next();
//            driver.switchTo().window(childWindow);
//           // System.out.println(driver.findElement(By.tagName("body")).getText());
//            String newpageMessage = driver.findElement(By.tagName("body")).getText();
//            Assert.assertTrue(newpageMessage.contains("Knowledge increases by sharing"));
//
//            driver.close();
//            //System.out.println(newpageMessage);
//            driver.switchTo().window(parentWindow);
//
//        }
//        catch (Exception e) {
//            e.printStackTrace();
//            screenshotUtil.screenshot(driver);
//        } finally {
//            driver.quit();
//        }
//
//    }
}
