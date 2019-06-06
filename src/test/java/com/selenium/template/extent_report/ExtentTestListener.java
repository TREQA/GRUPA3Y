package com.selenium.template.extent_report;


import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.selenium.template.DriverBase;
import com.selenium.template.utils.Log4Test;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.IOException;


public class ExtentTestListener extends DriverBase implements ITestListener {

    //Extent Report Declarations
    private static ExtentReports extent = ExtentManager.createInstance();
    protected static ThreadLocal<ExtentTest> test = new ThreadLocal<>();

    public void takePicture() throws Exception{
        //String screenShot = CaptureScreenShot.captureScreen(getDriver(), CaptureScreenShot.generateFileName(result));
        //test.get().addScreenCaptureFromPath(screenShot);
    }

    public void testPass(String assertMessage) {
        Log4Test.test(assertMessage);
        test.get().pass(assertMessage);
    }

    public static void testInfo(String infoMessage){
        Log4Test.info(infoMessage);
        test.get().info(infoMessage);
    }

    public static void testError(String errorMessage){
        Log4Test.info(errorMessage);
        test.get().error(errorMessage);

    }


    @Override
    public synchronized void onStart(ITestContext context) {
        Log4Test.info("Extent Reports Test Suite started!");
    }

    @Override
    public synchronized void onFinish(ITestContext context) {
        Log4Test.info(("Extent Reports Test Suite is ending!"));
        extent.flush();
    }

    @Override
    public synchronized void onTestStart(ITestResult result) {
        ExtentTest extentTest = extent.createTest(result.getMethod().getMethodName(),result.getMethod().getDescription());
        test.set(extentTest);
        for (String group : result.getMethod().getGroups())
            test.get().assignCategory(group);

        testInfo((" ============================================ " + result.getMethod().getMethodName()));
        testInfo((" ============================================ " + result.getMethod().getDescription()));
    }

    @Override
    public synchronized void onTestSuccess(ITestResult result) {
        Log4Test.info((result.getMethod().getMethodName() + " passed!"));
        test.get().pass("Test passed");
    }

    @Override
    public synchronized void onTestFailure(ITestResult result) {
        Log4Test.info((result.getMethod().getMethodName() + " failed!"));
        RemoteWebDriver driver = null;

        try {
             driver = getDriver();
        } catch (Exception e) {
            Assert.fail("Malformed URL expcetion  : " + e.getMessage());
        }

        String screenShot = CaptureScreenShot.captureScreen(driver, CaptureScreenShot.generateFileName(result));


        try {
            test.get().fail(result.getThrowable());
            test.get().addScreenCaptureFromPath(screenShot) ;
           // test.get().fail("Screen Shot : " + test.get().addScreenCaptureFromPath(screenShot));

        } catch (IOException e){
            e.printStackTrace();
            Assert.fail();
        }

        extent.flush();
    }

    @Override
    public synchronized void onTestSkipped(ITestResult result) {
        Log4Test.info((result.getMethod().getMethodName() + " skipped!"));
        test.get().skip(result.getThrowable());
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        Log4Test.info(("onTestFailedButWithinSuccessPercentage for " + result.getMethod().getMethodName()));
    }
}