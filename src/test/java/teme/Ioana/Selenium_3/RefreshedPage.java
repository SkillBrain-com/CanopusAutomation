package teme.Ioana.Selenium_3;

import org.testng.Assert;
import org.testng.annotations.Test;

public class RefreshedPage extends Basetest{
   // @Test
    public void refreshUpdateID(){
        driver.get("https://testpages.eviltester.com/pages/navigation/refresh/");
      RefreshPageID page = new RefreshPageID(driver);
      long firstID = page.getRefreshID();
      page.refresh();

      long secondID = page.getRefreshID();
        Assert.assertNotEquals(firstID,secondID);
        System.out.println("Id-ul este modificat dupa refresh");

    }
}
