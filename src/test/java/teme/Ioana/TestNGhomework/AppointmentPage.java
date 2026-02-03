package teme.Ioana.TestNGhomework;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AppointmentPage {
    WebDriver driver;
    @FindBy(id = "combo_facility")
    WebElement facility;

    @FindBy(id = "chk_hospotal_readmission")
    WebElement readmission;

    @FindBy(id = "radio_program_medicare")
    WebElement medicare;

    @FindBy(id = "radio_program_medicaid")
    WebElement medicaid;

    @FindBy(id = "radio_program_none")
    WebElement noneProgram;

    @FindBy(id = "txt_visit_date")
    WebElement visitDate;

    @FindBy(id = "txt_comment")
    WebElement writeComment;

    @FindBy(id = "btn-book-appointment")
    WebElement bookAppointmnetButton;

    public AppointmentPage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    public void completeAppointment(String facilityName, boolean applyReadmission, String program, String date, String commitText){

         new Select(facility).selectByVisibleText(facilityName);

         if(applyReadmission){
             readmission.click();
         }
         switch (program.toLowerCase()){
             case "medicare":
                 medicare.click();
                 break;
             case "medicaid":
                 medicaid.click();
                 break;
             case "none":
                 noneProgram.click();
         }
         visitDate.sendKeys(date);
         writeComment.sendKeys(commitText);


    }
     public void submitForm(){
        bookAppointmnetButton.click();
     }

     public void waitAppointment(){
         WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
         wait.until(ExpectedConditions.visibilityOf(facility));
     }

     public boolean isOnAppointmentPage(){
        return driver.getCurrentUrl().contains("appointment");
     }
}
