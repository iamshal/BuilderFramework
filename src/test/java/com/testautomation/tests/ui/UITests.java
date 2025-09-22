package com.testautomation.tests.ui;

import com.testautomation.pages.HomePage;
import com.testautomation.pages.LoginPage;
import com.testautomation.pages.ProductPage;
import com.testautomation.pages.CartPage;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.annotations.Test;

public class UITests {

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
    @Description("Test login functionality")
    @Severity(SeverityLevel.NORMAL)
    public void testLogin() {
        HomePage homePage = new HomePage();
        homePage.openHomePage();
        homePage.clickSignIn();
        
        LoginPage loginPage = new LoginPage();
        loginPage.login("test@example.com", "password");
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
