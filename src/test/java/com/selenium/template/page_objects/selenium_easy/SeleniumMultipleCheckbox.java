package com.selenium.template.page_objects.selenium_easy;

import com.selenium.template.page_objects.PageBase;
import com.selenium.template.utils.SeleniumWrapper;
import com.selenium.template.utils.Waiting;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class SeleniumMultipleCheckbox extends PageBase {
    public SeleniumMultipleCheckbox(WebDriver driver) {super(driver);}

    @FindBy (id = "check1")
    WebElement checkAllButton;

    @FindBy (xpath = "//*[@id=\"easycont\"]/div/div[2]/div[2]/div[2]/div[2]/label/input")
    WebElement optionTwoCheckbox;

    public void clickCheckAllButton(){
        SeleniumWrapper.clickElement(driver, checkAllButton, "Check All button");
    }
    public void clickOptionTwoCheckbox(){
        SeleniumWrapper.clickElement(driver, optionTwoCheckbox, "Option 2 Checkbox");
    }
    public String verifyCheckAllButtonIsTrue (){
       return checkAllButton.getAttribute("value");
    }


    public String verifyUncheckAllButtonIsTrue (){
        return checkAllButton.getAttribute("value");
    }
}
