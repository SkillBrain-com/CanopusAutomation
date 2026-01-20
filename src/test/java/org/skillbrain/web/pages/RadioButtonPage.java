package org.skillbrain.web.pages;

import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;

@Getter
public class RadioButtonPage {

    private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());

    private WebDriver driver;
    private WebDriverWait wait;

    public RadioButtonPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//label[@for='yesRadio']")
    private WebElement yesRadio;

    @FindBy(xpath = "//label[@for='impressiveRadio']")
    private WebElement impressiveRadioButton;

    @FindBy(id = "noRadio")
    private WebElement noRadio;

    @FindBy(css = "[for='noRadio']")
    private WebElement noRadioLabel;

    @FindBy(css = "[for='impressiveRadio']")
    private WebElement noRadioImpressive;

    @FindBy(css = ".mt-3")
    private WebElement mt3Element;


    public void clickOnRadio(String radioButton) {
        LOGGER.debug("Clicking on {} Button...", radioButton);
        switch (radioButton.toLowerCase()) {
            case "yes":
                wait.until(ExpectedConditions.elementToBeClickable(yesRadio));
                yesRadio.click();
                break;
            case "impressive":
                wait.until(ExpectedConditions.elementToBeClickable(impressiveRadioButton));
                impressiveRadioButton.click();
                break;
            default:
                throw new RuntimeException("The input provided by the user is invalid.");
        }
        LOGGER.debug("User selected a valid radio button and click was successful.");
    }


    public void clickYesRadio() {
        LOGGER.debug("Clicking on Yes Radio Button...");
        yesRadio.click();
        LOGGER.debug("Yes radio button was clicked successfully.");

    }


    public void clickImpressiveRadio() {
        LOGGER.debug("Clicking on Impressive Radio Button...");
        impressiveRadioButton.click();
        LOGGER.debug("Impressive radio button was clicked successfully.");
    }

}
