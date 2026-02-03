package teme.patricia.TestNG;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AppointmentTests extends BaseTest {

    @Test
    public void happyScenario() {
        HomePage home = new HomePage(driver);
        home.clickMakeAppointment();

        LoginPage login = new LoginPage(driver);
        login.login("John Doe", "ThisIsNotAPassword");

        AppointmentPage ap = new AppointmentPage(driver);
        ap.selectFacility("Tokyo CURA Healthcare Center");
        ap.setVisitDate("30/12/2025");
        ap.setComment("Test pozitiv");
        ap.book();

        ConfirmationPage conf = new ConfirmationPage(driver);
        Assert.assertTrue(conf.isConfirmationPage());
    }

    @Test
    public void unhappyScenario() throws InterruptedException{
        HomePage home = new HomePage(driver);
        home.clickMakeAppointment();

        LoginPage login = new LoginPage(driver);
        login.login("John Doe", "ThisIsNotAPassword");

        AppointmentPage ap = new AppointmentPage(driver);
        ap.selectFacility("Tokyo CURA Healthcare Center");
        ap.setComment("");
        ap.book();
        Thread.sleep(1000);
        String validation = driver.findElement(By.id("txt_visit_date"))
                .getAttribute("validationMessage");

        Assert.assertTrue(validation.length() > 0);
    }
}