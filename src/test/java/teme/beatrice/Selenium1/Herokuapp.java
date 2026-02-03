package teme.beatrice.Selenium1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;


public class Herokuapp {
    private static ChromeDriver driver = new ChromeDriver();

    public static void main(String[] args) {
     locator();
    }




    public static void basicPage(){
       driver.manage().window().maximize();
       driver.get("https://testpages.eviltester.com/pages/basics/basic-web-page/");
       WebElement paragraf1 = driver.findElement(By.id("para1"));
       System.out.println(paragraf1.getText());

       WebElement clickButton = driver.findElement(By.id("button1"));
       clickButton.click();

       driver.quit();

   }


    public static void elementtest(){
       Actions actions = new Actions(driver);
       driver.manage().window().maximize();
       driver.get("https://testpages.eviltester.com/pages/basics/element-attribute-examples/");
       WebElement paragraph = driver.findElement(By.xpath("//p[@id='jsattributes'][1]"));
       System.out.println(paragraph.getText());

       WebElement addButton = driver.findElement(By.cssSelector("[id='add-attribute-button']"));
       actions.scrollToElement(addButton).build().perform();
       addButton.click();
       System.out.println("The button was clicked");

       driver.quit();
   }


   public static void locator(){
       driver.manage().window().maximize();
       driver.get("https://testpages.eviltester.com/pages/basics/locator-approaches/");
       WebElement id = driver.findElement(By.id("find-by-id"));
       System.out.println(id.getText());

       WebElement titled = driver.findElement(By.cssSelector("li[title='li with title']"));
       System.out.println(titled.getText());

       WebElement byXpath = driver.findElement(By.xpath("//span[@id='child-of-li']"));
       System.out.println(byXpath.getText());

       WebElement partialLink = driver.findElement(By.xpath("(//a[href='#approaches'])[1]"));
       partialLink.click();
       System.out.println("The link was clicked");

       driver.quit();


   }





}
