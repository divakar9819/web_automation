package com.selenium.testcases;

import com.selenium.pageobject.BaseTest;
import com.selenium.pageobject.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;


/**
 * @author Divakar Verma
 * @created_at : 01/04/2024 - 12:01 pm
 * @mail_to: vermadivakar2022@gmail.com
 */
public class TestLogin extends BaseTest {

    private LoginPage loginPage;

    @Test
    public void loginPage() throws IOException {
       loginPage = new LoginPage(driver);
       loginPage.login("test","test");
       loginPage.verifyLoginStatus();
       captureScreenShot(driver,"login");
        Assert.assertTrue(true);
    }

}
