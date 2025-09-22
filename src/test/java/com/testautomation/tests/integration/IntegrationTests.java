package com.testautomation.tests.integration;

import com.testautomation.api.ApiClient;
import com.testautomation.kafka.KafkaProducerClient;
import com.testautomation.database.DatabaseManager;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.annotations.Test;

public class IntegrationTests {

    @Test
    @Description("Test end-to-end order flow")
    @Severity(SeverityLevel.NORMAL)
    public void testEndToEndOrderFlow() {
        ApiClient apiClient = new ApiClient();
        KafkaProducerClient kafkaProducer = new KafkaProducerClient();
        
        String orderData = "{\"productId\":\"1\",\"quantity\":2}";
        apiClient.post("/cart/add", orderData);
        
        String orderEvent = "{\"orderId\":\"12345\",\"status\":\"created\"}";
        kafkaProducer.sendMessage("order-events", orderEvent);
        
        kafkaProducer.close();
    }

    @Test
    @Description("Test user registration with database validation")
    @Severity(SeverityLevel.NORMAL)
    public void testUserRegistrationWithDBValidation() throws Exception {
        ApiClient apiClient = new ApiClient();
        DatabaseManager dbManager = new DatabaseManager();
        
        String userData = "{\"first_name\":\"Test\",\"last_name\":\"User\",\"email\":\"test@example.com\",\"password\":\"password123\"}";
        apiClient.post("/auth/register", userData);
        
        dbManager.connect();
        dbManager.executeQuery("SELECT * FROM users WHERE email = 'test@example.com'");
        dbManager.close();
    }

    @Test
    @Description("Test product catalog with Kafka events")
    @Severity(SeverityLevel.NORMAL)
    public void testProductCatalogWithKafkaEvents() {
        ApiClient apiClient = new ApiClient();
        KafkaProducerClient kafkaProducer = new KafkaProducerClient();
        
        apiClient.get("/products");
        
        String catalogEvent = "{\"action\":\"catalog_viewed\",\"timestamp\":\"2024-01-01T00:00:00Z\"}";
        kafkaProducer.sendMessage("catalog-events", catalogEvent);
        
        kafkaProducer.close();
    }
}
