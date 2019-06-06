package com.selenium.template.page_objects.google_example;

import com.selenium.template.page_objects.PageBase;
import com.selenium.template.utils.SeleniumWrapper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by azaharia on 04.09.2018.
 */
public class GoogleSearchPage extends PageBase {

    public GoogleSearchPage(WebDriver driver){
        super(driver);
    }

    // ------------------------------------------------------- Locators

    @FindBy(id = "lst-ib")
    private WebElement googleSearchField;

    @FindBy(id = "btnK")
    private WebElement googleSearchButton;

    @FindBy(css = "#logo > img")
    private WebElement googleLogo;


    // ------------------------------------------------------- Methods

    // ---- setters

    public void setGoogleSearchField(String textToBeSearched){
        SeleniumWrapper.sendKeys(googleSearchField, textToBeSearched, "google search field");
    }
    public void clickGoogleSearchButton(){
        SeleniumWrapper.clickElement(driver, googleSearchButton, "google search button");
    }

    // ---- getters
    public Boolean isEnabledGoogleLogo(){
        return SeleniumWrapper.isEnabled(googleLogo, "google logo");
    }





}
