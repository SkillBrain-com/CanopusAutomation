package teme.Ioana.TestNGhomework;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {


    WebDriver driver;

    @FindBy(id= "btn-make-appointment")
    WebElement makeAppointmentButton;

    @FindBy(id = "menu-toggle")
    WebElement menuButton;

    @FindBy(linkText = "Login")
    WebElement loginBtn;

    @FindBy(linkText = "Home")
    WebElement homebutton;

    public HomePage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickMakeAppointment(){
        makeAppointmentButton.click();
    }

    public void Menu(){
        menuButton.click();
    }

    public void clickLogin(){
        loginBtn.click();
    }

    public void clickHomePage(){
        homebutton.click();
    }
}
