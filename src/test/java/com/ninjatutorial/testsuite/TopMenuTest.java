package com.ninjatutorial.testsuite;

import com.ninjatutorial.pages.DesktopPage;
import com.ninjatutorial.pages.HomePage;
import com.ninjatutorial.testbase.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class TopMenuTest extends TestBase {

    //Create objects of various classes
    HomePage homePage = new HomePage();
    DesktopPage desktopPage = new DesktopPage();

    public void verifyText(String actualText, String expectedText, String message) {
        Assert.assertEquals(actualText, expectedText, message);
    }

    public void verifyText(List<String> actualText, List<String> expectedText, String message) {
        Assert.assertEquals(actualText, expectedText, message);
    }


    @Test
    public void verifyUserShouldNavigateToDesktopsPageSuccessfully() {
        //Mouse hover on the “Desktops” Tab and click
        homePage.mouseHoverAndClickOnDesktop();

        //selectMenu method
        homePage.selectMenu("Show AllDesktops");

        //Verify the text ‘Desktops’
        String expectedDesktopText = "Desktops";
        String actualDesktopText = desktopPage.getDesktopText();
        verifyText(actualDesktopText, expectedDesktopText, "Desktop text is not display");
    }

    @Test
    public void verifyUserShouldNavigateToLaptopsAndNotebooksPageSuccessfully() {
        //Mouse hover on the “Laptop and Notebook” Tab and click
        homePage.mouseHoverAndClickOnLaptopAndNoteBook();

        //selectMenu method
        homePage.selectMenu("Show AllLaptops & Notebooks");

        //Verify the text ‘Desktops’
        String expectedDesktopText = "Laptops & Notebooks";
        String actualDesktopText = desktopPage.getDesktopText();
        verifyText(actualDesktopText, expectedDesktopText, "Laptops & Notebooks text is not display");
    }

    @Test
    public void verifyUserShouldNavigateToComponentsPageSuccessfully() {
        //Mouse hover on the “Component” Tab and click
        homePage.mouseHoverAndClickOnComponents();

        //selectMenu method
        homePage.selectMenu("Show AllComponents");

        //Verify the text ‘Desktops’
        String expectedDesktopText = "Components";
        String actualDesktopText = desktopPage.getDesktopText();
        verifyText(actualDesktopText, expectedDesktopText, "Components text is not display");
    }
}
