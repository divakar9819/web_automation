package com.selenium.pageobject;

import com.selenium.utilities.BrowserFactory;
import com.selenium.utilities.ConfigDataProvider;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import java.io.File;
import java.io.IOException;

/**
 * @author Divakar Verma
 * @created_at : 01/04/2024 - 1:14 pm
 * @mail_to: vermadivakar2022@gmail.com
 */
public class BaseTest {

    private static ConfigDataProvider configDataProvider;
    public static WebDriver driver;
    @BeforeSuite
    public void setUpSuite(){
        configDataProvider = new ConfigDataProvider();
    }


    @BeforeClass
    public void setUp(){
        driver = BrowserFactory.startApplication(driver,configDataProvider.getValueFromConfig("browser"),configDataProvider.getValueFromConfig("testUrl"));
    }

    @AfterClass
    public void tearDown(){
        BrowserFactory.tearDown(driver);
    }

    public void captureScreenShot(WebDriver driver,String testName) throws IOException
    {
        // Convert webdriver object to TakesScreenshot interface
        TakesScreenshot screenshot= ((TakesScreenshot)driver);

        // Step 2 :call getScreenshotAs method to capture image file

        File src= screenshot.getScreenshotAs(OutputType.FILE);
        File srcpath=new File("."+"//Screenshots//"+ testName + ".png");
        // Step 3 : copy image file to destination
        FileUtils.copyFile(src, srcpath);
    }
}
