package com.ninjatutorial.pages;

import com.ninjatutorial.utilities.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class HomePage extends Utility {

    //get all locators from homepage
    By desktopMenu = By.linkText("Desktops");
    By laptopAndNotebookMenu = By.linkText("Laptops & Notebooks");
    By componentMenu = By.linkText("Components");
    By currencyTab = By.xpath("//button[@class='btn btn-link dropdown-toggle']");
    By poundCurrency = By.cssSelector("button[name='GBP']");
    By myAccountLink = By.xpath("//span[normalize-space()='My Account']");
    By selectMyAccountOption = By.xpath("//li[@class='dropdown open']//li/a");


    /**
     * This method will do mouse hover and click on teh desktop menu
     */
    public void mouseHoverAndClickOnDesktop() {
        mouseHoverToElementAndClick(desktopMenu);
    }

    /**
     * This method will do mouse hover and click on teh LaptopAndNoteBook menu
     */
    public void mouseHoverAndClickOnLaptopAndNoteBook() {
        mouseHoverToElementAndClick(laptopAndNotebookMenu);
    }

    /**
     * This method will do mouse hover and click on teh LaptopAndNoteBook menu
     */
    public void mouseHoverAndClickOnComponents() {
        mouseHoverToElementAndClick(componentMenu);
    }

    /**
     * This method will do mouse hover and click on the Currency Tab
     */
    public void mouseHoverAndClickOnCurrency() {
        mouseHoverToElementAndClick(currencyTab);
    }

    /**
     * This method will do mouse hover and click on the pound currency
     */
    public void mouseHoverAndClickOnPoundCurrency() {
        mouseHoverToElementAndClick(poundCurrency);
    }

    /**
     * This method will click on selected Menu tab
     */
    public void selectMenu(String link) {
        clickOnElement(By.linkText(link));
    }

    /**
     * This method will click on my account link.
     */
    public void clickOnMyAccountLink() {
        clickOnElement(myAccountLink);
    }





    /**
     * This method will select option from my account link
     */
    public void selectMyAccountOption(String option) {
        List<WebElement> options = findElements(selectMyAccountOption);
        for (WebElement e : options) {
            if (e.getText().equalsIgnoreCase(option)) {
                e.click();
                break;
            }
        }
    }
}
