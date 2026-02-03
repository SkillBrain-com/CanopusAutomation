package teme.Ioana.Selenium_3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Iterator;
import java.util.Objects;
import java.util.Set;

public class JavaScriptRedirectsPage {
    private WebDriver driver;
    private WebDriverWait wait;

    private By redirectIn5SecButton = By.xpath("//button[text()='Click to be transported in 5 seconds']");
    private By redirectIn2SecButton = By.xpath("(//button[@class='styled-click-button'])[2]");
    private By countdownButton = By.xpath(" (//button[@class='styled-click-button'])[2]");
    private By title = By.xpath("(//h1[text()='JavaScript Redirects'])");
    private By countdown = By.xpath("//p[@id='javascript_countdown_time']");


    public JavaScriptRedirectsPage(WebDriver driver, WebDriverWait wait){
        this.driver=driver;
        this.wait=wait;
    }

    private void switchNewPage(){
        Set<String> windowHandles = driver.getWindowHandles();
        System.out.println(windowHandles);
        windowHandles = driver.getWindowHandles();
        System.out.println(windowHandles);

       // wait.until(d ->driver.getWindowHandles().size()>1);
        for (String window : windowHandles) {
            driver.switchTo().window(window);
            break;
        }
//        String parentWindow = iterator.next();
//        String childWindow = iterator.next();
//        driver.switchTo().window(childWindow);
    }

    public void clickRedirectIn5Sec(){
        Objects.requireNonNull(wait.until(ExpectedConditions.elementToBeClickable(redirectIn5SecButton))).click();
        switchNewPage();
    }

    public void clickRedirectIn2Sec(){
        wait.until(ExpectedConditions.elementToBeClickable(redirectIn2SecButton)).click();
        switchNewPage();
    }
    public void clickCountdown(){
        wait.until(ExpectedConditions.elementToBeClickable(countdownButton)).click();
        switchNewPage();
    }
    public String getTitleText(){
       return wait.until(ExpectedConditions.visibilityOfElementLocated(title)).getText();
    }
    public String getCountdownText(){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(countdown)).getText();
    }
}
