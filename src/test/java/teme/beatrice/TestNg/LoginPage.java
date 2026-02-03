package teme.beatrice.TestNg;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    WebDriver driver;
    By usernameField = By.id("txt-username");
    By passwordField = By.id("txt-password");
    By loginBtn = By.id("btn-login");
    By errorMsg = By.cssSelector(".text-danger");

    public LoginPage(WebDriver driver){
        this.driver = driver;
    }
    public void login(String user, String pass){
        driver.findElement(usernameField).sendKeys(user);
        driver.findElement(passwordField).sendKeys(pass);
        driver.findElement(loginBtn).click();
    }
    public String getErrorMessage(){
        return driver.findElement(errorMsg).getText();
    }



}
