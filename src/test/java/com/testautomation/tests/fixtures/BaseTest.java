package com.testautomation.tests.fixtures;

import com.testautomation.driver.DriverManager;
import com.testautomation.utils.ScreenshotManager;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public abstract class BaseTest {
    
    @BeforeMethod
    public void setUp() {
        // Initialize driver if needed
        DriverManager.getDriver();
    }
    
    @AfterMethod
    public void tearDown() {
        // Take final screenshot
        ScreenshotManager.takeScreenshot(DriverManager.getDriver(), "Test completed");
        // Driver cleanup is handled by individual test classes
    }
}
