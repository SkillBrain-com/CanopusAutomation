package teme.Ioana.TestNGhomework;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    WebDriver driver;

    @FindBy(id = "txt-username")
    WebElement username;

    @FindBy(xpath = "//input[@type='password']")
    WebElement password;

    @FindBy(id = "btn-login")
    WebElement loginButton;

    @FindBy(css= ".text-danger")
    WebElement errorDisplayed;

    public LoginPage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    public void loginPage(String user, String pass){
        username.sendKeys(user);
        password.sendKeys(pass);
        loginButton.click();
        System.out.println("The user is successfully login");
    }

    public boolean isErrorPresent(){
        return errorDisplayed.isDisplayed();
    }
}
