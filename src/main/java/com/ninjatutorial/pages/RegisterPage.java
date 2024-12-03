package com.ninjatutorial.pages;

import com.ninjatutorial.utilities.Utility;
import org.openqa.selenium.By;

public class RegisterPage  extends Utility {

    //find all Locator
    By registerText = By.xpath("//h1[normalize-space()='Register Account']");
    By firstName = By.xpath("//input[@id='input-firstname']");
    By lastName = By.xpath("//input[@id='input-lastname']");
    By email = By.xpath("//input[@id='input-email']");
    By telephone = By.xpath("//input[@id='input-telephone']");
    By password = By.xpath("//input[@id='input-password']");
    By cPassword = By.xpath("//input[@id='input-confirm']");
    By yesRadio = By.cssSelector("input[value='1'][name='newsletter']");
    By privacyCheckBox = By.xpath("//input[@name='agree']");
    By continueButton = By.xpath("//input[@value='Continue']");
    By registerSuccessMessageElement = By.xpath("//h1[normalize-space()='Your Account Has Been Created!']");
    By continueSuccess = By.linkText("Continue");


    /**
     * This method will get the Register text
     */
    public String getRegisterText() {
        return getTextFromElement(registerText);
    }

    /**
     * This method will get the Register successful text
     */
    public String getRegisterSuccessfulText() {
        return getTextFromElement(registerSuccessMessageElement);
    }


    /**
     * This method will enter firstname
     */
    public void enterFirstName(String fName) {
        sendTextToElement(firstName, fName);
    }

    /**
     * This method will enter firstname
     */
    public void enterLastName(String lName) {
        sendTextToElement(lastName, lName);
    }

    /**
     * This method will enter email
     */
    public void enterEmail(String emailAddress) {
        sendTextToElement(email, emailAddress);
    }

    /**
     * This method will enter telephone
     */
    public void enterTelephone(String phone) {
        sendTextToElement(telephone, phone);
    }

    /**
     * This method will enter password
     */
    public void enterPassword(String passwordText) {
        sendTextToElement(password, passwordText);
    }

    /**
     * This method will enter confirmPassword
     */
    public void enterConfirmPassword(String passwordText) {
        sendTextToElement(cPassword, passwordText);
    }

    /**
     * This method will click on the Yes radio button
     */
    public void clickOnTheYesRadioButton() {
        clickOnElement(yesRadio);
    }

    /**
     * This method will click on privacy checkbox
     */
    public void clickOnThePrivacyCheckbox() {
        clickOnElement(privacyCheckBox);
    }

    /**
     * This method will click on the continue button
     */
    public void clickOnContinueButton() {
        clickOnElement(continueButton);
    }

    /**
     * This method will click on the continue successful button
     */
    public void clickOnContinueButtonAfterSuccessfulAccountCreated() {
        clickOnElement(continueSuccess);
    }


}
