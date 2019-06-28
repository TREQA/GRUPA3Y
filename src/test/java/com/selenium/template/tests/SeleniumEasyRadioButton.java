package com.selenium.template.tests;

import com.selenium.template.extent_report.ExtentTestListener;
import com.selenium.template.page_objects.selenium_easy.RadioButtonFirstPage;
import com.selenium.template.page_objects.selenium_easy.RadioButtonSecond;
import com.selenium.template.utils.SeleniumWrapper;
import com.selenium.template.utils.TestData;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SeleniumEasyRadioButton extends ExtentTestListener {

    @Test(groups = "radio button", description = "Test made to test the radio buttons")
    public void Test_01_Test_Radio_Buttons() throws Exception{
        WebDriver driver = getDriver();
        RadioButtonFirstPage radioButtonFirstPage = new RadioButtonFirstPage(driver);

        SeleniumWrapper.openIfLinkExists(driver, TestData.SELENIUM_EASY_RADIOBOX_URL);
        driver.manage().window().maximize();

        radioButtonFirstPage.clickRadioboxMaleButton();
        radioButtonFirstPage.clickRadioboxFemaleButton();
        radioButtonFirstPage.clickGetCheckedValueButton();
        radioButtonFirstPage.verifyCheckedValueButtonResult();

        Assert.assertEquals(radioButtonFirstPage.verifyCheckedValueButtonResult(), "Radio button 'Female' is checked");
    }
    @Test(groups = "radio button", description = "Test made to test the radio buttons")
    public void Test_02_Test_Radio_Buttons() throws Exception {
        WebDriver driver = getDriver();
        RadioButtonSecond radioButtonSecond = new RadioButtonSecond(driver);

        SeleniumWrapper.openIfLinkExists(driver, TestData.SELENIUM_EASY_RADIOBOX_URL);
        driver.manage().window().maximize();

        radioButtonSecond.clickSecondMaleRadiobox();
        radioButtonSecond.clickSecondFemaleRadiobox();
        radioButtonSecond.clickAgeGroupFromZeroToFive();
        radioButtonSecond.clickAgeGroupFromFiveToFifteen();
        radioButtonSecond.clickAgeGroupFromFifteenToFifty();
        radioButtonSecond.clickGetValues();

        Assert.assertEquals(radioButtonSecond.getSexResult(), "Sex : Female\n" + "Age group: 15 - 50");
    }
}
