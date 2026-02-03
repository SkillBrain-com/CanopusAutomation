package teme.beatrice.TestNg;

import org.openqa.selenium.By;
import org.testng.Assert;


public class loginTest extends BaseTest{

    public static void loginValidUser(){
        HomePage home = new HomePage(driver);
        home.goToLogin();

        LoginPage login = new LoginPage(driver);
        login.login("John Doe", "ThisIsNotAPassword");

        Assert.assertTrue(driver.getCurrentUrl().contains("#appointment"));
    }

    public static void invalidUser(){
        HomePage home = new HomePage(driver);
        home.goToLogin();

        LoginPage login = new LoginPage(driver);
        login.login("wrong", "wrong");
        Assert.assertTrue(login.getErrorMessage().contains("Login failed"));
    }

    public static void makeAppointmentRedirectsToLogin(){
        HomePage home = new HomePage(driver);
        home.clickMakeAppointment();
        Assert.assertTrue(driver.getCurrentUrl().contains("profile.php#login"));
    }
    public static void bookAppointmentSuccessfully(){
        HomePage home = new HomePage(driver);
        home.clickMakeAppointment();
        LoginPage login = new LoginPage(driver);
        login.login("John Doe", "ThisIsNotAPassword");
        AppointmentPage app = new AppointmentPage(driver);
        app.bookAppointment();
        Assert.assertTrue(app.isAppointmentConfirmed());
    }
    public static void bookingWithoutDataFails(){
        HomePage home = new HomePage(driver);
        home.clickMakeAppointment();
        LoginPage login = new LoginPage(driver);
        login.login("John Doe", "ThisIsNotAPassword");
        driver.findElement(By.id("btn-book-appointment")).click();
        Assert.assertFalse(driver.getCurrentUrl().contains("summary"));
    }
    public static void homeButtonAlwaysWork(){
        HomePage home = new HomePage(driver);
        home.goToLogin();
        home.goHome();
        Assert.assertEquals(driver.getCurrentUrl(), "https://katalon-demo-cura.herokuapp.com/");

    }
}



