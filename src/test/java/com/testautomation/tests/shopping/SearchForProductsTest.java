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

@Feature("Product Search")
public class SearchForProductsTest extends BaseTest {

    private SearchComponent searchComponent;
    private ProductList productList;
    private NavBar navBar;

    @BeforeMethod
    public void setUp() {
        searchComponent = new SearchComponent();
        productList = new ProductList();
        navBar = new NavBar();
    }

    @AfterMethod
    public void tearDown() {
        ScreenshotManager.takeScreenshot(DriverManager.getDriver(), "Search test completed");
        DriverManager.quitDriver();
    }

    @Test
    @Story("Searching for products")
    @Description("Search for products by keyword")
    @Severity(SeverityLevel.NORMAL)
    public void searchingByKeyword() {
        navBar.openHomePage();
        
        searchComponent.searchBy("hammer");
        
        List<String> productNames = productList.getProductNames();
        Assert.assertFalse(productNames.isEmpty());
        
        String searchMessage = productList.getSearchCompletedMessage();
        Assert.assertNotNull(searchMessage);
    }

    @Test
    @Story("Searching for products")
    @Description("Search for specific product")
    @Severity(SeverityLevel.NORMAL)
    public void searchingForSpecificProduct() {
        navBar.openHomePage();
        
        searchComponent.searchBy("pliers");
        
        List<String> productNames = productList.getProductNames();
        boolean foundPliers = productNames.stream()
                .anyMatch(name -> name.toLowerCase().contains("pliers"));
        Assert.assertTrue(foundPliers, "Should find pliers in search results");
    }
}
