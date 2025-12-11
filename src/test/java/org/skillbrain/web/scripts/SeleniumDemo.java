package org.skillbrain.web.scripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.skillbrain.web.utils.ScreenshotUtil;

import java.util.List;

public class SeleniumDemo {


    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        ScreenshotUtil screenshotUtil = new ScreenshotUtil();

        driver.manage().window().maximize();
        // go to page

        try {
            driver.get("https://demoqa.com/");
            WebElement homePageImage = driver.findElement(By.cssSelector("[href='https://demoqa.com']"));
            homePageImage.click();
            WebElement elements = driver.findElement(By.cssSelector("[class='card mt-4 top-card']"));
            elements.click();
            List<WebElement> liList = driver.findElements(By.id("item-0"));
            System.out.println("WebElements found: " + liList.size());
//        WebElement firstElement =   liList.getFirst();
            WebElement firstElement = liList.get(0);
            firstElement.click();
            WebElement userName = driver.findElement(By.id("userName"));
            userName.sendKeys("Cristian");
            WebElement email = driver.findElement(By.cssSelector("[type='email']"));
            email.sendKeys("test@test.com");
            WebElement currentAddress = driver.findElement(By.id("currentAddress"));
            WebElement permanentAddress = driver.findElement(By.id("permanentAddress"));

            currentAddress.sendKeys("Strada Sperantei nr 13");
            permanentAddress.sendKeys("Strada Sperantei nr 13");

            WebElement submit = driver.findElement(By.id("submit"));
            Actions actions = new Actions(driver);
            actions.moveToElement(submit).click().build().perform();

//            WebElement name = driver.findElement(By.id("name"));
//            WebElement email1 = driver.findElement(By.id("email"));
//            WebElement currentAddress1 = driver.findElement(By.id("currentAddress"));
//            WebElement permanentAddress1 = driver.findElement(By.id("permanentAddress"));
//
//            System.out.println(name.getText());
//            System.out.println(email1.getText());
//            System.out.println(currentAddress1.getText());
//            System.out.println(permanentAddress1.getText());

            screenshotUtil.screenshot(driver);
            Thread.sleep(200);

        } catch (Exception e) {
            screenshotUtil.screenshot(driver);
            e.printStackTrace();
        } finally {
            driver.close();
        }


    }
}
