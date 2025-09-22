package com.testautomation.pages;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.WebElement;
import com.testautomation.config.Config;
import com.testautomation.utils.ScreenshotManager;
import io.qameta.allure.Step;

public class NavBar extends BasePage {

    @FindBy(css = "a[data-test='nav-cart']")
    private WebElement cartLink;

    @FindBy(css = "a[href='/']")
    private WebElement homeLink;

    public NavBar() {
        super();
        PageFactory.initElements(driver, this);
    }

    @Step("Open home page")
    public void openHomePage() {
        driver.get(Config.BASE_URL);
        ScreenshotManager.takeScreenshot(driver, "Home page");
    }

    @Step("Open the shopping cart")
    public void openCart() {
        waitForElementToBeClickable(cartLink);
        click(cartLink);
        ScreenshotManager.takeScreenshot(driver, "Shopping cart");
    }
    
    @Step("Open contact page")
    public void toTheContactPage() {
        driver.get(Config.BASE_URL + "/contact");
        ScreenshotManager.takeScreenshot(driver, "Contact page");
    }
}
