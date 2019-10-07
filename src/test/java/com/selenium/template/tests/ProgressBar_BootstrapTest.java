package com.selenium.template.tests;

import com.selenium.template.extent_report.ExtentTestListener;
import com.selenium.template.page_objects.SeleniumEasy.InputForms_SimpleFormPage;
import com.selenium.template.page_objects.SeleniumEasy.ProgressBar_BootstrapPage;
import com.selenium.template.utils.SeleniumWrapper;
import com.selenium.template.utils.TestData;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;


public class ProgressBar_BootstrapTest extends ExtentTestListener {


    @Test(groups = "Test", description = "Progress Bar > Bootstrap")
    public void Test_01_Progress_Bar_Bootstrap() throws Exception {

        WebDriver driver = getDriver();
        ProgressBar_BootstrapPage progressBar_BootstrapPage = new ProgressBar_BootstrapPage(driver);

        SeleniumWrapper.openIfLinkExists(driver, TestData.SELENIUM_PROGRESSBAR_BOOTSTRAP);
        driver.manage().window().maximize();

        progressBar_BootstrapPage.clickBootstrapDownloadButton();
        progressBar_BootstrapPage.checkCompletionPercentage();

        Assert.assertTrue(progressBar_BootstrapPage.checkCompletionPercentage());
        testPass("Assert message was received: " + progressBar_BootstrapPage.checkCompletionPercentage());   }}