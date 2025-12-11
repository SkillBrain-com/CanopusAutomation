package org.skillbrain.web.scripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class RadioButtonTest {

// TODO - comment out method
    public static void main(String[] args) {




        ChromeDriver driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.get("https://demoqa.com/radio-button");

        WebElement noRadio = driver.findElement(By.id("noRadio"));
        WebElement noRadioLabel = driver.findElement(By.cssSelector("[for='noRadio']"));
        WebElement impressiveLabel = driver.findElement(By.cssSelector("[for='impressiveRadio']"));
        noRadioLabel.click();
        impressiveLabel.click();
        boolean isEnabled = noRadio.isEnabled();



        if (isEnabled) {
            System.out.println("Button is enabled");
        } else {
            System.out.println("Button is disabled");
        }

        WebElement element = driver.findElement(By.cssSelector(".mt-3"));
        System.out.println(element.getText());

        driver.close();

    }
}
