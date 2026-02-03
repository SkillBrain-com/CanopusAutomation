package teme.patricia.TestNG;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTests extends BaseTest {

    @Test
    public void loginValid() {
        HomePage home = new HomePage(driver);
        home.openMenu();
        home.clickLogin();

        LoginPage login = new LoginPage(driver);
        login.login("John Doe", "ThisIsNotAPassword");
        System.out.println("Valid login completed successfully!");
        Assert.assertTrue(driver.getCurrentUrl().contains("appointment"));

    }

    @Test
    public void loginInvalid() {
        HomePage home = new HomePage(driver);
        home.openMenu();
        home.clickLogin();

        LoginPage login = new LoginPage(driver);
        login.login("invalid", "wrong");
        System.out.println("Error displayed? " + login.isErrorDisplayed());
        Assert.assertTrue(login.isErrorDisplayed());

    }
}