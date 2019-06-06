package com.selenium.template.tests;

import com.selenium.template.extent_report.ExtentTestListener;
import com.selenium.template.page_objects.selenium_easy.SeleniumEasyTablePagination;
import com.selenium.template.utils.SeleniumWrapper;
import com.selenium.template.utils.TestData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SeleniumEasyTabelPaginationTest extends ExtentTestListener {
    @Test( groups = "tabel pagination", description = "test for the table pagination")
    public void Test_01_Verify_Tabel_Pagination() throws Exception{

        WebDriver driver = getDriver();
        SeleniumEasyTablePagination seleniumEasyTablePagination = new SeleniumEasyTablePagination(driver);

        SeleniumWrapper.openIfLinkExists(driver, TestData.SELENIUM_EASY_TABEL_PAGINATION_URL);
        driver.manage().window().maximize();

        seleniumEasyTablePagination.clickNextPage();
        seleniumEasyTablePagination.clickPrevPage();
        seleniumEasyTablePagination.selectPages("3");

//        Assert.assertEquals();
    }
}
