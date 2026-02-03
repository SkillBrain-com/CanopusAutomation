package teme.Ioana.Selenium_3;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RefreshPageID {
    WebDriver driver;
    @FindBy(tagName = "h1")
    WebElement title;
    public RefreshPageID( WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    public long getRefreshID(){
        String text= title.getText();
        String id = text.replaceAll("\\D+", "");
        return Long.parseLong(id);
    }

    public void refresh(){
        driver.navigate().refresh();
    }
}
