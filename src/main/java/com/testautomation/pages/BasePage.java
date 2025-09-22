package com.testautomation.pages;

import com.testautomation.driver.DriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public abstract class BasePage {
    public WebDriver driver;
    protected WebDriverWait wait;

    public BasePage() {
        this.driver = DriverManager.getDriver();
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    protected void click(WebElement element) {
        wait.until(webDriver -> element.isDisplayed() && element.isEnabled());
        element.click();
    }

    protected void sendKeys(WebElement element, String text) {
        wait.until(webDriver -> element.isDisplayed() && element.isEnabled());
        element.clear();
        element.sendKeys(text);
    }
}
