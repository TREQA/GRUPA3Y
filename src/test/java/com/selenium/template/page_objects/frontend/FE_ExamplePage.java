package com.selenium.template.page_objects.frontend;

import com.selenium.template.page_objects.PageBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by azaharia on 24.01.2018.
 */
public class FE_ExamplePage extends PageBase{

    public FE_ExamplePage(WebDriver passedDriver) {
        super(passedDriver);
    }

    // ---------------------------------------------------------------------------- Locators

    @FindBy(name = "name")
    private WebElement nameLocator;

    @FindBy(id = "firstname")
    private WebElement idLocator;


    // ---------------------------------------------------------------------------- Metods

}
