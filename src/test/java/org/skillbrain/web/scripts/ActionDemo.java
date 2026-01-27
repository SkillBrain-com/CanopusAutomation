package org.skillbrain.web.scripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.skillbrain.web.utils.ScreenshotUtil;

public class ActionDemo {

    public static void main(String[] args) {

//        doubleClickTest();
//        rightClickTest();

    }

//    TODO - create test for simple click me

    private static void rightClickTest() {
        ChromeDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        ScreenshotUtil screenshotUtil = new ScreenshotUtil();
        try {
            driver.get("https://demoqa.com/buttons");
            WebElement rightClickMeButton = driver.findElement(By.id("rightClickBtn"));
            Actions actions = new Actions(driver);
            actions.contextClick(rightClickMeButton).build().perform();
            System.out.println(driver.findElement(By.id("rightClickMessage")).getText());
            screenshotUtil.screenshot(driver);

        } catch (Exception e) {
            screenshotUtil.screenshot(driver);
            e.getMessage();
        } finally {
            driver.close();
        }
    }


    private static void doubleClickTest() {
        ChromeDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        ScreenshotUtil screenshotUtil = new ScreenshotUtil();
        try {
            driver.get("https://demoqa.com/buttons");
            WebElement doubleClickMeButton = driver.findElement(By.id("doubleClickBtn"));
            Actions actions = new Actions(driver);
            actions.doubleClick(doubleClickMeButton).build().perform();
            System.out.println(driver.findElement(By.id("doubleClickMessage")).getText());
            screenshotUtil.screenshot(driver);

        } catch (Exception e) {
            e.getMessage();
        } finally {
            driver.close();
        }
    }


}
