package com.selenium.template.page_objects.selenium_easy;

import com.selenium.template.page_objects.PageBase;
import com.selenium.template.utils.SeleniumWrapper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class SeleniumSingleCheckbox extends PageBase {
    public SeleniumSingleCheckbox(WebDriver driver) {super(driver);}

    @FindBy (id = "isAgeSelected")
    WebElement clickCheckbox;

    @FindBy (id = "txtAge")
    WebElement messageCheckboxClicked;


    public void setClickCheckbox(){
        SeleniumWrapper.clickElement(driver, clickCheckbox, "Checkbox Clicker");
    }

    public void setMessageCheckboxClicked(){
        Boolean isTrue = true;
        Boolean isCheckboxClicked = messageCheckboxClicked.isDisplayed();
        Assert.assertEquals(isCheckboxClicked, isTrue);
    }

}
