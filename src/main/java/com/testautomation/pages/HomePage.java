package com.testautomation.pages;

import com.testautomation.config.Config;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends BasePage {

    @FindBy(css = "a[href*='auth/login']")
    private WebElement signInLink;

    @FindBy(css = "a[href*='cart']")
    private WebElement cartIcon;

    public HomePage() {
        super();
        PageFactory.initElements(driver, this);
    }

    public void openHomePage() {
        driver.get(Config.BASE_URL);
    }

    public void clickSignIn() {
        click(signInLink);
    }

    public void clickCart() {
        click(cartIcon);
    }

    public boolean isSignInVisible() {
        return signInLink.isDisplayed();
    }
}
