package com.ninjatutorial.testbase;

import com.ninjatutorial.propertyreader.PropertyReader;
import com.ninjatutorial.utilities.Utility;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class TestBase extends Utility {
    //get the browser
    String browser = PropertyReader.getInstance().getProperty("browser");

    //Open browser
    @BeforeMethod
    public void setUp() {
        selectBrowser(browser);
    }

    //close the browser
    @AfterMethod
    public void tearDown() {
        closeBrowser();
    }
}
