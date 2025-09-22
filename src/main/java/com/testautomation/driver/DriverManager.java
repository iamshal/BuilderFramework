package com.testautomation.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import java.net.URL;

public class DriverManager {
    private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    public static WebDriver getDriver() {
        if (driver.get() == null) {
            ChromeOptions options = new ChromeOptions();
            
            // CI/CD Environment Configuration
            if (isRunningInCI()) {
                System.out.println("🚀 GitLab CI/CD: Configuring Chrome for headless execution...");
                options.addArguments("--headless");
                options.addArguments("--no-sandbox");
                options.addArguments("--disable-dev-shm-usage");
                options.addArguments("--disable-gpu");
                options.addArguments("--window-size=1920,1080");
                options.addArguments("--disable-extensions");
                options.addArguments("--disable-web-security");
                options.addArguments("--allow-running-insecure-content");
                options.addArguments("--ignore-certificate-errors");
                options.addArguments("--ignore-ssl-errors");
                options.addArguments("--user-agent=Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.36");
                
                // Use system Chrome binary
                System.setProperty("webdriver.chrome.driver", "/usr/bin/chromedriver");
            } else {
                System.out.println("🖥️ Local Environment: Using standard Chrome configuration...");
            }
            
            driver.set(new ChromeDriver(options));
        }
        return driver.get();
    }
    
    private static boolean isRunningInCI() {
        return System.getenv("CI") != null || 
               System.getenv("GITLAB_CI") != null ||
               System.getProperty("user.name").equals("gitlab-runner");
    }

    public static void quitDriver() {
        if (driver.get() != null) {
            driver.get().quit();
            driver.remove();
        }
    }
}
