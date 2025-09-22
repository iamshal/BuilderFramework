package com.testautomation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import io.qameta.allure.Step;

import java.util.List;
import java.util.stream.Collectors;

public class CartPage extends BasePage {

    @FindBy(css = "app-cart tbody tr")
    private List<WebElement> cartRows;

    @FindBy(css = "a[href*='checkout']")
    private WebElement checkoutButton;

    @FindBy(css = "button[class*='remove']")
    private WebElement removeButton;

    public CartPage() {
        super();
        PageFactory.initElements(driver, this);
    }

    public boolean isItemInCart() {
        return !cartRows.isEmpty();
    }

    @Step("Get cart line items")
    public List<CartLineItem> getLineItems() {
        waitForElementToBeVisible(cartRows.get(0));
        return cartRows.stream()
                .map(row -> {
                    String title = trimmed(row.findElement(By.cssSelector("[data-test='product-title']")).getText());
                    int quantity = Integer.parseInt(row.findElement(By.cssSelector("[data-test='product-quantity']")).getAttribute("value"));
                    double price = Double.parseDouble(price(row.findElement(By.cssSelector("[data-test='product-price']")).getText()));
                    double linePrice = Double.parseDouble(price(row.findElement(By.cssSelector("[data-test='line-price']")).getText()));
                    return new CartLineItem(title, quantity, price, linePrice);
                })
                .collect(Collectors.toList());
    }

    private String trimmed(String value) {
        return value.strip().replaceAll("\u00A0", "");
    }

    private String price(String value) {
        return value.replace("$", "");
    }

    @Step("Click checkout button")
    public void clickCheckout() {
        click(checkoutButton);
    }

    @Step("Remove item from cart")
    public void removeItem() {
        click(removeButton);
    }
}
