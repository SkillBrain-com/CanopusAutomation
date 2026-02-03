package teme.Ioana.Selenium_3;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class DynamicButtonsPage {

    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(id="button00")
    WebElement startButton;

    @FindBy(id="button01")
    WebElement buttonOne;

    @FindBy(id="button02")
    WebElement buttonTwo;

    @FindBy(id="button03")
    WebElement buttonThree;

    @FindBy(id="buttonmessage")
    WebElement message;

    public DynamicButtonsPage( WebDriver driver){
        this.driver=driver;
        wait=new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver,this);
    }

    public void clickButtons(){
        wait.until(ExpectedConditions.elementToBeClickable(startButton)).click();
        wait.until(ExpectedConditions.elementToBeClickable(buttonOne)).click();
        wait.until(ExpectedConditions.elementToBeClickable(buttonTwo)).click();
        wait.until(ExpectedConditions.elementToBeClickable(buttonThree)).click();
    }

    public String getMessage(){
        return wait.until(ExpectedConditions.visibilityOf(message)).getText();
    }


}
