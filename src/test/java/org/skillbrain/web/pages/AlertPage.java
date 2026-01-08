package org.skillbrain.web.pages;

import lombok.Getter;
import lombok.Setter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

@Getter
public class AlertPage {

    public AlertPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "(//button[text()='Click me'])[1]")
    private WebElement clickMeButton1;

    @FindBy(xpath = "(//button[text()='Click me'])[2]")
    private WebElement clickMeButton2;

    @FindBy(xpath = "(//button[text()='Click me'])[3]")
    private WebElement clickMeButton3;

    @FindBy(xpath = "//span[@id='confirmResult']")
    private WebElement confirmResult;



}
