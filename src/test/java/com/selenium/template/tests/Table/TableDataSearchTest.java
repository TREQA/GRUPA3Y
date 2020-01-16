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

        SeleniumWrapper.openIfLinkExists(driver, TestData.SELENIUM_TABLE_TABLEDATASEARCH);
        driver.manage().window().maximize();

        String[] Table1 = {"3", "SEO tags", "Holden Charles", "failed qa"};
        boolean check1 = TableDataSearchPage.searchTableOne(Table1);
        boolean check2 = TableDataSearchPage.noResults("%$&^@()&()@");
        Assert.assertTrue(check1 && check2);
        testPass("Assert message was received: " + (check1 && check2));
    }

    @Test(groups = "Test", description = "TableDataSearch > Table 1")
    public void Test_02_Table_Table2() throws Exception {

        WebDriver driver = getDriver();
        TableDataSearchPage TableDataSearchPage = new TableDataSearchPage(driver);

        SeleniumWrapper.openIfLinkExists(driver, TestData.SELENIUM_TABLE_TABLEDATASEARCH);
        String[] Table2 = {"1", "larrypt", "Rajano", "Karano"};
        TableDataSearchPage.clickFilter();
        boolean check1 = TableDataSearchPage.filterTable(Table2);
       boolean check2 = true;
            Assert.assertTrue(check1 && check2);
    testPass("Assert message was received: " + (check1 && check2));}}