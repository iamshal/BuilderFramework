package com.testautomation.pages;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.WebElement;
import io.qameta.allure.Step;

public class SearchComponent extends BasePage {

    @FindBy(css = "input[placeholder*='Search']")
    private WebElement searchInput;

    @FindBy(css = "button[data-test='search-submit']")
    private WebElement searchButton;
    
    @FindBy(css = "button[data-test='search-reset']")
    private WebElement clearSearchButton;

    public SearchComponent() {
        super();
        PageFactory.initElements(driver, this);
    }

    @Step("Search for keyword: {keyword}")
    public void searchBy(String keyword) {
        waitForElementToBeVisible(searchInput);
        searchInput.clear();
        sendKeys(searchInput, keyword);
        click(searchButton);
    }
    
    @Step("Clear the search criteria")
    public void clearSearch() {
        waitForElementToBeVisible(clearSearchButton);
        click(clearSearchButton);
    }

    public String getSearchCompletedMessage() {
        return driver.findElement(org.openqa.selenium.By.cssSelector("[data-test='search_completed']")).getText();
    }
}
