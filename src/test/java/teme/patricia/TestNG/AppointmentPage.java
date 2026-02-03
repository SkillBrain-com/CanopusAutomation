package teme.patricia.TestNG;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

    public class AppointmentPage {

        private WebDriver driver;

        public AppointmentPage(WebDriver driver) {
            this.driver = driver;
        }

        private By facility = By.id("combo_facility");
        private By visitDate = By.id("txt_visit_date");
        private By comment = By.id("txt_comment");
        private By bookButton = By.id("btn-book-appointment");

        public void selectFacility(String value) {
            new Select(driver.findElement(facility)).selectByVisibleText(value);
        }

        public void setVisitDate(String date) {
            driver.findElement(visitDate).sendKeys(date);
        }

        public void setComment(String text) {
            driver.findElement(comment).sendKeys(text);
        }

        public void book() {
            driver.findElement(bookButton).click();
        }
    }

