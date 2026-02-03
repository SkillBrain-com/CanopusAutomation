package teme.Ioana.Selenium_3;

import org.testng.Assert;
import org.testng.annotations.Test;

public class DymanicButtonsTest extends Basetest{
  //  @Test
    public void clickAllbuttonstest(){
        driver.get("https://testpages.eviltester.com/challenges/synchronization/dynamic-buttons-01/");
        DynamicButtonsPage page =new DynamicButtonsPage(driver);
        page.clickButtons();

        String actualMessage = page.getMessage();
        Assert.assertEquals(actualMessage,"All Buttons Clicked");
        System.out.println("All buttons clicked, the test was successfully pass.");

    }

    @Test
    public void clickAllbuttonstest2(){
        driver.get("https://testpages.eviltester.com/challenges/synchronization/dynamic-buttons-02/");
        DynamicButtonsPage page =new DynamicButtonsPage(driver);
        page.clickButtons();

       // String actualMessage = page.getMessage();
        Assert.assertEquals("All Buttons Clicked", page.getMessage());
        System.out.println("All buttons clicked, the test2 was successfully pass.");

    }
}
