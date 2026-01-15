package org.skillbrain.web.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DemoQaPage {

    private WebDriver driver;
    private static final String URL = "https://demoqa.com/";


    @FindBy(xpath = "//a[@href='https://demoqa.com']")
    private WebElement homePage;

    @FindBy(xpath = "//h5[text()='Elements'] //parent::div //parent::div //parent::div[@class='card mt-4 top-card']")
    private WebElement elements;

    @FindBy(xpath = "//h5[text()='Forms'] //parent::div //parent::div //parent::div[@class='card mt-4 top-card']")
    private WebElement forms;

    @FindBy(xpath = "//h5[text()='Widgets'] //parent::div //parent::div //parent::div[@class='card mt-4 top-card']")
    private WebElement widgets;

    public DemoQaPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
    }


    public void goToDemoQa() {
        driver.get(URL);
    }

    public void clickOnHomePage() {
        homePage.click();
    }

    public void clickOnElements() {
        elements.click();
    }

    public void navigate(String card) {
        switch (card.toLowerCase()) {
            case "elements":
                elements.click();
                break;
            case "forms":
                forms.click();
                break;
            case "widgets":
                widgets.click();
                break;
            default:
                throw new RuntimeException("WebElement selected is not present in list.");
        }

    }

}
