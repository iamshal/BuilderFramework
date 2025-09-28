package com.testautomation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import io.qameta.allure.Step;
import com.testautomation.utils.ScreenshotManager;

import java.util.List;
import java.util.stream.Collectors;

public class ProductList extends BasePage {

    @FindBy(css = ".card")
    private List<WebElement> productCards;

    public ProductList() {
        super();
        PageFactory.initElements(driver, this);
    }

    public List<String> getProductNames() {
        return driver.findElements(By.cssSelector("[data-test='product-name'], .product-name, h3, .card-title"))
                .stream()
                .map(WebElement::getText)
                .collect(Collectors.toList());
    }

    @Step("View product details for: {productName}")
    public void viewProductDetails(String productName) {
        ScreenshotManager.takeScreenshot(driver, "View product details for " + productName);
        // Try multiple selectors for product cards
        try {
            WebElement productCard = driver.findElement(By.xpath("//div[contains(@class,'card')]//h3[contains(text(),'" + productName + "')]/.."));
            click(productCard);
        } catch (Exception e) {
            // Fallback: click on any element containing the product name
            WebElement productElement = driver.findElement(By.xpath("//*[contains(text(),'" + productName + "')]"));
            click(productElement);
        }
    }

    public String getSearchCompletedMessage() {
        return driver.findElement(By.cssSelector("[data-test='search_completed']")).getText();
    }
}
