package teme.beatrice.Selenium2;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.skillbrain.web.utils.ScreenshotUtil;

public class ElementNoFound {

    public static void main(String[] args) {
        elementNotFoundBrowser();
    }
    private static ChromeDriver driver = new ChromeDriver();
    private static ScreenshotUtil screenshotUtil = new ScreenshotUtil();


    private static void elementNotFound(){
        ScreenshotUtil screenshotUtil = new ScreenshotUtil();
        try {
            driver.manage().window().maximize();
            driver.get("https://testpages.eviltester.com/pages/basics/alerts-javascript/");
            WebElement elementNotFound = driver.findElement(By.id("elementul_nu_poate_fi_gasit"));
            elementNotFound.click();
        }catch (NoSuchElementException e){
            System.out.println("This element is not found");
            screenshotUtil.screenshot(driver);
        }finally {
            driver.quit();
        }
    }


    private static void elementNotFound2(){
        ScreenshotUtil screenshotUtil = new ScreenshotUtil();
        try {
            driver.manage().window().maximize();
            driver.get("https://testpages.eviltester.com/pages/forms/html-form/");
            WebElement elementNotFound2 = driver.findElement(By.id("element_negasit"));
            elementNotFound2.click();
        }catch (NoSuchElementException e){
            System.out.println("The element is not found");
            screenshotUtil.screenshot(driver);
        }finally {
            driver.quit();
        }
    }

    private static void elementNotFoundBrowser(){
        ScreenshotUtil screenshotUtil = new ScreenshotUtil();
        try {
            driver.manage().window().maximize();
            driver.get("https://demoqa.com/browser-windows");
            WebElement elementNotFound3 = driver.findElement(By.id("element_nevazut"));
            elementNotFound3.click();
        }catch (NoSuchElementException e){
            System.out.println("The element is not found here");
            screenshotUtil.screenshot(driver);
        }driver.quit();
    }
}
