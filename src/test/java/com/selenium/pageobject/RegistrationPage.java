package com.selenium.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * @author Divakar Verma
 * @created_at : 02/04/2024 - 12:30 pm
 * @mail_to: vermadivakar2022@gmail.com
 */
public class RegistrationPage {

    private WebDriver driver;

    @FindBy(xpath =".//*[text()='REGISTER']")
    private WebElement registerElement;

    @FindBy(xpath = ".//*[@name='firstName']")
    private WebElement firstNameElement;

    @FindBy(xpath = ".//*[@name='lastName']")
    private WebElement lastNameElement;

    @FindBy(xpath = ".//*[@name='phone']")
    private WebElement phoneNumberElement;

    @FindBy(xpath = ".//*[@name='userName']")
    private WebElement emailElement;

    @FindBy(xpath = ".//*[@name='address1']")
    private WebElement addressElement;

    @FindBy(xpath = ".//*[@name='country']")
    private WebElement countryElement;

    public RegistrationPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public void clickRegistrationLink(){
        registerElement.click();
    }

    public void setFirstName(String strFirstName){
        firstNameElement.clear();
        firstNameElement.sendKeys(strFirstName);
    }

    public void setLastName(String strLastName){
        lastNameElement.clear();
        lastNameElement.sendKeys(strLastName);
    }

    public void setPhoneNumber(String strPhoneNumber){
        phoneNumberElement.clear();
        phoneNumberElement.sendKeys(strPhoneNumber);
    }

    public void setEmail(String strEmail){
        emailElement.clear();
        emailElement.sendKeys(strEmail);
    }

    public void setAddress(String strAddress){
        addressElement.clear();
        addressElement.sendKeys(strAddress);
    }

    public void setCountry(String strCountry){
        countryElement.click();

    }

    public void doRegistration(){
        clickRegistrationLink();
        setFirstName("Divakar");
        setLastName("Verma");
        setPhoneNumber("987654321");
        setEmail("test@gmail.com");
    }
}
