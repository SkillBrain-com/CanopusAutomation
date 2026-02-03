package teme.Ioana.TestNGhomework;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ConfirmationAppointment {
    WebDriver driver;

//    @FindBy(xpath = "//h2[text()='Appointment Confirmation']")
//    WebElement titleConfirmation;

    @FindBy(xpath ="//p[@id='facility']")
    WebElement Facility;

    @FindBy(id="hospital_readmission")
    WebElement hospitalReadmission;

    @FindBy(id="program")
    WebElement program;

    @FindBy(id="visit_date")
    WebElement visitDate;

    @FindBy(id="comment")
    WebElement comment;

    public ConfirmationAppointment(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

//    public boolean isConfirmationDisplayed(){
//        return titleConfirmation.isDisplayed();
//    }

    public String getFacility(){
        return Facility.getText();
    }

    public String getProgram(){
        return program.getText();
    }

}
