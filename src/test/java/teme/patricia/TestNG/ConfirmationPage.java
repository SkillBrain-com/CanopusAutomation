package teme.patricia.TestNG;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ConfirmationPage {

    private WebDriver driver;

    public ConfirmationPage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isConfirmationPage() {
        return driver.findElement(By.xpath("//h2[text()='Appointment Confirmation']")).isDisplayed();
    }
}