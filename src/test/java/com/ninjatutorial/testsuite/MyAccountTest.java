package com.ninjatutorial.testsuite;

import com.ninjatutorial.pages.*;
import com.ninjatutorial.testbase.TestBase;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class MyAccountTest extends TestBase {


    private static final Logger log = LoggerFactory.getLogger(MyAccountTest.class);
    //create object of various classes
    HomePage homePage = new HomePage();
    RegisterPage registerPage = new RegisterPage();
    LoginPage loginPage = new LoginPage();
    MyAccountPage myAccountPage = new MyAccountPage();
    CommonElementPage commonElementPage = new CommonElementPage();

    public void verifyText(String actualText, String expectedText, String message) {
        Assert.assertEquals(actualText, expectedText, message);
    }

    public void verifyText(List<String> actualText, List<String> expectedText, String message) {
        Assert.assertEquals(actualText, expectedText, message);
    }


    @Test
    public void verifyUserShouldNavigateToRegisterPageSuccessfully() {
        //1.1 Click on the My Account Link.
        commonElementPage.clickOnMyAccountLink();

        //1.2 Call the method “selectMyAccountOptions()” method and pass the parameter “Register”
        commonElementPage.selectMyAccountOption("Register");

        //1.3 Verify the text “Register Account”.
        String actualRegisterText = registerPage.getRegisterText();
        String expectedRegisterText = "Register Account";
        verifyText(actualRegisterText, expectedRegisterText, "Register Account text is not displayed");
    }

    @Test
    public void verifyUserShouldNavigateToLoginPageSuccessfully() {
        //2.1 Click on the My Account Link.
        commonElementPage.clickOnMyAccountLink();

        //2.2 Call the method “selectMyAccountOptions()” method and pass the parameter “Login”
        commonElementPage.selectMyAccountOption("Login");

        //2.3 Verify the text “Returning Customer”.
        String actualLoginText = loginPage.getLoginText();
        String exceptedLoginText = "Returning Customer";
        verifyText(actualLoginText, exceptedLoginText, "Returning Customer is not displayed");
    }

    @Test
    public void verifyThatUserRegisterAccountSuccessfully() {
        //3.1 Click on the My Account Link.
        commonElementPage.clickOnMyAccountLink();

        //3.2 Call the method “selectMyAccountOptions()” method and pass the parameter “Register”
        commonElementPage.selectMyAccountOption("Register");

        //3.3 Enter the First Name
        registerPage.enterFirstName("Rudraa");

        //3.4 Enter the Last Name
        registerPage.enterLastName("Patel");

        //3.5 Enter the Email
        registerPage.enterEmail("mannmeetji@yahoo.com");

        //3.6 Enter the Telephone
        registerPage.enterTelephone("1234567898");

        //3.7 Enter the Password
        registerPage.enterPassword("Rudraa123");

        //3.8 Enter the Password Confirm
        registerPage.enterConfirmPassword("Rudraa123");

        //3.9 Select Subscribe Yes radio button
        registerPage.clickOnTheYesRadioButton();

        //3.10 Click on the Privacy Policy check box
        registerPage.clickOnThePrivacyCheckbox();

        //3.11 Click on the Continue button
        registerPage.clickOnContinueButton();

        //3.12 Verify the message “Your Account Has Been Created!”
        String actualSuccessMessage = registerPage.getRegisterSuccessfulText();
        String expectedSuccessMessage = "Your Account Has Been Created!";
        verifyText(actualSuccessMessage, expectedSuccessMessage, "The message your account has been created is not displayed");

        //3.13 Click on the Continue button
        registerPage.clickOnContinueButtonAfterSuccessfulAccountCreated();

        //3.14 Click on the My Account Link.
        commonElementPage.clickOnMyAccountLink();

        //3.15 Call the method “selectMyAccountOptions()” method and pass the parameter “Logout”
        commonElementPage.selectMyAccountOption("Logout");

        //3.16 Verify the text “Account Logout”
        String actualLogoutText = commonElementPage.getLogoutText(); ////h1[normalize-space()='Account Logout']
        String expectedLogoutText = "Account Logout";
        verifyText(actualLogoutText, expectedLogoutText, "The logout message is not displayed");

        //3.17 Click on the Continue button
        commonElementPage.clickOnContinueButton();
    }

    @Test
    public void verifyThatUserShouldLoginAndLogoutSuccessfully() {
        //4.1 Click on the My Account Link.
        commonElementPage.clickOnMyAccountLink();

        //4.2 Call the method “selectMyAccountOptions()” method and pass the parameter “Login”
        commonElementPage.selectMyAccountOption("Login");

        //4.3 Enter the Email address
        loginPage.enterEmail("mannmeetji@yahoo.com");

        //4.4 Enter the Last Name
        // that doesnt exsist here

        //4.5 Enter the Password
        loginPage.enterPassword("Rudraa123");

        //4.6 Click on the Login button
        loginPage.clickOnLoginButton();

        //4.7 Verify text “My Account”
        String actualMyAccountText = myAccountPage.getMyAccountText();
        String expectedMyAccountText = "My Account";
        verifyText(actualMyAccountText, expectedMyAccountText, "My account text is not displayed");

        //4.8 Click on the My Account Link.
        commonElementPage.clickOnMyAccountLink();
        //4.9 Call the method “selectMyAccountOptions()” method and pass the parameter “Logout”
        commonElementPage.selectMyAccountOption("Logout");

        //4.10 Verify the text “Account Logout”
        commonElementPage.selectMyAccountOption("Logout");
        //4.11 Click on the Continue button
        commonElementPage.clickOnContinueButton();
    }
}
