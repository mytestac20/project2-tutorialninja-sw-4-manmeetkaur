package com.ninjatutorial.pages;

import com.ninjatutorial.utilities.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class CommonElementPage extends Utility {

    By myAccountLink = By.xpath("//span[normalize-space()='My Account']");
    By selectMyAccountOption = By.xpath("//li[@class='dropdown open']//li/a");
    By logoutMessageElement = By.xpath("//h1[normalize-space()='Account Logout']");
    By continueButton = By.linkText("Continue");


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

    /**
     * This method will click on my account link.
     */
    public void clickOnMyAccountLink() {
        clickOnElement(myAccountLink);
    }

    /**
     * This method will get the logout message
     */
    public String getLogoutText() {
        return getTextFromElement(logoutMessageElement);
    }

    /**
     * This method will click on continue button
     */
    public void clickOnContinueButton() {
        clickOnElement(continueButton);
    }

}