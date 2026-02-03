package teme.beatrice.TestNg;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage {
    WebDriver driver;
     By makeAppointmentBtn = By.id("btn-make-appointment");
     By loginMenuBtn = By.linkText("Login");
     By homeMenuBtn = By.linkText("Home");

     public HomePage(WebDriver driver){
         this.driver = driver;
     }

     public void clickMakeAppointment(){
         driver.findElement(makeAppointmentBtn).click();
     }
     public void goToLogin(){
         WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
         WebElement loginBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(loginMenuBtn));
             loginBtn.click();


     }
     public void goHome(){
         driver.findElement(homeMenuBtn).click();
     }


}
