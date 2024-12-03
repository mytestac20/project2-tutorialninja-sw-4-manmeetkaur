package com.ninjatutorial.pages;

import com.ninjatutorial.utilities.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ProductPage extends Utility {

    //Find all locators from the product page
    By productName = By.cssSelector("div[id='content'] h1");
    By deliveryDatePicker = By.xpath("//div[@class='input-group date']//button[@type='button']");
    By monthYear = By.cssSelector("div[class='datepicker-days'] th[class='picker-switch']");
    By clickNextButton = By.xpath("//div[@class='datepicker-days']//th[@class='next'][contains(text(),'›')]");
    By dateList = By.xpath("//tbody/tr/td[@class='day']");
    By productQty = By.xpath("//input[@id='input-quantity']");
    By addToCart = By.xpath("//button[@id='button-cart']");
    By shoppingCartMessage = By.xpath("//div[@class='alert alert-success alert-dismissible']");
    By shoppingCartLink =By.xpath("//a[normalize-space()='shopping cart']");

    /**
     * This method will get the product name
     * */
    public String getProductNameFromProductPage(){
        return getTextFromElement(productName);
    }

    /**
     * This method will select the date from the dropdown
     * */
    public void selectDateFromDatePicker(String month, String year, String date){
        //click on the element
        clickOnElement(deliveryDatePicker);

        while (true){
            String[] monthAndYear = getTextFromElement(monthYear).split(" ");
            String currentMonth = monthAndYear[0];
            String currentYear = monthAndYear[1];

            if(currentMonth.equals(month) && currentYear.equals(year)){
                break;
            }else{
                clickOnElement(clickNextButton);
            }
        }

        List<WebElement> listOfDate= findElements(dateList);
        for (WebElement d:listOfDate){
            if(d.getText().equals(date)){
                d.click();
                break;
            }
        }
    }

    /**
     * This method will change the qty of the product
     * */
    public void productQty(String qty){
        sendTextToElement(productQty,qty);
    }

    /**
     * This method will get the shopping cart message
     * */
    public String getShoppingCartMessage() throws InterruptedException {
        // Thread.sleep(3000);
        return getTextFromElement(shoppingCartMessage).split("\n")[0];
    }

    /**
     * This method will click on the shopping cart link
     * */
    public void clickOnTheShoppingCartLink(){
        //waitUntilVisibilityOfElementLocated(shoppingCartLink,4);
        clickOnElement(shoppingCartLink);
    }

    /**
     * This method will click on the add to cart button
     * */
    public void clickOnTheAddToCart(){
        clickOnElement(addToCart);
    }



}
