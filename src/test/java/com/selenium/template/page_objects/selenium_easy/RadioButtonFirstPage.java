package com.selenium.template.page_objects.selenium_easy;

import com.selenium.template.page_objects.PageBase;
import com.selenium.template.utils.SeleniumWrapper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RadioButtonFirstPage extends PageBase {
    public RadioButtonFirstPage(WebDriver driver){super(driver);}

    @FindBy (css = "#easycont > div > div.col-md-6.text-left > div:nth-child(4) > div.panel-body > label:nth-child(2)")
    WebElement radioboxMaleButton;

    @FindBy (css = "#easycont > div > div.col-md-6.text-left > div:nth-child(4) > div.panel-body > label:nth-child(3)")
    WebElement radioboxFemaleButton;

    @FindBy (id = "buttoncheck")
    WebElement getCheckedValueButton;

    @FindBy (css = "#easycont > div > div.col-md-6.text-left > div:nth-child(4) > div.panel-body > p.radiobutton")
    WebElement checkedValueButtonResult;

    public void clickRadioboxMaleButton(){
        SeleniumWrapper.clickElement(driver, radioboxMaleButton, "Radiobox Male Button");
    }
    public void clickRadioboxFemaleButton(){
        SeleniumWrapper.clickElement(driver, radioboxFemaleButton, "Radiobox Female Button");
    }
    public void clickGetCheckedValueButton(){
        SeleniumWrapper.clickElement(driver, getCheckedValueButton, "Get Checked Value Button");
    }
    public boolean verifyMaleIsSelected(){
        return radioboxMaleButton.isSelected();
    }
    public boolean verifiyFemaleIsSelected(){
        return radioboxFemaleButton.isSelected();
    }
    public String verifyCheckedValueButtonResult(){
        return checkedValueButtonResult.getText();
    }

}
