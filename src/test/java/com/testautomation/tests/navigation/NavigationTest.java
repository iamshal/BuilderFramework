package com.testautomation.tests.navigation;

import com.testautomation.pages.*;
import com.testautomation.builder.*;
import com.testautomation.kafka.*;
import com.testautomation.driver.DriverManager;
import com.testautomation.utils.ScreenshotManager;
import com.testautomation.tests.fixtures.BaseTest;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.annotations.AfterMethod;
import org.testng.Assert;

public class NavigationTest extends BaseTest {

    private NavBar navBar;
    private KafkaProducerClient kafkaProducer;

    @BeforeMethod
    public void setUp() {
        navBar = new NavBar();
        kafkaProducer = new KafkaProducerClient();
    }

    @AfterMethod
    public void tearDown() {
        ScreenshotManager.takeScreenshot(DriverManager.getDriver(), "Navigation Test completed");
        if (kafkaProducer != null) kafkaProducer.close();
        DriverManager.quitDriver();
    }

    @Test
    @Description("Navigation Test: Click on Categories page")
    @Severity(SeverityLevel.NORMAL)
    public void testCategoriesNavigation() {
        System.out.println("🚀 Navigation Test: Testing Categories page navigation...");
        
        // Step 1: Create test user using Builder pattern
        User testUser = new UserBuilder()
                .setEmail("nav@example.com")
                .setPassword("nav123")
                .setFirstName("Navigation")
                .setLastName("User")
                .build();
        
        System.out.println("✅ Builder Pattern: Created test user - " + testUser.getFirstName() + " " + testUser.getLastName());
        
        // Step 2: Send Kafka event for navigation
        String navEvent = "{\"event\":\"navigation_started\",\"user\":\"" + testUser.getEmail() + "\",\"page\":\"categories\",\"timestamp\":\"" + System.currentTimeMillis() + "\"}";
        kafkaProducer.sendMessage("navigation-events", navEvent);
        System.out.println("✅ Kafka Event: Navigation event sent to 'navigation-events' topic");
        
        // Step 3: Navigate to home page
        navBar.openHomePage();
        ScreenshotManager.takeScreenshot(DriverManager.getDriver(), "Home page loaded");
        System.out.println("✅ UI Navigation: Home page loaded");
        
        // Step 4: Navigate to categories page
        navBar.openCategoriesPage();
        ScreenshotManager.takeScreenshot(DriverManager.getDriver(), "Categories page loaded");
        System.out.println("✅ UI Navigation: Categories page loaded");
        
        // Step 5: Validate categories page
        String pageTitle = DriverManager.getDriver().getTitle();
        Assert.assertNotNull(pageTitle);
        System.out.println("✅ Page Validation: Categories page title - " + pageTitle);
        
        // Step 6: Send Kafka event for page view
        String pageViewEvent = "{\"event\":\"page_viewed\",\"user\":\"" + testUser.getEmail() + "\",\"page\":\"categories\",\"timestamp\":\"" + System.currentTimeMillis() + "\"}";
        kafkaProducer.sendMessage("page-events", pageViewEvent);
        System.out.println("✅ Kafka Event: Page view event sent to 'page-events' topic");
        
        // Step 7: Framework validation
        Assert.assertTrue(pageTitle.contains("Practice Software Testing"));
        System.out.println("✅ Framework Validation: Categories page navigation successful");
        
        System.out.println("🎉 Navigation Test: Categories page navigation completed successfully!");
    }

    @Test
    @Description("Navigation Test: Click on Contact page")
    @Severity(SeverityLevel.NORMAL)
    public void testContactNavigation() {
        System.out.println("🚀 Navigation Test: Testing Contact page navigation...");
        
        // Step 1: Create test user using Builder pattern
        User testUser = new UserBuilder()
                .setEmail("contact@example.com")
                .setPassword("contact123")
                .setFirstName("Contact")
                .setLastName("User")
                .build();
        
        System.out.println("✅ Builder Pattern: Created test user - " + testUser.getFirstName() + " " + testUser.getLastName());
        
        // Step 2: Send Kafka event for contact navigation
        String contactEvent = "{\"event\":\"contact_navigation\",\"user\":\"" + testUser.getEmail() + "\",\"timestamp\":\"" + System.currentTimeMillis() + "\"}";
        kafkaProducer.sendMessage("contact-events", contactEvent);
        System.out.println("✅ Kafka Event: Contact navigation event sent to 'contact-events' topic");
        
        // Step 3: Navigate to contact page
        navBar.toTheContactPage();
        ScreenshotManager.takeScreenshot(DriverManager.getDriver(), "Contact page loaded");
        System.out.println("✅ UI Navigation: Contact page loaded");
        
        // Step 4: Validate contact page
        String pageTitle = DriverManager.getDriver().getTitle();
        Assert.assertNotNull(pageTitle);
        System.out.println("✅ Page Validation: Contact page title - " + pageTitle);
        
        // Step 5: Send Kafka event for contact page view
        String pageViewEvent = "{\"event\":\"contact_page_viewed\",\"user\":\"" + testUser.getEmail() + "\",\"timestamp\":\"" + System.currentTimeMillis() + "\"}";
        kafkaProducer.sendMessage("page-events", pageViewEvent);
        System.out.println("✅ Kafka Event: Contact page view event sent to 'page-events' topic");
        
        // Step 6: Framework validation
        Assert.assertTrue(pageTitle.contains("Practice Software Testing"));
        System.out.println("✅ Framework Validation: Contact page navigation successful");
        
        System.out.println("🎉 Navigation Test: Contact page navigation completed successfully!");
    }

    @Test
    @Description("Navigation Test: Complete navigation flow with multiple pages")
    @Severity(SeverityLevel.NORMAL)
    public void testCompleteNavigationFlow() {
        System.out.println("🚀 Navigation Test: Testing complete navigation flow...");
        
        // Step 1: Create test user using Builder pattern
        User testUser = new UserBuilder()
                .setEmail("flow@example.com")
                .setPassword("flow123")
                .setFirstName("Flow")
                .setLastName("User")
                .build();
        
        System.out.println("✅ Builder Pattern: Created test user - " + testUser.getFirstName() + " " + testUser.getLastName());
        
        // Step 2: Send Kafka event for navigation flow start
        String flowStartEvent = "{\"event\":\"navigation_flow_started\",\"user\":\"" + testUser.getEmail() + "\",\"timestamp\":\"" + System.currentTimeMillis() + "\"}";
        kafkaProducer.sendMessage("navigation-events", flowStartEvent);
        System.out.println("✅ Kafka Event: Navigation flow start event sent");
        
        // Step 3: Navigate through multiple pages
        String[] pages = {"Home", "Categories", "Contact"};
        String[] pageTitles = new String[pages.length];
        
        for (int i = 0; i < pages.length; i++) {
            String page = pages[i];
            System.out.println("📍 Navigating to: " + page + " page");
            
            switch (page) {
                case "Home":
                    navBar.openHomePage();
                    break;
                case "Categories":
                    navBar.openCategoriesPage();
                    break;
                case "Contact":
                    navBar.toTheContactPage();
                    break;
            }
            
            ScreenshotManager.takeScreenshot(DriverManager.getDriver(), page + " page loaded");
            pageTitles[i] = DriverManager.getDriver().getTitle();
            System.out.println("✅ " + page + " page loaded - Title: " + pageTitles[i]);
            
            // Send Kafka event for each page
            String pageEvent = "{\"event\":\"page_navigated\",\"user\":\"" + testUser.getEmail() + "\",\"page\":\"" + page.toLowerCase() + "\",\"timestamp\":\"" + System.currentTimeMillis() + "\"}";
            kafkaProducer.sendMessage("navigation-events", pageEvent);
            System.out.println("✅ Kafka Event: " + page + " navigation event sent");
        }
        
        // Step 4: Validate all pages
        for (int i = 0; i < pages.length; i++) {
            Assert.assertNotNull(pageTitles[i]);
            Assert.assertTrue(pageTitles[i].contains("Practice Software Testing"));
            System.out.println("✅ Validation: " + pages[i] + " page title verified");
        }
        
        // Step 5: Send completion event
        String completionEvent = "{\"event\":\"navigation_flow_completed\",\"user\":\"" + testUser.getEmail() + "\",\"pages_visited\":" + pages.length + ",\"timestamp\":\"" + System.currentTimeMillis() + "\"}";
        kafkaProducer.sendMessage("navigation-events", completionEvent);
        System.out.println("✅ Kafka Event: Navigation flow completion event sent");
        
        System.out.println("🎉 Navigation Test: Complete navigation flow executed successfully!");
        System.out.println("📊 Pages Visited:");
        for (int i = 0; i < pages.length; i++) {
            System.out.println("  ✓ " + pages[i] + " - " + pageTitles[i]);
        }
        System.out.println("📊 Framework Components Used:");
        System.out.println("  ✓ Builder Pattern (UserBuilder)");
        System.out.println("  ✓ Page Object Model (NavBar)");
        System.out.println("  ✓ Kafka Events (Producer)");
        System.out.println("  ✓ Screenshot Management (Allure)");
        System.out.println("  ✓ Selenium WebDriver (UI Automation)");
    }
}
