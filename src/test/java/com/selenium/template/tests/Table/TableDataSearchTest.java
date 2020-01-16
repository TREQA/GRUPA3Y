package com.selenium.template.tests.Table;
import com.selenium.template.extent_report.ExtentTestListener;
import com.selenium.template.page_objects.SeleniumEasy.Table.TableDataSearchPage;
import com.selenium.template.utils.SeleniumWrapper;
import com.selenium.template.utils.TestData;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;


public class TableDataSearchTest extends ExtentTestListener {


    @Test(groups = "Test", description = "TableDataSearch > Table 1")
    public void Test_01_Table_Table1() throws Exception {

        WebDriver driver = getDriver();
        TableDataSearchPage TableDataSearchPage = new TableDataSearchPage(driver);

        SeleniumWrapper.openIfLinkExists(driver, TestData.SELENIUM_INPUTFORMS_AJAXFORMSUBMIT);
        driver.manage().window().maximize();


//        boolean check1 = TableDataSearchPage.submitEmpty();
//
//        TableDataSearchPage.fillTitle("Hello everybody");
//        TableDataSearchPage.fillComment("This is a description of some sort");
//        TableDataSearchPage.clickSubmit();
//        boolean check2 = AjaxFormPage.successCheck("Successfully!");
//        Assert.assertTrue(check1 && check2);
//        testPass("Assert message was received: " + (check1 && check2));
    }
}