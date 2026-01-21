package teme.patricia;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.skillbrain.web.utils.ScreenshotUtil;
import org.testng.Assert;

public class Proba {

    private WebDriver driver;

    @FindBy(xpath = "//span[normalize-space()='Text Box']")
    private WebElement textBox;

    @FindBy(xpath = "//span[normalize-space()='Check Box']")
    private WebElement checkBox;

    @FindBy(id = "userName")
    private WebElement userName;

    @FindBy(id = "userEmail")
    private WebElement email;

    @FindBy(id = "currentAddress")
    private WebElement address;

    @FindBy(id = "permanentAddress")
    private WebElement permanentAddress;

    @FindBy(id = "submit")
    private WebElement submit;

    @FindBy(xpath = "//p[@id='permanentAddress']")
    private WebElement paragraphPermanentAddress;

    @FindBy(xpath = "//p[@id='currentAddress']")
    private WebElement paragraphAddress;

    @FindBy(xpath = "//p[@id='email']")
    private WebElement paragraphEmail;

    @FindBy(xpath = "//p[@id='name']")
    private WebElement paragraphName;

    public Proba(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
    }

    public void clickTextBox() {
        textBox.click();
    }

    public void fillInUserName(String text) {
        userName.sendKeys(text);
    }

    //    cah, nu asa !!!!
    public void fillInEmail(String email) {
        this.email.sendKeys(email);
    }

    public void fillInAddress(String newAddress) {
        address.sendKeys(newAddress);
    }

    public void fillInPermanentAddress(int newAddress) {
        permanentAddress.sendKeys(String.valueOf(newAddress));
    }
    //TODO fix element click interception
    public void clickSubmit() {
        Actions actions = new Actions(driver);
        actions.scrollToElement(submit).build().perform();
        submit.click();
    }

    //    TODO - make the method use input
    public void checkSubmit(
    String expectedName,String expectedEmail, String expectedAddress, String expectedPermanentAddress) {

//        Name:Cristian (split) ->  ["Name", "Cristian"]
//                                                              [0]          [1]
//        /asfasfa&fallbackUrl=3235235235 -> split (&) -> ["asfasfa", "fallbackUrl=3235235235"]
        Assert.assertEquals(paragraphName.getText().split(":")[1], expectedName);
        Assert.assertEquals(paragraphEmail.getText().split(":")[1], expectedEmail);
        Assert.assertEquals(paragraphAddress.getText().split(":")[1],expectedAddress );
        Assert.assertEquals(paragraphPermanentAddress.getText().split(":")[1],expectedPermanentAddress);

    }

    public static void main(String[] args) {

            WebDriver driver = new ChromeDriver();
            driver.manage().window().maximize();
            Proba proba = new Proba(driver);
            driver.get("https://demoqa.com/text-box");
            proba.fillInUserName("Cristian");
            proba.fillInEmail("test@test.com");
            proba.fillInAddress("Home");
            proba.fillInPermanentAddress(1);
            proba.clickSubmit();

            proba.checkSubmit("Cristian", "test@test.com", "Home", "1");


        simpleClickTest();
    }

        // simple click test

        private static void simpleClickTest() {
            ChromeDriver driver = new ChromeDriver();
            driver.manage().window().maximize();
            ScreenshotUtil screenshotUtil = new ScreenshotUtil();
            try {
                driver.get("https://demoqa.com/buttons");
                WebElement simpleClickMeButton = driver.findElement(By.xpath("(//button[normalize-space()='Click Me'])[1]"));
                simpleClickMeButton.click();
                System.out.println(driver.findElement(By.id("dynamicClickMessage")).getText());
                screenshotUtil.screenshot(driver);

            } catch (Exception e) {
                screenshotUtil.screenshot(driver);
                e.getMessage();
            } finally {
                driver.close();
            }
        }
    }

