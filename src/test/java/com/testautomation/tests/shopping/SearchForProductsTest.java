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
        navBar.openHomePage();
    }

    @AfterMethod
    public void tearDown() {
        ScreenshotManager.takeScreenshot(DriverManager.getDriver(), "Search test completed");
        DriverManager.quitDriver();
    }

    @Test
    @Story("Searching for products")
    @Description("When there are matching results")
    @Severity(SeverityLevel.NORMAL)
    public void whenSearchingByKeyword() {
        searchComponent.searchBy("tape");

        List<String> matchingProducts = productList.getProductNames();

        Assert.assertTrue(matchingProducts.contains("Tape Measure 7.5m"));
        Assert.assertTrue(matchingProducts.contains("Measuring Tape"));
        Assert.assertTrue(matchingProducts.contains("Tape Measure 5m"));
    }

    @Test
    @Story("Searching for products")
    @Description("When there are no matching results")
    @Severity(SeverityLevel.NORMAL)
    public void whenThereIsNoMatchingProduct() {
        searchComponent.searchBy("unknown");

        List<String> matchingProducts = productList.getProductNames();

        Assert.assertTrue(matchingProducts.isEmpty());
        String searchMessage = productList.getSearchCompletedMessage();
        Assert.assertTrue(searchMessage.contains("There are no products found."));
    }

    @Test
    @Story("Searching for products")
    @Description("When the user clears a previous search results")
    @Severity(SeverityLevel.NORMAL)
    public void clearingTheSearchResults() {
        searchComponent.searchBy("saw");

        List<String> matchingFilteredProducts = productList.getProductNames();
        Assert.assertEquals(matchingFilteredProducts.size(), 2);

        searchComponent.clearSearch();

        List<String> matchingProducts = productList.getProductNames();
        Assert.assertEquals(matchingProducts.size(), 9);
    }
}
