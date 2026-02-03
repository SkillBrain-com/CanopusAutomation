package teme.patricia.TestNG;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

    public class HomePage {

        private WebDriver driver;

        public HomePage(WebDriver driver) {
            this.driver = driver;
        }

        private By menuButton = By.id("menu-toggle");
        private By loginLink = By.linkText("Login");
        private By homeLink = By.linkText("Home");
        private By makeAppointmentButton = By.id("btn-make-appointment");

        public void openMenu() {
            driver.findElement(menuButton).click();
        }

        public void clickLogin() {
            driver.findElement(loginLink).click();
        }

        public void clickHome() {
            driver.findElement(homeLink).click();
        }

        public void clickMakeAppointment() {
            driver.findElement(makeAppointmentButton).click();
        }
    }

