package teme.Ioana.Selenium_1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.skillbrain.web.utils.ScreenshotUtil;

import java.time.Duration;

public class demoQAPage {
    private static ChromeDriver driver = new ChromeDriver();


    public static void main(String[] args) {
        QAPage();
    }
    public static void QAPage() {

            driver.manage().window().maximize();
            driver.get("https://demoqa.com/");
            WebElement homePage = driver.findElement(By.xpath("//a[@href='https://demoqa.com']"));
            homePage.click();
            WebElement elements = driver.findElement(By.xpath("//h5[text()='Elements'] //parent::div //parent::div //parent::div[@class='card mt-4 top-card']"));
            WebElement forms = driver.findElement(By.xpath("//h5[text()='Forms'] //parent::div //parent::div //parent::div[@class='card mt-4 top-card']"));
            WebElement widgets = driver.findElement(By.xpath("//h5[text()='Widgets'] //parent::div //parent::div //parent::div[@class='card mt-4 top-card']"));
            elements.click();

            WebElement clickRadioPage = driver.findElement(By.xpath("//span[text()='Radio Button']"));
            clickRadioPage.click();

            WebElement yesRadio = driver.findElement(By.xpath("//label[@for='yesRadio']"));
            yesRadio.click();
            System.out.println("The results of the 'Yes' button is: " + yesRadio.getText());
            WebElement impressiveRadioButton = driver.findElement(By.xpath("//label[@for='impressiveRadio']"));
            impressiveRadioButton.click();
            System.out.println("The results of the 'Impressive' button is: " + impressiveRadioButton.getText());
//            WebElement noRadio = driver.findElement(By.id("noRadio"));
//            noRadio.click();


        WebElement textBox = driver.findElement(By.xpath("//span[normalize-space()='Text Box']"));
            textBox.click();
        WebElement userName = driver.findElement(By.id("userName"));
        userName.click();
        WebElement email = driver.findElement(By.id("userEmail"));
        email.click();
        WebElement address = driver.findElement(By.id("currentAddress"));
        address.click();
        WebElement permanentAddress = driver.findElement(By.id("permanentAddress"));
        permanentAddress.click();
        WebElement submit = driver.findElement(By.id("submit"));
        submit.click();

        WebElement checkBox = driver.findElement(By.xpath("//span[normalize-space()='Check Box']"));
        checkBox.click();
        WebElement homeFolder = driver.findElement(By.cssSelector("[class='rct-title']"));
        homeFolder.click();
        System.out.println(homeFolder.getText());

        WebElement webTables = driver.findElement(By.xpath("(//span[@class='text'])[4]"));
        webTables.click();

        WebElement links = driver.findElement(By.xpath("(//span[@class='text'])[6]"));
        links.click();
        WebElement homeLinks = driver.findElement(By.xpath("(//a[@id='simpleLink'])"));
        homeLinks.click();


        System.out.println("Test on DemoQA page");
        driver.quit();
    }

}
