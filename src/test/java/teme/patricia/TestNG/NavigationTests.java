package teme.patricia.TestNG;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NavigationTests extends BaseTest {

    @Test
    public void homeButtonAlwaysReturnsHome() {
        HomePage home = new HomePage(driver);
        home.openMenu();
        home.clickHome();

        Assert.assertTrue(driver.getCurrentUrl().equals("https://katalon-demo-cura.herokuapp.com/"));
    }

    @Test
    public void makeAppointmentRedirectsToLoginIfNotLogged() {
        HomePage home = new HomePage(driver);
        home.clickMakeAppointment();

        Assert.assertTrue(driver.getCurrentUrl().contains("profile.php#login"));
    }
}