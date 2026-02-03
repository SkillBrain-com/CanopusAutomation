package teme.patricia.TestNG;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

    public class BaseTest {

        protected WebDriver driver;

        @BeforeMethod
        public void setup() {
            driver = DriverManager.createDriver();
            driver.get("https://katalon-demo-cura.herokuapp.com/");
        }

        @AfterMethod
        public void closeBrowser() {
            if (driver != null) {
                driver.quit();
            }
        }
    }

