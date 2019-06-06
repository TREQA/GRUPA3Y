package com.selenium.template.extent_report;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.ITestResult;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CaptureScreenShot {
    private static final DateFormat dateFormat = new SimpleDateFormat("yyyy_MM_dd SSS");

    public static String captureScreen(WebDriver driver, String screenName){

        TakesScreenshot screen = (TakesScreenshot) driver;
        File src = screen.getScreenshotAs(OutputType.FILE);

        String dest = System.getProperty("user.dir")+"//Test-ScreenShots//"+screenName+".png";

        File target = new File(dest);
        try{
            FileUtils.copyFile(src, target);
        } catch (IOException e){
            e.printStackTrace();
            Assert.fail();
        }
        return dest;
    }


    public static String generateFileName(ITestResult result){
        Date date = new Date();
        String fileName = result.getName()+ "_" + dateFormat.format(date);
        return fileName;

    }

}