package com.testautomation.pages;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.WebElement;
import io.qameta.allure.Step;

public class SearchComponent extends BasePage {

    @FindBy(css = "input[placeholder*='search']")
    private WebElement searchInput;

    @FindBy(css = "button[type='submit']")
    private WebElement searchButton;

    public SearchComponent() {
        super();
        PageFactory.initElements(driver, this);
    }

    @Step("Search for products by keyword: {keyword}")
    public void searchBy(String keyword) {
        sendKeys(searchInput, keyword);
        click(searchButton);
    }

    public String getSearchCompletedMessage() {
        return driver.findElement(org.openqa.selenium.By.cssSelector(".search-completed")).getText();
    }
}
