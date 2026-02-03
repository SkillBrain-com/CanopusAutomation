package teme.patricia.TestNG;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

    public class LoginPage {

        private WebDriver driver;

        public LoginPage(WebDriver driver) {
            this.driver = driver;
        }

        private By username = By.id("txt-username");
        private By password = By.id("txt-password");
        private By loginButton = By.id("btn-login");
        private By errorMessage = By.xpath("//p[contains(text(),'Login failed')]");

        public void login(String user, String pass) {
            driver.findElement(username).sendKeys(user);
            driver.findElement(password).sendKeys(pass);
            driver.findElement(loginButton).click();
        }

        public boolean isErrorDisplayed() {
            return driver.findElement(errorMessage).isDisplayed();
        }
    }

