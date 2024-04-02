package com.selenium.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * @author Divakar Verma
 * @created_at : 22/03/2024 - 3:02 pm
 * @mail_to: vermadivakar2022@gmail.com
 */
public class LoginPage{
    WebDriver driver;
    @FindBy(name = "userName")
    WebElement username ;
    @FindBy(name = "password")
    WebElement password ;
    @FindBy(name = "submit")
    WebElement submitButton;

    @FindBy(xpath = "//h3[text()='Login Successfully']")
    private WebElement loginSuccessMessage;


    public LoginPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public void setUsername(String strUsername){
        username.sendKeys(strUsername);
    }

    public void setPassword(String strPassword){
        password.sendKeys(strPassword);
    }

    public void clickSubmitButton(){
        submitButton.click();
    }

    public void login(String username, String password){
        setUsername(username);
        setPassword(password);
        clickSubmitButton();
    }

    public void verifyLoginStatus(){
        String actualMessage = loginSuccessMessage.getText();
        String expectedMessage = "Login Successfully";
        //Assert.assertEquals(expectedMessage, actualMessage);
    }
}
