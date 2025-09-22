package com.testautomation.tests.shopping;

import com.testautomation.pages.*;
import com.testautomation.driver.DriverManager;
import com.testautomation.utils.ScreenshotManager;
import com.testautomation.tests.fixtures.BaseTest;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.annotations.AfterMethod;
import org.testng.Assert;

import java.util.List;
import java.util.stream.Collectors;

@Feature("Shopping Cart")
public class AddToCartTest extends BaseTest {

    private SearchComponent searchComponent;
    private ProductList productList;
    private ProductDetails productDetails;
    private NavBar navBar;
    private CartPage cartPage;

    @BeforeMethod
    public void setUp() {
        searchComponent = new SearchComponent();
        productList = new ProductList();
        productDetails = new ProductDetails();
        navBar = new NavBar();
        cartPage = new CartPage();
    }

    @AfterMethod
    public void tearDown() {
        ScreenshotManager.takeScreenshot(DriverManager.getDriver(), "Test completed");
        DriverManager.quitDriver();
    }

    @Test
    @Story("Checking out a product")
    @Description("Checking out a single item")
    @Severity(SeverityLevel.NORMAL)
    public void whenCheckingOutASingleItem() {
        navBar.openHomePage();
        
        searchComponent.searchBy("pliers");
        productList.viewProductDetails("Combination Pliers");

        productDetails.increaseQuanityBy(2);
        productDetails.addToCart();

        navBar.openCart();

        List<CartLineItem> lineItems = cartPage.getLineItems();

        Assert.assertEquals(lineItems.size(), 1);
        CartLineItem item = lineItems.get(0);
        Assert.assertTrue(item.title().contains("Combination Pliers"));
        Assert.assertEquals(item.quantity(), 3);
        Assert.assertEquals(item.total(), item.quantity() * item.price(), 0.01);
    }

    @Test
    @Story("Checking out a product")
    @Description("Checking out multiple items")
    @Severity(SeverityLevel.NORMAL)
    public void whenCheckingOutMultipleItems() {
        navBar.openHomePage();

        productList.viewProductDetails("Bolt Cutters");
        productDetails.increaseQuanityBy(2);
        productDetails.addToCart();

        navBar.openHomePage();
        productList.viewProductDetails("Slip Joint Pliers");
        productDetails.addToCart();

        navBar.openCart();

        List<CartLineItem> lineItems = cartPage.getLineItems();

        Assert.assertEquals(lineItems.size(), 2);
        List<String> productNames = lineItems.stream().map(CartLineItem::title).collect(Collectors.toList());
        Assert.assertTrue(productNames.contains("Bolt Cutters"));
        Assert.assertTrue(productNames.contains("Slip Joint Pliers"));

        for (CartLineItem item : lineItems) {
            Assert.assertTrue(item.quantity() >= 1);
            Assert.assertTrue(item.price() > 0.0);
            Assert.assertTrue(item.total() > 0.0);
            Assert.assertEquals(item.total(), item.quantity() * item.price(), 0.01);
        }
    }
}
