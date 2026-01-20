package org.skillbrain.web.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;

public class ElementsPage {

    private WebDriver driver;
    private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());

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

    @FindBy(xpath = "//span[text()='Radio Button']")
    private WebElement clickOnRadioPage;


    public ElementsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
    }

    public void clickOnRadioPage() {
        LOGGER.debug("Click on Radio Buttons button on the /elements page...");
        clickOnRadioPage.click();
        LOGGER.debug("Click on Radio Buttons was successful.");
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
    public void checkSubmit() {
//        Name:Cristian (split) ->  ["Name", "Cristian"]
//                                                              [0]          [1]
//        /asfasfa&fallbackUrl=3235235235 -> split (&) -> ["asfasfa", "fallbackUrl=3235235235"]
        Assert.assertEquals(paragraphName.getText().split(":")[1], "Cristian");
        Assert.assertEquals(paragraphEmail.getText().split(":")[1], "test@test.com");
        Assert.assertEquals(paragraphAddress.getText().split(":")[1], "Home");
        Assert.assertEquals(paragraphPermanentAddress.getText().split(":")[1], "1");
    }

}
