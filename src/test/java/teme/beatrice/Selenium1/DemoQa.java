package teme.beatrice.Selenium1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DemoQa {
    private static ChromeDriver driver = new ChromeDriver();

    public static void main(String[] args) {
        TextBox();
    }



    public static void TextBox(){
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/text-box");
        WebElement currentAddress = driver.findElement(By.id("currentAddress-label"));
        System.out.println(currentAddress.getText());

        driver.quit();
    }

    public static void checkBox(){
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/checkbox");
        WebElement homeButton = driver.findElement(By.xpath("//span[@class='rct-title' and text()='Home']"));
        homeButton.click();

        driver.quit();
    }

    public static void radioButton(){
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/radio-button");
        WebElement yes = driver.findElement(By.cssSelector("label[for='yesRadio']"));
        yes.click();
        driver.quit();
    }

    public static void webTables(){
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/webtables");
        WebElement add = driver.findElement(By.id("addNewRecordButton"));
        add.click();
        driver.quit();
    }

    public static void buttons(){
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/buttons");
        WebElement doubleclickmebutton = driver.findElement(By.cssSelector("button.btn.btn-primary"));
        doubleclickmebutton.click();
        System.out.println(doubleclickmebutton.getText());
        driver.quit();
    }

    public static void links(){
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/links");
        WebElement homelink = driver.findElement(By.cssSelector("a#simpleLink"));
        homelink.click();
        System.out.println(homelink.getText());
        driver.quit();
    }



}
