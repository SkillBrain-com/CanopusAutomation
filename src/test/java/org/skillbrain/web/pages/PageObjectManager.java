package org.skillbrain.web.pages;

import org.openqa.selenium.WebDriver;

public class PageObjectManager {

    private WebDriver driver;
    private DemoQaPage demoQaPage;
    private ElementsPage elementsPage;

    public PageObjectManager(WebDriver driver) {
        this.driver = driver;
    }

    public DemoQaPage getDemoQaPage() {
        demoQaPage = new DemoQaPage(driver);
        return demoQaPage;
    }

    public ElementsPage getElementsPage() {
        elementsPage = new ElementsPage(driver);
        return elementsPage;
    }

}
