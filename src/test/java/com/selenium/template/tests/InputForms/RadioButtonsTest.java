package com.selenium.template.tests.InputForms;

import com.selenium.template.extent_report.ExtentTestListener;
import com.selenium.template.page_objects.SeleniumEasy.InputForms.RadioButtonsPage;
import com.selenium.template.utils.SeleniumWrapper;
import com.selenium.template.utils.TestData;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;


public class RadioButtonsTest extends ExtentTestListener {


    @Test(groups = "Test", description = "Input Forms > First Checkbox")
    public void Test_01_Input_Radio_Buttons_Demo() throws Exception {

        WebDriver driver = getDriver();
        RadioButtonsPage RadioButtonsPage = new RadioButtonsPage(driver);

        SeleniumWrapper.openIfLinkExists(driver, TestData.SELENIUM_INPUTFORMS_RADIOBUTTONS);
        driver.manage().window().maximize();
//----------------SPECIFY DESIRED OPTION ("Male" or "Female")
        String gender1 = "Female";
        RadioButtonsPage.checkFirstBox(string);
        RadioButtonsPage.clickGetCheckedValuesButton();
        boolean check1 = RadioButtonsPage.checkFirstMessage(string);
        Assert.assertTrue(check1);
        testPass("Assert message was received: " + check1);
    }

    @Test(groups = "Test", description = "Input Forms > First Checkbox")
    public void Test_02_Input_Forms_Radio_Buttons_Demo() throws Exception {

        WebDriver driver = getDriver();
        RadioButtonsPage RadioButtonsPage = new RadioButtonsPage(driver);

        SeleniumWrapper.openIfLinkExists(driver, TestData.SELENIUM_INPUTFORMS_RADIOBUTTONS);
        driver.manage().window().maximize();
//----------------SPECIFY DESIRED GENDER ("Male" or "Female")
        String gender2 = "Male";
        RadioButtonsPage.checkGenderBox(gender2);
//----------------SPECIFY DESIRED AGE GROUP ("0 - 5", "5 - 10" or "10 - 15")
        String age = "0 - 5";
        RadioButtonsPage.checkGenderBox(gender2);
        RadioButtonsPage.clickGetCheckedValuesButton();
        boolean check1 = RadioButtonsPage.checkFirstMessage(string);
        Assert.assertTrue(check1);
        testPass("Assert message was received: " + check1);
    }


}

