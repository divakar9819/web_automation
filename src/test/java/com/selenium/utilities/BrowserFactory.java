package com.selenium.utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.util.concurrent.TimeUnit;

/**
 * @author Divakar Verma
 * @created_at : 01/04/2024 - 1:27 pm
 * @mail_to: vermadivakar2022@gmail.com
 */
public class BrowserFactory {

    public static WebDriver startApplication(WebDriver driver, String driverName, String appUrl){
        switch (driverName){
            case "chrome":
                driver = new ChromeDriver();
                break;
            case "firefox":
                driver = new FirefoxDriver();
                break;
            case "ie":
                driver = new InternetExplorerDriver();
                break;
            case "safari":
                driver = new SafariDriver();
                break;
            default:
                System.out.println("We do not support this browser ");
                break;
        }
        driver.manage().window().maximize();
        driver.get(appUrl);
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
        return driver;
    }

    public static void tearDown(WebDriver driver){
        driver.quit();
    }
}
