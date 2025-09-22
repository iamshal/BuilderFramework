package com.testautomation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import io.qameta.allure.Step;

import java.util.List;
import java.util.stream.Collectors;

public class CartPage extends BasePage {

    @FindBy(css = ".cart-item")
    private List<WebElement> cartItems;

    @FindBy(css = "a[href*='checkout']")
    private WebElement checkoutButton;

    @FindBy(css = "button[class*='remove']")
    private WebElement removeButton;

    public CartPage() {
        super();
        PageFactory.initElements(driver, this);
    }

    public boolean isItemInCart() {
        return !cartItems.isEmpty();
    }

    @Step("Get cart line items")
    public List<CartLineItem> getLineItems() {
        return cartItems.stream()
                .map(item -> {
                    String title = item.findElement(By.cssSelector("h3")).getText();
                    int quantity = Integer.parseInt(item.findElement(By.cssSelector("input[type='number']")).getAttribute("value"));
                    double price = Double.parseDouble(item.findElement(By.cssSelector(".price")).getText().replace("$", ""));
                    double total = Double.parseDouble(item.findElement(By.cssSelector(".total")).getText().replace("$", ""));
                    return new CartLineItem(title, quantity, price, total);
                })
                .collect(Collectors.toList());
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
