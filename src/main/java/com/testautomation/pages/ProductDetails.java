package com.testautomation.pages;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.WebElement;
import io.qameta.allure.Step;
import com.testautomation.utils.ScreenshotManager;

public class ProductDetails extends BasePage {

    @FindBy(css = "button[data-test='increase-quantity']")
    private WebElement increaseQuantityButton;

    @FindBy(css = "button[data-test='add-to-cart']")
    private WebElement addToCartButton;

    @FindBy(css = "h1")
    private WebElement productTitle;

    @FindBy(css = ".price")
    private WebElement productPrice;

    public ProductDetails() {
        super();
        PageFactory.initElements(driver, this);
    }

    @Step("Increase quantity by {increment}")
    public void increaseQuanityBy(int increment) {
        for (int i = 1; i <= increment; i++) {
            waitForElementToBeClickable(increaseQuantityButton);
            click(increaseQuantityButton);
        }
        ScreenshotManager.takeScreenshot(driver, "Quantity increased by " + increment);
    }

    @Step("Add to cart")
    public void addToCart() {
        waitForElementToBeClickable(addToCartButton);
        click(addToCartButton);
        ScreenshotManager.takeScreenshot(driver, "Added to cart");
    }

    public String getProductTitle() {
        return productTitle.getText();
    }

    public String getProductPrice() {
        return productPrice.getText();
    }
}
