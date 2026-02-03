package teme.Ioana.TestNGhomework;


import org.testng.Assert;

public class LoginTest extends BaseTestHW{
   //@Test
    public void loginValidUser(){
      HomePage home = new HomePage(driver);
      home.Menu();
      home.clickLogin();
      LoginPage login = new LoginPage(driver);
      login.loginPage("John Doe","ThisIsNotAPassword" );
    //    Assert.assertTrue(driver.getCurrentUrl().contains("appointment"));

        System.out.println("The login test was successfully pass");
    }

 //   @Test
    public void loginInvalidUser(){
        HomePage home = new HomePage(driver);
        home.Menu();
        home.clickLogin();
        LoginPage login = new LoginPage(driver);
        login.loginPage("John","ThisIsNotAPassword" );
        Assert.assertTrue(login.isErrorPresent());

        System.out.println("The login test is failed");

        driver.quit();
    }

//   @Test
    public void appointmentHappyScenario() throws InterruptedException{
        HomePage homePage= new HomePage(driver);
        homePage.clickMakeAppointment();

        LoginPage login = new LoginPage(driver);
        login.loginPage("John Doe","ThisIsNotAPassword" );

        AppointmentPage appointment = new AppointmentPage(driver);
        appointment.waitAppointment();
        appointment.completeAppointment("Tokyo CURA Healthcare Center", true, "medicare",  "20/02/2026", "OK");
        appointment.submitForm();
        ConfirmationAppointment conf = new ConfirmationAppointment(driver);

        // De modificat !!!!!
     //  Assert.assertTrue(conf.isConfirmationDisplayed());
     //  Assert.assertEquals(conf.getFacility(), "Tokyo CURA Healthcare Center");
      // Assert.assertEquals(driver.findElement(By.id("combo_facility")).getText(), "Tokyo CURA Healthcare Center");

        System.out.println("This is a positive test");
    }

  //  @Test
    public void appointmentUnhappyScenario() throws InterruptedException{
        HomePage homePage= new HomePage(driver);
        homePage.clickMakeAppointment();

        LoginPage login = new LoginPage(driver);
        login.loginPage("John Doe","ThisIsNotAPassword" );

        AppointmentPage appointment = new AppointmentPage(driver);
        appointment.waitAppointment();
        appointment.completeAppointment("Tokyo CURA Healthcare Center", true, "",  "20/02/2026", "OK");
        appointment.submitForm();
        ConfirmationAppointment conf = new ConfirmationAppointment(driver);
        Assert.assertTrue(appointment.isOnAppointmentPage(), "Appointment should NOT be created without program");

        System.out.println("This is a negative test");
    }

//    public void homeButtonAlwaysRedirectHome(){
//        HomePage homePage= new HomePage(driver);
//        homePage.Menu();
//        homePage.clickHomePage();
//
//    }
}
