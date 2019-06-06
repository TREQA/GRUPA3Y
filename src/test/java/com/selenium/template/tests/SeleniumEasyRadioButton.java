package com.selenium.template.tests;

import com.selenium.template.extent_report.ExtentTestListener;
import com.selenium.template.page_objects.selenium_easy.SeleniumEasyFirstRadioButton;
import com.selenium.template.page_objects.selenium_easy.SeleniumEasySecondRadioButton;
import com.selenium.template.utils.SeleniumWrapper;
import com.selenium.template.utils.TestData;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SeleniumEasyRadioButton extends ExtentTestListener {

    @Test(groups = "radio button", description = "Test made to test the radio buttons")
    public void Test_01_Test_Radio_Buttons() throws Exception{
        WebDriver driver = getDriver();
        SeleniumEasyFirstRadioButton seleniumEasyFirstRadioButton = new SeleniumEasyFirstRadioButton(driver);

        SeleniumWrapper.openIfLinkExists(driver, TestData.SELENIUM_EASY_RADIOBOX_URL);
        driver.manage().window().maximize();

        seleniumEasyFirstRadioButton.clickRadioboxMaleButton();
        seleniumEasyFirstRadioButton.clickRadioboxFemaleButton();
        seleniumEasyFirstRadioButton.clickGetCheckedValueButton();
        seleniumEasyFirstRadioButton.verifyCheckedValueButtonResult();

        Assert.assertEquals(seleniumEasyFirstRadioButton.verifyCheckedValueButtonResult(), "Radio button 'Female' is checked");
    }
    @Test(groups = "radio button", description = "Test made to test the radio buttons")
    public void Test_02_Test_Radio_Buttons() throws Exception {
        WebDriver driver = getDriver();
        SeleniumEasySecondRadioButton seleniumEasySecondRadioButton = new SeleniumEasySecondRadioButton(driver);

        SeleniumWrapper.openIfLinkExists(driver, TestData.SELENIUM_EASY_RADIOBOX_URL);
        driver.manage().window().maximize();

        seleniumEasySecondRadioButton.clickSecondMaleRadiobox();
        seleniumEasySecondRadioButton.clickSecondFemaleRadiobox();
        seleniumEasySecondRadioButton.clickAgeGroupFromZeroToFive();
        seleniumEasySecondRadioButton.clickAgeGroupFromFiveToFifteen();
        seleniumEasySecondRadioButton.clickAgeGroupFromFifteenToFifty();
        seleniumEasySecondRadioButton.clickGetValues();

        Assert.assertEquals(seleniumEasySecondRadioButton.getSexResult(), "Sex : Female\n" + "Age group: 15 - 50");
    }
}
