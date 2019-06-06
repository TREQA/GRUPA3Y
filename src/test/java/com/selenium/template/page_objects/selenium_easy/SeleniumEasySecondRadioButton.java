package com.selenium.template.page_objects.selenium_easy;

import com.selenium.template.page_objects.PageBase;
import com.selenium.template.utils.SeleniumWrapper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SeleniumEasySecondRadioButton extends PageBase {
    public SeleniumEasySecondRadioButton(WebDriver driver){super(driver);}

    @FindBy (css = "#easycont > div > div.col-md-6.text-left > div:nth-child(5) > div.panel-body > div:nth-child(2) > label:nth-child(2) > input[type=radio]")
    WebElement secondMaleRadiobox;

    @FindBy (css = "#easycont > div > div.col-md-6.text-left > div:nth-child(5) > div.panel-body > div:nth-child(2) > label:nth-child(3) > input[type=radio]")
    WebElement secondFemaleRadiobox;

    @FindBy (css = "#easycont > div > div.col-md-6.text-left > div:nth-child(5) > div.panel-body > div:nth-child(3) > label:nth-child(2) > input[type=radio]")
    WebElement ageGroupFromZeroToFive;

    @FindBy (css = "#easycont > div > div.col-md-6.text-left > div:nth-child(5) > div.panel-body > div:nth-child(3) > label:nth-child(3) > input[type=radio]")
    WebElement ageGroupFromFiveToFifteen;

    @FindBy (css = "#easycont > div > div.col-md-6.text-left > div:nth-child(5) > div.panel-body > div:nth-child(3) > label:nth-child(4) > input[type=radio]")
    WebElement ageGroupFromFifteenToFifty;

    @FindBy (css = "#easycont > div > div.col-md-6.text-left > div:nth-child(5) > div.panel-body > button")
    WebElement getValues;

    @FindBy (xpath = "/html/body/div[2]/div/div[2]/div[2]/div[2]/p[2]")
    WebElement sexResult;

    @FindBy (xpath = "//*[@id=\"easycont\"]/div/div[2]/div[2]/div[2]/p[2]/text()[2]")
    WebElement ageGroupResult;

    public void clickSecondMaleRadiobox(){
        SeleniumWrapper.clickElement(driver, secondMaleRadiobox,"Second Male Radiobox");
    }
    public void clickSecondFemaleRadiobox(){
        SeleniumWrapper.clickElement(driver, secondFemaleRadiobox, "Second Female Radiobox");
    }
    public void clickAgeGroupFromZeroToFive(){
        SeleniumWrapper.clickElement(driver, ageGroupFromZeroToFive, "Age Group 0-5");
    }
    public void clickAgeGroupFromFiveToFifteen(){
        SeleniumWrapper.clickElement(driver, ageGroupFromFiveToFifteen, "Age Group 5-15");
    }
    public void clickAgeGroupFromFifteenToFifty(){
        SeleniumWrapper.clickElement(driver, ageGroupFromFifteenToFifty, "Age Group 15-50");
    }
    public void clickGetValues(){
        SeleniumWrapper.clickElement(driver, getValues, "Get Values Button");
    }
    public String getSexResult(){
        return SeleniumWrapper.getText(sexResult, "Sex Result");
    }
    public String getAgeGroupResult(){
        return SeleniumWrapper.getText(ageGroupResult, "Age Group Result");
    }
}
