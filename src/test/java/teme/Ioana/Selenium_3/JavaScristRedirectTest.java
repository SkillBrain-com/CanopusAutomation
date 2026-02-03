package teme.Ioana.Selenium_3;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class JavaScristRedirectTest extends Basetest {
//@Test
    public void redirect5Sec(){
        driver.get("https://testpages.eviltester.com/pages/navigation/javascript-redirects/");
        JavaScriptRedirectsPage page = new JavaScriptRedirectsPage(driver, wait);
        page.clickRedirectIn5Sec();
        Assert.assertFalse(page.getTitleText().contains("Basic Web Page"), "5 seconds redirect failed!");
        System.out.println("The user was successfully redirected");
    }
    //@Test
    public void redirect2Sec(){
        driver.get("https://testpages.eviltester.com/pages/navigation/javascript-redirects/");
        JavaScriptRedirectsPage page = new JavaScriptRedirectsPage(driver, wait);
        page.clickRedirectIn2Sec();
        Assert.assertFalse(page.getTitleText().contains("Bounce"), "2 seconds redirect failed!");
        System.out.println("This is a test");
    }

    //@Test
    public void countDownTime(){
        driver.get("https://testpages.eviltester.com/pages/navigation/javascript-redirects/");
        JavaScriptRedirectsPage page = new JavaScriptRedirectsPage(driver, wait);
        page.clickCountdown();
        Assert.assertFalse(page.getTitleText().contains("Counting down"), "Countingdown was not displayed!");
        System.out.println("This is a new test");
    }

}
