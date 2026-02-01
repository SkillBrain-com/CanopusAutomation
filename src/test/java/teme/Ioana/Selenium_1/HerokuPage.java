package teme.Ioana.Selenium_1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.skillbrain.web.utils.ScreenshotUtil;

import java.util.List;

public class HerokuPage {

    private static ChromeDriver driver = new ChromeDriver();
   private  static ScreenshotUtil screenshotUtil = new ScreenshotUtil();

    public static void main(String[] args) {
      herokuPage();
        //  BasicPage();
        //  ElementAttributes();
     //   LocatorPage();
      //  HtmlTable();
    }
    public static void BasicPage(){
        driver.manage().window().maximize();
        driver.get("https://testpages.herokuapp.com/pages/basics/basic-web-page/");

        WebElement paragraphBasicPage = driver.findElement(By.id("para1"));
        System.out.println(paragraphBasicPage.getText());

        WebElement BasicPageClickMeButton = driver.findElement(By.id("button1"));
        BasicPageClickMeButton.click();
        driver.quit();
    }

    public static void ElementAttributes(){
        Actions actions = new Actions(driver);
        driver.manage().window().maximize();
        driver.get("https://testpages.herokuapp.com/pages/basics/element-attribute-examples/");

        WebElement paragraphElementPage = driver.findElement(By.xpath("//p[@class='inline-explanation'][1]"));
        System.out.println(paragraphElementPage.getText());

        WebElement buttonElementPage = driver.findElement(By.cssSelector("[class='styled-click-button']"));
        actions.scrollToElement(buttonElementPage).build().perform();
        buttonElementPage.click();
        System.out.println("The button was successfully clicked");
        driver.quit();
    }

    public static void LocatorPage(){
        driver.manage().window().maximize();
        driver.get("https://testpages.herokuapp.com/pages/basics/locator-approaches/");
        WebElement idLocatorPage = driver.findElement(By.id("find-by-id"));
        System.out.println(idLocatorPage.getText());

        WebElement className = driver.findElement(By.cssSelector("li[class='find-by-class-name']"));
        System.out.println(className.getText());

        WebElement xpathSelector = driver.findElement(By.xpath("//span[@id='child-of-li']"));
        System.out.println(xpathSelector.getText());

        WebElement partialLink = driver.findElement(By.xpath("(//a[@href='#approaches'])[1]"));
        partialLink.click();

        driver.quit();

    }

    public static void HtmlTable (){
        driver.manage().window().maximize();
        driver.get("https://testpages.herokuapp.com/pages/basics/html-tag-table/");

        List<WebElement> tableRows = driver.findElements(By.cssSelector("table#mytable tr"));
        WebElement firstRow = tableRows.get(0);
        List<WebElement> firstRowColumns =firstRow.findElements(By.cssSelector("th"));
        System.out.println("Header din prima coloana " + firstRowColumns.get(0).getText());
        System.out.println("Header din a doua coloana " + firstRowColumns.get(1).getText());
        System.out.println(" ");

        WebElement secondRow = tableRows.get(1);
        List<WebElement> secondRowColumns =secondRow.findElements(By.cssSelector("td"));
        System.out.println("Header din prima coloana " + secondRowColumns.get(0).getText());
        System.out.println("Header din a doua coloana " + secondRowColumns.get(1).getText());
        System.out.println(" ");

        driver.quit();
    }

    public static void herokuPage(){

        try {
            driver.manage().window().maximize();
            driver.get("https://testpages.herokuapp.com/");
            WebElement titlePage = driver.findElement(By.xpath("//h1[text()='Software Testing Practice Pages']"));
            System.out.println("The title of the page: " + titlePage.getText());
            WebElement Pages = driver.findElement(By.xpath("(//a[@href='/pages/'])[2]"));
            Pages.click();
            System.out.println("Page HeroKuApp");

        } catch (Exception e) {
            e.printStackTrace();
            screenshotUtil.screenshot(driver);
        } finally {
            driver.quit();
        }
    }
    }

