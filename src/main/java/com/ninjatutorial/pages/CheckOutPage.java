package com.ninjatutorial.pages;

import com.ninjatutorial.utilities.Utility;
import org.openqa.selenium.By;

public class CheckOutPage extends Utility {


    //find all locators
    By checkOutText = By.xpath("//h1[normalize-space()='Checkout']");
    By newCustomer = By.xpath("//h2[normalize-space()='New Customer']");
    By guestRadioButton = By.xpath("//input[@value='guest']");
    By continueButton = By.xpath("//input[@id='button-account']");
    By firstName = By.xpath("//input[@id='input-payment-firstname']");
    By lastName = By.xpath("//input[@id='input-payment-lastname']");
    By emailAddress = By.xpath("//input[@id='input-payment-email']");
    By telephoneNumber = By.xpath("//input[@id='input-payment-telephone']");
    By address = By.xpath("//input[@id='input-payment-address-1']");
    By city = By.xpath("//input[@id='input-payment-city']");
    By postCode = By.xpath("//input[@id='input-payment-postcode']");
    By country = By.xpath("//select[@id='input-payment-country']");
    By region = By.xpath("//select[@id='input-payment-zone']");
    By continueButtonGuest = By.xpath("//input[@id='button-guest']");
    By continueButtonDelivery = By.xpath("//input[@id='button-shipping-method']");
    By continueButtonPayment = By.xpath("//input[@id='button-payment-method']");
    By textBox = By.xpath("//div[@id='collapse-payment-method']//textarea[@name='comment']");
    By agree = By.xpath("//input[@name='agree']");
    By notAvailableMessage= By.xpath("//div[@class='alert alert-danger alert-dismissible']");

    /**
     * This method will get the text from check out page
     */
    public String getTextOfCheckOut() {
        return getTextFromElement(checkOutText);
    }

    /**
     * This method will get the new customer text
     */
    public String getNewCustomerText() {
        return getTextFromElement(newCustomer);
    }

    /**
     * This method will click onGuest radio button
     */
    public void clickOnGuestRadioButton() {
        clickOnElement(guestRadioButton);
    }

    /**
     * This method will click on continue button
     */
    public void clickOnContinue() {
        clickOnElement(continueButton);
    }

    /**
     * This method will enter name
     * */
    public void enterFirstName(String fName){
        sendTextToElement(firstName,fName);
    }

    /**
     * This method will enter last name
     * */
    public void enterLastName(String lName){
        sendTextToElement(lastName,lName);
    }

    /**
     * This method will enter email
     * */
    public void enterEmailAddress(String email){
        sendTextToElement(emailAddress,email);
    }

    /**
     * This method will enter telephone
     * */
    public void enterTelephone(String phone){
        sendTextToElement(telephoneNumber,phone);
    }

    /**
     * This method will enter address
     * */
    public void enterAddress(String add){
        sendTextToElement(address,add);
    }

    /**
     * This method will enter city
     * */
    public void enterCityName(String cty){
        sendTextToElement(city,cty);
    }

    /**
     * This method will enter Post code
     * */
    public void enterPostCode(String pCode){
        sendTextToElement(postCode,pCode);
    }

    /**
     * This method will select country
     * */
    public void selectCountry(String cnty){
        selectByVisibleTextFromDropDown(country,cnty);
    }
    /**
     * This method will select region
     * */
    public void selectRegion(String rgn){
        selectByVisibleTextFromDropDown(region,rgn);
    }

    /**
     *This method will click on continue button
     * */
    public void clickOnContinueButtonForGuest(){
        clickOnElement(continueButtonGuest);
    }

    public void clickOnContinueButtonForDelivery(){
        clickOnElement(continueButtonDelivery);
    }
    /**
     * This method will enter data in textfield
     * */
    public void enterCommentInTextBox(String message){
        sendTextToElement(textBox,message);
    }

    /**
     * This method will accept terms
     * */
    public void clickOnTerms(){
        clickOnElement(agree);
    }

    public void clickOnContinueButtonForPayment(){
        clickOnElement(continueButtonPayment);
    }


    /**
     * This method will get error message (if product is not available)
     * */
    public String getProductNotAvailableMessage(){
        return getTextFromElement(notAvailableMessage).split("\n")[0];
    }

}

