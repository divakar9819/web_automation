package com.selenium.testcases;

import com.selenium.pageobject.BaseTest;
import com.selenium.pageobject.RegistrationPage;
import org.testng.annotations.Test;

/**
 * @author Divakar Verma
 * @created_at : 02/04/2024 - 12:45 pm
 * @mail_to: vermadivakar2022@gmail.com
 */
public class RegistrationTest extends BaseTest {

    private RegistrationPage registrationPage;

    @Test
    public void testRegistration(){
        registrationPage = new RegistrationPage(driver);
        registrationPage.doRegistration();
    }
}
