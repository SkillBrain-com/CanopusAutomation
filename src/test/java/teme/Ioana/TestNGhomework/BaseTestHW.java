package teme.Ioana.TestNGhomework;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;


public class BaseTestHW {

    private WebDriverWait wait;
    ChromeDriver driver = new ChromeDriver();


    @BeforeTest
    public void BeforeMethod(){
        driver=new ChromeDriver();
        driver.get("https://katalon-demo-cura.herokuapp.com/");
    }

    @AfterTest()
    public void cleanup() {
            driver.quit();
    }

}

