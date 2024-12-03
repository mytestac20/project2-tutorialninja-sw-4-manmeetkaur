package com.ninjatutorial.pages;

import com.ninjatutorial.utilities.Utility;
import org.openqa.selenium.By;

public class ShoppingCartPage extends Utility {

    By shoppingCartText = By.xpath("//h1[contains(text(),'Shopping Cart')]");
    By productName = By.xpath("//body[1]/div[2]/div[2]/div[1]/form[1]/div[1]/table[1]/tbody[1]/tr[1]/td[2]/a[1]");
    By deliveryDate = By.cssSelector("body > div:nth-child(4) > div:nth-child(2) > div:nth-child(1) > form:nth-child(2) > div:nth-child(1) > table:nth-child(1) > tbody:nth-child(2) > tr:nth-child(1) > td:nth-child(2) > small:nth-child(3)");
    By modelName = By.xpath("//td[normalize-space()='Product 21']");
    By productPrice = By.xpath("//tbody//tr//td[6]");
    By productQty = By.cssSelector("input[value='1']");
    By updateButton = By.xpath("//button[@type='submit']");
    By updateMessage = By.xpath("//div[@class='alert alert-success alert-dismissible']");
    By checkOutButton = By.xpath("//a[@class='btn btn-primary']");

    /**
     * This Method will get the shopping cart text
     */
    public String getShoppingCartText() {
        return getTextFromElement(shoppingCartText);
    }

    /**
     * This Method will get the product name from the cart
     */
    public String getProductName() {
        return getTextFromElement(productName);
    }

    /**
     * This method will get the product delivery date
     */
    public String[] getDeliveryDate() {
        return getTextFromElement(deliveryDate).split(":");
    }

    /**
     * This method will get the product model
     */
    public String getProductModel() {
        return getTextFromElement(modelName);
    }

    /**
     * This method will get the price
     */
    public String getPrice() {
        return getTextFromElement(productPrice);
    }

    /**
     * This method will update the qty
     */
    public void changeQtyOfProduct(String qty) {
        sendTextToElement(productQty, qty);
    }

    /**
     * click on the update cart button
     */
    public void clickOnUpdateButton() {
        clickOnElement(updateButton);
    }

    /**
     * This method will click on the checkout button
     */
    public void clickOnCheckOut() {
        clickOnElement(checkOutButton);
    }

    /**
     * This method will get the updated cart message
     */
    public String getUpdatedCartMessage() {
        return getTextFromElement(updateMessage).split("\n")[0];
    }

}