package teme.beatrice;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import teme.patricia.Proba;

public class ElementsPageTODO {
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

    public ElementsPageTODO(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
    }

    public void clickTextBox() {
        textBox.click();
    }

    public void fillInUserName(String text) {
        userName.sendKeys(text);
    }


    public void fillInEmail(String email) {
        this.email.sendKeys(email);
    }

    public void fillInAddress(String newAddress) {
        address.sendKeys(newAddress);
    }

    public void fillInPermanentAddress(int newAddress) {
        permanentAddress.sendKeys(String.valueOf(newAddress));
    }

    public void clickSubmit() {
        Actions actions = new Actions(driver);
        actions.scrollToElement(submit).build().perform();
        submit.click();
    }


    public void checkSubmit(
            String expectedName,String expectedEmail, String expectedAddress, String expectedPermanentAddress) {

        Assert.assertEquals(paragraphName.getText().split(":")[1], expectedName);
        Assert.assertEquals(paragraphEmail.getText().split(":")[1], expectedEmail);
        Assert.assertEquals(paragraphAddress.getText().split(":")[1],expectedAddress );
        Assert.assertEquals(paragraphPermanentAddress.getText().split(":")[1],expectedPermanentAddress);

    }

    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        ElementsPageTODO elementsPageTODO = new ElementsPageTODO(driver);
        driver.get("https://demoqa.com/text-box");
        elementsPageTODO.fillInUserName("Cristian");
        elementsPageTODO.fillInEmail("test@test.com");
        elementsPageTODO.fillInAddress("Home");
        elementsPageTODO.fillInPermanentAddress(1);
        elementsPageTODO.clickSubmit();

        elementsPageTODO.checkSubmit("Cristian", "test@test.com", "Home", "1");

    }
}










