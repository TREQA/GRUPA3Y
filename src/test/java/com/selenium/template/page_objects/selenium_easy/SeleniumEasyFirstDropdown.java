package com.selenium.template.page_objects.selenium_easy;

import com.selenium.template.page_objects.PageBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class SeleniumEasyFirstDropdown extends PageBase {
    public SeleniumEasyFirstDropdown(WebDriver driver){super(driver);}

    @FindBy (id = "select-demo")
    WebElement dropdownSelect;

    @FindBy (css = "#easycont > div > div.col-md-6.text-left > div:nth-child(4) > div.panel-body > p.selected-value")
    WebElement elementSelectedFromDropdown;


    public void selectDropdown(){
        Select dropdownClick = new Select(dropdownSelect);

        dropdownClick.selectByIndex(2);
    }
    public String checkDropdownElement(){
        return elementSelectedFromDropdown.getText();
    }
}
