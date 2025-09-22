package com.testautomation.pages;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.WebElement;

public class ProductPage extends BasePage {

    @FindBy(css = "h1")
    private WebElement productName;

    @FindBy(css = "button[type='submit']")
    private WebElement addToCartButton;

    @FindBy(css = ".price")
    private WebElement productPrice;

    public ProductPage() {
        super();
        PageFactory.initElements(driver, this);
    }

    public String getProductName() {
        return productName.getText();
    }

    public String getProductPrice() {
        return productPrice.getText();
    }

    public void clickAddToCart() {
        click(addToCartButton);
    }
}
