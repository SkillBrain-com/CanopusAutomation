package teme.beatrice.TestNg;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class AppointmentPage {
    WebDriver driver;

    By facilitySelect = By.id("combo_facility");
    By applyBtn = By.id("btn-book-appointment");
    By confirmation = By.id("summary");

    public AppointmentPage(WebDriver driver){
        this.driver = driver;
    }

    public void bookAppointment(){
        new Select(driver.findElement(facilitySelect)).selectByIndex(1);
        driver.findElement(applyBtn).click();
    }
    public boolean isAppointmentConfirmed(){
        return driver.findElement(confirmation).isDisplayed();
    }
}
