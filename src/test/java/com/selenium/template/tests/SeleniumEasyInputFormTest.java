package com.selenium.template.tests;

import com.selenium.template.extent_report.ExtentTestListener;
import com.selenium.template.page_objects.selenium_easy.SeleniumEasyInputForm;
import com.selenium.template.utils.SeleniumWrapper;
import com.selenium.template.utils.TestData;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SeleniumEasyInputFormTest extends ExtentTestListener {
    @Test(groups = "input form", description = "A test that verifies the input form")
    public void Test_01_Verify_Input_Form() throws Exception{
        WebDriver driver = getDriver();
        SeleniumEasyInputForm seleniumEasyInputForm = new SeleniumEasyInputForm(driver);

        SeleniumWrapper.openIfLinkExists(driver, TestData.SELENIUM_EASY_INPUT_FORM_URL);
        driver.manage().window().maximize();

        seleniumEasyInputForm.setName("Andi", "Octavian");
        seleniumEasyInputForm.setContactDetails("andioctavian@mail.com", "123456789");
        seleniumEasyInputForm.setAddressDetails("Exact Address", "a city", "242424", 12);
        seleniumEasyInputForm.setWebsiteOrDomainName("Worthpoint.com");
        seleniumEasyInputForm.clickHostingYesButton();
        seleniumEasyInputForm.setProjectDescription("Find the price for your parent's old stuff");
        seleniumEasyInputForm.clickSendForm();
        seleniumEasyInputForm.projectDescriptionText();

        Assert.assertEquals(seleniumEasyInputForm.projectDescriptionText(), "");


    }
}
