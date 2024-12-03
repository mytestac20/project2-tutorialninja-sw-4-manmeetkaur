package com.ninjatutorial.pages;

import com.ninjatutorial.utilities.Utility;
import org.openqa.selenium.By;

import java.util.List;

public class DesktopPage extends Utility {

    //find all locators of desktop page
    By desktopText = By.xpath("//h2");
    By productNames = By.xpath("//div[@id='content']//div//div[1]//div[2]//div[1]//h4");
    By selectFilter = By.id("input-sort");
    By hpDesktop = By.linkText("HP LP3065");

    /**
     * This method will get desktop text from desktop page
     */
    public String getDesktopText() {
        return getTextFromElement(desktopText);
    }

    /**
     * This method will return list of product names
     */
    public List<String> getListOfProductsName() {
        return getListOfTextFromElement(productNames);
    }

    /**
     * This method will get the product name
     *//*
    public String getProductName() {
        return getTextFromElement()
    }
*/
    /**
     * This method will click on the HP LP3065
     * */
    public void clickOnHPLP3065Product(){
        clickOnElement(hpDesktop);
    }

    /**
     * This Method will sort the data in selected filter
     */
    public void selectSortByFilter(String option) {
        selectByVisibleTextFromDropDown(selectFilter, option);
    }


}
