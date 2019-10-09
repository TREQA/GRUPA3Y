package com.selenium.template.tests;

import com.selenium.template.extent_report.ExtentTestListener;
import com.selenium.template.page_objects.SeleniumEasy.ProgressBarsSliders.BootstrapPage;
import com.selenium.template.utils.SeleniumWrapper;
import com.selenium.template.utils.TestData;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;


public class ProgressBar_BootstrapTest extends ExtentTestListener {


    @Test(groups = "Test", description = "Progress Bar > Bootstrap")
    public void Test_01_Progress_Bar_Bootstrap() throws Exception {

        WebDriver driver = getDriver();
        BootstrapPage BootstrapPage = new BootstrapPage(driver);

        SeleniumWrapper.openIfLinkExists(driver, TestData.SELENIUM_PROGRESSBAR_BOOTSTRAP);
        driver.manage().window().maximize();

        BootstrapPage.clickBootstrapDownloadButton();
        BootstrapPage.checkCompletionPercentage();
        boolean hundred = BootstrapPage.checkPercentText();
        System.out.println("Is the variable true?: "+hundred);
        Assert.assertTrue(hundred);
        testPass("Assert message was received: "+hundred); }}