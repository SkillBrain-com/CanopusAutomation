package teme.Ioana.Selenium_3;

import lombok.Getter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

@Getter
public class Ajax_XmlHttpRequest extends Basetest {
  private WebDriver driver;
  private WebDriverWait wait;

  private By categoryDropdown= By.xpath("//select[@name='id']");
  private By languageDropdown = By.xpath("//select[@name='language_id']");
  private By codeItInButton = By.cssSelector(".styled-click-button");

  public Ajax_XmlHttpRequest(WebDriver driver, WebDriverWait wait){
      this.driver=driver;
      this.wait=wait;
  }
  public void selectCategory(String category){
     WebElement categoryElem= wait.until(ExpectedConditions.visibilityOfElementLocated(categoryDropdown));
      assert categoryElem != null;
      new Select(categoryElem).selectByVisibleText(category);
  }
    public void selectLanguage(String language){
        WebElement languageElem= wait.until(ExpectedConditions.visibilityOfElementLocated(languageDropdown));
        assert languageElem != null;
        new Select(languageElem).selectByVisibleText(language);
    }

    public void submit(){
      driver.findElement(codeItInButton).click();
    }


}
