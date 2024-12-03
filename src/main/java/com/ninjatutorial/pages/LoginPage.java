package com.ninjatutorial.pages;

import com.ninjatutorial.utilities.Utility;
import org.openqa.selenium.By;

public class LoginPage extends Utility {

    //Find all Locator
    By loginText = By.xpath("//h2[normalize-space()='Returning Customer']");
    By email = By.xpath("//input[@id='input-email']");
    By password = By.xpath("//input[@id='input-password']");
    By loginButton = By.xpath("//input[@value='Login']");


    /**
     * This method will get the Login text
     */
    public String getLoginText() {
        return getTextFromElement(loginText);
    }

    /**
     * This method will enter email Address
     */
    public void enterEmail(String emailAdd) {
        sendTextToElement(email,emailAdd);
    }

    /**
     * This method will enter password
     */
    public void enterPassword(String pass){
        sendTextToElement(password,pass);
    }

    /**
     * This method will click on login button
     */
    public void clickOnLoginButton(){
        clickOnElement(loginButton);
    }
}
