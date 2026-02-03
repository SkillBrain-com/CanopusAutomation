package teme.patricia.Selenium1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

public class HerokuPage {
   private static ChromeDriver driver;


    public static void main(String[] args) {
        BasicWebPage();
        ElementsPage();
        AlertPage();
        LocatorPage();
        HtmlTable();
    }

    public static void BasicWebPage() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://testpages.herokuapp.com/pages/basics/basic-web-page/");

        WebElement paragraph = driver.findElement(By.cssSelector("p.main"));
        System.out.println(paragraph.getText());
        WebElement anotherParagraph = driver.findElement(By.cssSelector("p.sub"));
        System.out.println(anotherParagraph.getText());
        WebElement clickButton = driver.findElement(By.xpath("(//button[normalize-space()='Click Me'])[1]"));
        clickButton.click();

        driver.quit();
    }

    public static void ElementsPage() {
        driver = new ChromeDriver();
        Actions actions = new Actions(driver);
        driver.manage().window().maximize();
        driver.get("https://testpages.herokuapp.com/styled/attributes-test.html");

        WebElement staticParagraph = driver.findElement(By.xpath("(//p[@id='domattributes'])[1]"));
        System.out.println("Static paragraph text: " + staticParagraph.getText());

        WebElement dynamicParagraph = driver.findElement(By.xpath("(//p[@id='jsattributes'])[1]"));
        System.out.println("Dynamic paragraph text: " + dynamicParagraph.getText());

        WebElement buttonElement = driver.findElement(By.xpath("//button[@id='add-attribute-button']"));
        actions.scrollToElement(buttonElement).build().perform();
        buttonElement.click();
        System.out.println("The button was successfully clicked");

        driver.quit();
    }

    public static void AlertPage() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://testpages.herokuapp.com/styled/alerts/alert-test.html");

        WebElement showAlertButton = driver.findElement(By.id("alertexamples"));
        System.out.println("The 'Show alert box' button was clicked");
        showAlertButton.click();
        driver.switchTo().alert().accept();

        driver.quit();
    }

    public static void LocatorPage(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://testpages.herokuapp.com/pages/basics/locator-approaches/");
        WebElement idLocator = driver.findElement(By.id("find-by-id"));
        System.out.println(idLocator.getText());

        WebElement className = driver.findElement(By.xpath("//li[@class='find-by-class-name']"));
        System.out.println(className.getText());

        WebElement nameButton = driver.findElement(By.cssSelector("button[name='find-by-name']"));
        nameButton.click();
        System.out.println(nameButton.getText());
        WebElement partialLink = driver.findElement(By.xpath("//a[normalize-space()='partial link text link']"));
        partialLink.click();

        driver.quit();
    }

    public static void HtmlTable(){
        driver.manage().window().maximize();
        driver.get("https://testpages.herokuapp.com/pages/basics/locator-approaches/");

        List<WebElement> tableRows = driver.findElements(By.cssSelector("table#mytable tr"));
        WebElement firstRow = tableRows.get(0);
        List<WebElement> firstColumns = firstRow.findElements(By.cssSelector("th"));
        System.out.println("Header from first column " + firstColumns.get(0).getText());
        System.out.println("Header from second column " + firstColumns.get(1).getText());
        System.out.println(" ");

        WebElement secondRow = tableRows.get(1);
        List<WebElement> secondColumns = secondRow.findElements(By.cssSelector("td"));
        System.out.println("Header from first column " + secondColumns.get(0).getText());
        System.out.println("Header from second column " + secondColumns.get(1).getText());
        System.out.println(" ");
    }

        }





