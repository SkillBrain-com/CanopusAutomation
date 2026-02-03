package teme.Ioana.Selenium_3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Objects;

public class Ajax_XmlHttpResult {
    private WebDriver driver;
    private WebDriverWait wait;

    private By categoryResult= By.xpath("//select[@name='id']");
    private By languageResult = By.xpath("//select[@name='language_id']");
    private By codeItInButtonResult = By.cssSelector(".styled-click-button");

    public Ajax_XmlHttpResult(WebDriver driver, WebDriverWait wait){
        this.driver=driver;
        this.wait=wait;
    }
    public String getCategory(){
        return Objects.requireNonNull(wait.until(ExpectedConditions.visibilityOfElementLocated(categoryResult))).getText();
    }
    public String getLanguage(){
        return Objects.requireNonNull(wait.until(ExpectedConditions.visibilityOfElementLocated(languageResult))).getText();
    }

    public void submitButton(){
        driver.findElement(codeItInButtonResult).click();
    }
}
