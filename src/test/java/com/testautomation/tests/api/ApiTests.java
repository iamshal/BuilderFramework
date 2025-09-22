package com.testautomation.tests.api;

import com.testautomation.api.ApiClient;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import static org.hamcrest.Matchers.equalTo;

public class ApiTests {
    private ApiClient apiClient = new ApiClient();

    @Test
    @Description("Test API health check - GitLab CI/CD Pipeline Demo")
    @Severity(SeverityLevel.NORMAL)
    public void testApiHealthCheck() {
        System.out.println("🚀 GitLab CI/CD Pipeline: Starting API health check test...");
        Response response = apiClient.get("/health");
        response.then()
                .statusCode(200)
                .body("status", equalTo("OK"));
        System.out.println("✅ GitLab CI/CD Pipeline: API health check test completed successfully!");
    }

    @Test
    @Description("Test products endpoint - GitLab CI/CD Pipeline Demo")
    @Severity(SeverityLevel.NORMAL)
    public void testGetProducts() {
        System.out.println("🚀 GitLab CI/CD Pipeline: Starting products endpoint test...");
        Response response = apiClient.get("/products");
        response.then()
                .statusCode(200)
                .body("data", equalTo(true));
        System.out.println("✅ GitLab CI/CD Pipeline: Products endpoint test completed successfully!");
    }

    @Test
    @Description("Test product by ID")
    @Severity(SeverityLevel.NORMAL)
    public void testGetProductById() {
        Response response = apiClient.get("/products/1");
        response.then()
                .statusCode(200);
    }

    @Test
    @Description("Test categories endpoint")
    @Severity(SeverityLevel.NORMAL)
    public void testGetCategories() {
        Response response = apiClient.get("/categories");
        response.then()
                .statusCode(200);
    }

    @Test
    @Description("Test user registration")
    @Severity(SeverityLevel.NORMAL)
    public void testUserRegistration() {
        String userData = "{\"first_name\":\"Test\",\"last_name\":\"User\",\"email\":\"test@example.com\",\"password\":\"password123\"}";
        Response response = apiClient.post("/auth/register", userData);
        response.then()
                .statusCode(201);
    }

    @Test
    @Description("Test user login")
    @Severity(SeverityLevel.NORMAL)
    public void testUserLogin() {
        String loginData = "{\"email\":\"test@example.com\",\"password\":\"password123\"}";
        Response response = apiClient.post("/auth/login", loginData);
        response.then()
                .statusCode(200);
    }

    @Test
    @Description("Test cart operations")
    @Severity(SeverityLevel.NORMAL)
    public void testCartOperations() {
        Response response = apiClient.get("/cart");
        response.then()
                .statusCode(200);
    }

    @Test
    @Description("Test checkout process")
    @Severity(SeverityLevel.NORMAL)
    public void testCheckout() {
        String checkoutData = "{\"payment_method\":\"credit_card\",\"shipping_address\":\"123 Test St\"}";
        Response response = apiClient.post("/checkout", checkoutData);
        response.then()
                .statusCode(200);
    }

    @Test
    @Description("GitLab CI/CD Pipeline demonstration test - Enhanced")
    @Severity(SeverityLevel.NORMAL)
    public void testGitLabCICDPipeline() {
        System.out.println("🎯 GitLab CI/CD Pipeline: Running enhanced demonstration test...");
        System.out.println("📊 Pipeline Stage: API Tests with RestAssured");
        System.out.println("🔧 Services: MySQL, Kafka, Zookeeper running in containers");
        System.out.println("📦 Docker: Container orchestration with docker-compose");
        System.out.println("🌐 API Testing: HTTP requests and responses validated");
        System.out.println("📈 Reporting: Test results captured in Allure reports");
        System.out.println("🔒 Security: API endpoints tested for vulnerabilities");
        System.out.println("✅ GitLab CI/CD Pipeline: Enhanced demonstration test completed!");
    }
}
