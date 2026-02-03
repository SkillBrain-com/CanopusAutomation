package teme.patricia.Selenium1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public class DemoQa {

    public static void main(String[] args) {

        DemoQa();
    }
    public static void sleep(long ms){
        try {
            Thread.sleep(ms);
        }   catch(InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static void DemoQa() {
        ChromeDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/elements");

// text box
        driver.findElement(By.id("item-0")).click(); // tab Text Box

        WebElement userName = driver.findElement(By.id("userName"));
        userName.sendKeys("Patricia");
        WebElement userEmail = driver.findElement(By.cssSelector("#userEmail"));
        userEmail.sendKeys("patricia@example.com");
        WebElement currentAddress = driver.findElement(By.xpath("//textarea[@id='currentAddress']"));
        currentAddress.sendKeys("Strada Test 123");
        sleep(2000);

// check box
        driver.findElement(By.id("item-1")).click(); // tab Check Box
        driver.findElement(By.className("rct-checkbox")).click(); // click Home
        driver.findElement(By.xpath("//button[@title='Toggle']")).click(); // click Toggle
        sleep(2000);

// radio button
        driver.findElement(By.id("item-2")).click(); // tab Radio Button
        driver.findElement(By.cssSelector("label[for='yesRadio']")).click();
        sleep(2000);

// web tables
        driver.findElement(By.id("item-3")).click(); // tab Web Tables
        driver.findElement(By.id("addNewRecordButton")).click();

        driver.findElement(By.cssSelector("input[placeholder='First Name']")).sendKeys("Patricia");
        driver.findElement(By.cssSelector("input[placeholder='Last Name']")).sendKeys("Copilot");
        driver.findElement(By.xpath("//input[@id='userEmail']")).sendKeys("copilot@demo.com");
        driver.findElement(By.xpath("//input[@id='age']")).sendKeys("30");
        driver.findElement(By.xpath("//input[@id='salary']")).sendKeys("1500");
        driver.findElement(By.id("department")).sendKeys("Testing");
        sleep(2000);
        driver.findElement(By.id("submit")).click();


// links
        driver.findElement(By.id("item-5")).click(); // tab Links
        driver.findElement(By.linkText("Home")).click();
        driver.findElement(By.xpath("//a[@id='dynamicLink']")).click();
        sleep(1000);


        driver.quit();
    }

    }

