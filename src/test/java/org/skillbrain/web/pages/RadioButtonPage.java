package org.skillbrain.web.pages;

import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

@Getter
public class RadioButtonPage {

    public RadioButtonPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "noRadio")
    private WebElement noRadio;

    @FindBy(css = "[for='noRadio']")
    private WebElement noRadioLabel;

    @FindBy(css = "[for='impressiveRadio']")
    private WebElement noRadioImpressive;

    @FindBy(css = ".mt-3")
    private WebElement mt3Element;

}
