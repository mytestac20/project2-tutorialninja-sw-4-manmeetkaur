package com.ninjatutorial.pages;

import com.ninjatutorial.utilities.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class LaptopsAndNoteBooksPage extends Utility {

    //Find all locator
    By listOfProductName = By.xpath("//div[@id='content']//div//div[1]//div[2]//div[1]//p[2]");
    By selectSort = By.xpath("//select[@id='input-sort']");
    By macBookProduct = By.xpath("//a[normalize-space()='MacBook']");
    //By macBookProduct = By.xpath("//a[normalize-space()='HP LP3065']");


    /**
     * This method will get name of all products
     */
    public List<String> getListOfProductPrice() {
        List<WebElement> priceList = findElements(listOfProductName);

        List<String> priceListBefore = new ArrayList<>();
        for (WebElement e : priceList) {
            String price = e.getText().split("\n")[0].replace("$", "").trim();
            priceListBefore.add(price);
        }
        return priceListBefore;
    }

    /**
     * This method will sort the list of product
     */
    public void sortProductByPrice(String option) {
        selectByVisibleTextFromDropDown(selectSort, option);
    }

    /**
     * This method will click on macBook product
     */
    public void clickOnMacBook() {
        clickOnElement(macBookProduct);
    }

}
