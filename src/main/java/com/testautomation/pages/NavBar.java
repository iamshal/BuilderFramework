package com.testautomation.pages;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.WebElement;
import com.testautomation.config.Config;
import io.qameta.allure.Step;

public class NavBar extends BasePage {

    @FindBy(css = "a[href*='cart']")
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
    }

    @Step("Open cart page")
    public void openCart() {
        click(cartLink);
    }
}
