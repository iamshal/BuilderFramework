package com.testautomation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import io.qameta.allure.Step;

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
        return driver.findElements(By.cssSelector(".card h3"))
                .stream()
                .map(WebElement::getText)
                .collect(Collectors.toList());
    }

    @Step("View product details for: {productName}")
    public void viewProductDetails(String productName) {
        WebElement productCard = driver.findElement(By.xpath("//div[contains(@class,'card')]//h3[contains(text(),'" + productName + "')]/.."));
        click(productCard);
    }

    public String getSearchCompletedMessage() {
        return driver.findElement(By.cssSelector(".search-completed")).getText();
    }
}
