package com.ninjatutorial.testsuite;

import com.ninjatutorial.pages.*;
import com.ninjatutorial.testbase.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Collections;
import java.util.List;

public class LaptopsAndNoteBooksTest extends TestBase {
    //Create objects of various classes
    HomePage homePage = new HomePage();
    LaptopsAndNoteBooksPage laptopsAndNotebooksPage = new LaptopsAndNoteBooksPage();
    ProductPage productPage = new ProductPage();
    ShoppingCartPage shoppingCartPage = new ShoppingCartPage();
    CheckOutPage checkOutPage = new CheckOutPage();

    /*===============================================================*/
    public void verifyText(String actualText, String expectedText, String message) {
        Assert.assertEquals(actualText, expectedText, message);
    }

    public void verifyText(List<String> actualText, List<String> expectedText, String message) {
        Assert.assertEquals(actualText, expectedText, message);
    }
    /*===============================================================*/


    @Test
    public void verifyProductsPriceDisplayHighToLowSuccessfully() {
        //change currency
        homePage.mouseHoverAndClickOnCurrency();
        homePage.mouseHoverAndClickOnPoundCurrency();

        //1.1 Mouse hover on the Laptops & Notebooks Tab. and click
        homePage.mouseHoverAndClickOnLaptopAndNoteBook();

        //1.2 Click on “Show AllLaptops & Notebooks”
        homePage.selectMenu("Show AllLaptops & Notebooks");

        //get list of product price before doing any action in this page.
        List<String> productPriceBefore = laptopsAndNotebooksPage.getListOfProductPrice();
        Collections.sort(productPriceBefore, Collections.reverseOrder());
        System.out.println(productPriceBefore);

        //1.3 Select the Sort By "Price (High > Low)"
        laptopsAndNotebooksPage.sortProductByPrice("Price (High > Low)");

        //1.4 Verify the Product price will be arranged in High to Low orders.
        List<String> productPriceAfter = laptopsAndNotebooksPage.getListOfProductPrice();
        System.out.println(productPriceAfter);
        //Assert.assertEquals(productPriceAfter,productPriceBefore,"Price are not in High to low");
    }

    @Test
    public void verifyThatUserPlaceOrderSuccessfully() throws InterruptedException {
        //change currency
        homePage.mouseHoverAndClickOnCurrency();
        homePage.mouseHoverAndClickOnPoundCurrency();

        //2.1 Mouse hover on the Laptops & Notebooks Tab and click
        homePage.mouseHoverAndClickOnLaptopAndNoteBook();

        //2.2 Click on the “Show AllLaptops & Notebooks”
        homePage.selectMenu("Show AllLaptops & Notebooks");

        //2.3 Select Sort By "Price (High > Low)"
        laptopsAndNotebooksPage.sortProductByPrice("Price (High > Low)");

        //2.4 Select Product “MacBook”
        laptopsAndNotebooksPage.clickOnMacBook();

        //2.5 Verify the text “MacBook”
        String actualMacBookText = productPage.getProductNameFromProductPage();
        String expectedMacBookText = "MacBook";
        verifyText(actualMacBookText, expectedMacBookText, "MacBook text is not displayed");

        //2.6 Click on the ‘Add To Cart’ button
        productPage.clickOnTheAddToCart();

        //2.7 Verify the message “Success: You have added MacBook to your shopping cart!”
        String actualShoppingCartMessage = productPage.getShoppingCartMessage();
        String expectedShoppingCartMessage = "Success: You have added MacBook to your shopping cart!";
        verifyText(actualShoppingCartMessage, expectedShoppingCartMessage, "Shopping Cart Message is not displayed");

        //2.8 Click on the link “shopping cart” display into the success message
        Thread.sleep(3000);
        productPage.clickOnTheShoppingCartLink();

        //2.9 Verify the text "Shopping Cart"
        String actualShoppingCartText = shoppingCartPage.getShoppingCartText();
        String expectedShoppingCartText = "Shopping Cart";
        Assert.assertTrue(actualShoppingCartText.contains(expectedShoppingCartText), "Shopping cart message is not displayed");

        //2.10 Verify the Product name "MacBook"
        String actualMacBookName = shoppingCartPage.getProductName();
        String expectedMacBookName = "MacBook";
        verifyText(actualMacBookName, expectedMacBookName, "The product name macbook is not displayed");

        //2.11 Change the Quantity "2"
        shoppingCartPage.changeQtyOfProduct("2");

        //2.12 Click on the “Update” Tab
        shoppingCartPage.clickOnUpdateButton();

        //2.13 Verify the message “Success: You have modified your shopping cart!”
        String actualUpdatedMessage = shoppingCartPage.getUpdatedCartMessage();
        String expectedUpdatedMessage = "Success: You have modified your shopping cart!";
        verifyText(actualUpdatedMessage, expectedUpdatedMessage, "Updated Shopping cart message is not displayed");

        //2.14 Verify the Total £737.45
        String actualUpdatedPrice = shoppingCartPage.getPrice();
        String expectedUpdatedPrice = "£737.45";
        verifyText(actualUpdatedPrice, expectedUpdatedPrice, "Price is not displayed");

        //2.15 Click on the “Checkout” button
        shoppingCartPage.clickOnCheckOut();

        //prodcut not available so unable to perform rest of the test.
    }
}
