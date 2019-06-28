package com.selenium.template.tests;

import com.selenium.template.extent_report.ExtentTestListener;
import com.selenium.template.page_objects.google_example.GoogleSearchPage;
import com.selenium.template.page_objects.selenium_easy.ProgressBarBootstrapPage;
import com.selenium.template.utils.SeleniumWrapper;
import com.selenium.template.utils.TestData;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ProgressBarBootstrapTest extends ExtentTestListener {

    @Test(groups = "Progress Bar", description = "Verify the ProgressBar for Bootstrap")
    public void Test_01_Verify_Progress_Bar_Bootstrap() throws Exception{
        WebDriver driver = getDriver();
        GoogleSearchPage googleSearchPage = new GoogleSearchPage(driver);

        SeleniumWrapper.openIfLinkExists(driver, TestData.SELENIUM_EASY_PROGRESS_BAR_BOOSTRAP_URL);
        driver.manage().window().maximize();

        ProgressBarBootstrapPage progressBarBootstrapPage = new ProgressBarBootstrapPage(driver);

        progressBarBootstrapPage.clickCircleButton();
//        progressBarBootstrapPage.getCirclePercentage();

        Assert.assertTrue(progressBarBootstrapPage.isFileDownloadComplete());
    }
}
