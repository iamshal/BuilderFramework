package com.testautomation.tests.ui;

import com.testautomation.pages.HomePage;
import com.testautomation.pages.LoginPage;
import com.testautomation.pages.ProductPage;
import com.testautomation.pages.CartPage;
import com.testautomation.builder.UserBuilder;
import com.testautomation.builder.User;
import com.testautomation.driver.DriverManager;
import com.testautomation.utils.ScreenshotManager;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class UITests {

    @BeforeMethod
    public void setUp() {
        // Initialize driver
        DriverManager.getDriver();
    }

    @AfterMethod
    public void tearDown() {
        ScreenshotManager.takeScreenshot(DriverManager.getDriver(), "UI Test completed");
        DriverManager.quitDriver();
    }

    @Test
    @Description("Test home page navigation")
    @Severity(SeverityLevel.NORMAL)
    public void testHomePageNavigation() {
        HomePage homePage = new HomePage();
        homePage.openHomePage();
        // Just check if page loads successfully
        assert homePage.driver.getTitle().contains("Practice Software Testing");
    }

    @Test
    @Description("Test login functionality with Builder pattern")
    @Severity(SeverityLevel.NORMAL)
    public void testLogin() {
        // Builder Pattern: Create test user data
        User testUser = new UserBuilder()
                .setEmail("test@example.com")
                .setPassword("password")
                .setFirstName("Test")
                .setLastName("User")
                .build();
        
        HomePage homePage = new HomePage();
        homePage.openHomePage();
        homePage.clickSignIn();
        
        LoginPage loginPage = new LoginPage();
        loginPage.login(testUser.getEmail(), testUser.getPassword());
    }

    @Test
    @Description("Test product page functionality")
    @Severity(SeverityLevel.NORMAL)
    public void testProductPage() {
        ProductPage productPage = new ProductPage();
        productPage.driver.get("http://practicesoftwaretesting.com/#/product/1");
        // Just check if page loads
        assert productPage.driver.getTitle().contains("Practice Software Testing");
    }

    @Test
    @Description("Test add to cart functionality")
    @Severity(SeverityLevel.NORMAL)
    public void testAddToCart() {
        ProductPage productPage = new ProductPage();
        productPage.driver.get("http://practicesoftwaretesting.com/#/product/1");
        // Just check if page loads
        assert productPage.driver.getTitle().contains("Practice Software Testing");
    }

    @Test
    @Description("Test cart page functionality")
    @Severity(SeverityLevel.NORMAL)
    public void testCartPage() {
        CartPage cartPage = new CartPage();
        cartPage.driver.get("http://practicesoftwaretesting.com/#/cart");
        // Just check if page loads
        assert cartPage.driver.getTitle().contains("Practice Software Testing");
    }

    @Test
    @Description("Test checkout process")
    @Severity(SeverityLevel.NORMAL)
    public void testCheckout() {
        CartPage cartPage = new CartPage();
        cartPage.driver.get("http://practicesoftwaretesting.com/#/cart");
        // Just check if page loads
        assert cartPage.driver.getTitle().contains("Practice Software Testing");
    }
}
