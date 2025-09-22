package com.testautomation.pages;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.WebElement;
import io.qameta.allure.Step;

public class ProductDetails extends BasePage {

    @FindBy(css = "input[name='quantity']")
    private WebElement quantityInput;

    @FindBy(css = "button[type='submit']")
    private WebElement addToCartButton;

    @FindBy(css = "h1")
    private WebElement productTitle;

    @FindBy(css = ".price")
    private WebElement productPrice;

    public ProductDetails() {
        super();
        PageFactory.initElements(driver, this);
    }

    @Step("Increase quantity by {amount}")
    public void increaseQuanityBy(int amount) {
        int currentQuantity = Integer.parseInt(quantityInput.getAttribute("value"));
        sendKeys(quantityInput, String.valueOf(currentQuantity + amount));
    }

    @Step("Add product to cart")
    public void addToCart() {
        click(addToCartButton);
    }

    public String getProductTitle() {
        return productTitle.getText();
    }

    public String getProductPrice() {
        return productPrice.getText();
    }
}
