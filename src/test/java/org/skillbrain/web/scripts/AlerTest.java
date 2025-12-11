package org.skillbrain.web.scripts;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class AlerTest {

    public static void main(String[] args) {

//        TODO - create test scripts for the other buttons
        ChromeDriver driver = new ChromeDriver();

        try {
            driver.get("https://demoqa.com/alerts");
            driver.manage().window().maximize();
            driver.findElement(By.xpath("//button[@id='alertButton']")).click();
            Alert alert = driver.switchTo().alert();
            Thread.sleep(300);
            alert.accept();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            driver.quit();
        }
    }
}
