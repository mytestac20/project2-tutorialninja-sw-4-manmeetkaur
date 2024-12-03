package com.ninjatutorial.testsuite;

import com.ninjatutorial.pages.DesktopPage;
import com.ninjatutorial.pages.HomePage;
import com.ninjatutorial.pages.ProductPage;
import com.ninjatutorial.pages.ShoppingCartPage;
import com.ninjatutorial.testbase.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Collections;
import java.util.List;

public class DeskTopsTest extends TestBase {

    // Create objects of all classes
    HomePage homePage = new HomePage();
    DesktopPage desktopPage = new DesktopPage();
    ProductPage productPage = new ProductPage();
    ShoppingCartPage shoppingCartPage = new ShoppingCartPage();


    public void verifyText(String actualText, String expectedText, String message) {
        Assert.assertEquals(actualText, expectedText, message);
    }

    public void verifyText(List<String> actualText, List<String> expectedText, String message) {
        Assert.assertEquals(actualText, expectedText, message);
    }


    @Test
    public void verifyProductArrangeInAlphabeticalOrder() {
        //1.1 Mouse hover on the Desktops Tab. and click
        homePage.mouseHoverAndClickOnDesktop();

        //1.2 Click on “Show AllDesktops”
        homePage.selectMenu("Show AllDesktops");

        //get all product name before doing any action in the desktop page
        List<String> productsNameBefore = desktopPage.getListOfProductsName();
        Collections.sort(productsNameBefore, Collections.reverseOrder());
        System.out.println(productsNameBefore);

        //1.3 Select Sort By position "Name: Z to A"
        desktopPage.selectSortByFilter("Name (Z - A)");

        //1.4 Verify the Product will be arranged in Descending order.
        List<String> productsNameAfter = desktopPage.getListOfProductsName();
        verifyText(productsNameAfter, productsNameBefore, "Product is not display in descending order");

    }

    @Test
    public void verifyProductAddedToShoppingCartSuccessFully() throws InterruptedException {
        //2.1 Mouse hover on the Currency Dropdown and click
        homePage.mouseHoverAndClickOnCurrency();

        //2.2 Mouse hover on the £Pound Sterling and click
        homePage.mouseHoverAndClickOnPoundCurrency();

        //2.3 Mouse hover on the Desktops Tab.
        homePage.mouseHoverAndClickOnDesktop();

        //2.4 Click on the “Show AllDesktops”
        homePage.selectMenu("Show AllDesktops");

        //2.5 Select the Sort By position "Name: A to Z"
        desktopPage.selectSortByFilter("Name (A - Z)");

        //2.6 Select product “HP LP3065”
        desktopPage.clickOnHPLP3065Product();

        //2.7 Verify the Text "HP LP3065"
        String actualProductName = productPage.getProductNameFromProductPage();
        String expectedProductName = "HP LP3065";
        verifyText(actualProductName, expectedProductName, "The product Name is not display");


        //2.8 Select Delivery Date "2024-11-27"
        productPage.selectDateFromDatePicker("November", "2024", "27");

        //2.9.Enter Qty "1” using Select class.
        productPage.productQty("1");

        //2.10 Click on the “Add to Cart” button
        productPage.clickOnTheAddToCart();

        //2.11 Verify the Message “Success: You have added HP LP3065 to your shopping cart!”
        String actualShoppingCartMessage = productPage.getShoppingCartMessage();
        String expectedShoppingCartMessage = "Success: You have added HP LP3065 to your shopping cart!";
        verifyText(actualShoppingCartMessage, expectedShoppingCartMessage, "Shopping cart message is not displayed");

        //2.12 Click on the link “shopping cart” displayed in a success message
        productPage.clickOnTheShoppingCartLink();

        //2.13 Verify the text "Shopping Cart"
        String actualShoppingCartText = shoppingCartPage.getShoppingCartText();
        String expectedShoppingCartText = "Shopping Cart";
        Assert.assertTrue(actualShoppingCartText.contains(expectedShoppingCartText), "Shopping cart text is not displayed");

        //2.14 Verify the Product name "HP LP3065"
        String actualAddedProductName = shoppingCartPage.getProductName();
        String expectedAddedProductName = "HP LP3065";
        verifyText(actualAddedProductName, expectedAddedProductName, "Product name is not displayed");

        //2.15 Verify the Delivery Date "2024-11-27"
        String actualDeliveryDate = shoppingCartPage.getDeliveryDate()[1];
        String expectedDeliveryDate = "2024-11-27";
        verifyText(actualDeliveryDate, expectedDeliveryDate, "The date is not displayed");

        //2.16 Verify the Model "Product21"
        String actualProductModel = shoppingCartPage.getProductModel();
        String expectedProductModel = "Product21";
        verifyText(actualProductModel, expectedProductModel, "Product model is not displayed");

        //2.17 Verify the Total "£74.73"
        String actualProductPrice = shoppingCartPage.getPrice();
        String expectedProductPrice = "£74.73";
        verifyText(actualProductPrice, expectedProductPrice, "Product model is not displayed");
    }
}
