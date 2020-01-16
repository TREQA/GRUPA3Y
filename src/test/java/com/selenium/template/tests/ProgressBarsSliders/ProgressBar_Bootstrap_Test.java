package com.selenium.template.tests.ProgressBarsSliders;

import com.selenium.template.extent_report.ExtentTestListener;
import com.selenium.template.page_objects.SeleniumEasy.ProgressBarsANDSliders.ProgressBar_Bootstrap_Page;
import com.selenium.template.utils.SeleniumWrapper;
import com.selenium.template.utils.TestData;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;


public class ProgressBar_Bootstrap_Test extends ExtentTestListener {


    @Test(groups = "Test", description = "Progress Bar > Bootstrap")
    public void Test_01_Progress_Bar_Bootstrap() throws Exception {

        WebDriver driver = getDriver();
        ProgressBar_Bootstrap_Page ProgressBar_Bootstrap_Page = new ProgressBar_Bootstrap_Page(driver);

        SeleniumWrapper.openIfLinkExists(driver, TestData.SELENIUM_PROGRESSBAR_BOOTSTRAP);
        driver.manage().window().maximize();

        ProgressBar_Bootstrap_Page.clickBootstrapDownloadButton();
        ProgressBar_Bootstrap_Page.checkCompletionPercentage();
        boolean hundred = ProgressBar_Bootstrap_Page.checkPercentText();
        System.out.println("Is the variable true?: "+hundred);
        Assert.assertTrue(hundred);
        testPass("Assert message was received: "+hundred); }}