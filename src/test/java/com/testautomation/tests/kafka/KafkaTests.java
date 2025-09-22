package com.testautomation.tests.kafka;

import com.testautomation.kafka.KafkaProducerClient;
import com.testautomation.kafka.KafkaConsumerClient;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.annotations.Test;

public class KafkaTests {

    @Test
    @Description("Test Kafka message production")
    @Severity(SeverityLevel.NORMAL)
    public void testKafkaMessageProduction() {
        KafkaProducerClient producer = new KafkaProducerClient();
        producer.sendMessage("test-topic", "Test message");
        producer.close();
    }

    @Test
    @Description("Test Kafka order events")
    @Severity(SeverityLevel.NORMAL)
    public void testOrderEvents() {
        KafkaProducerClient producer = new KafkaProducerClient();
        String orderEvent = "{\"orderId\":\"12345\",\"status\":\"created\",\"amount\":99.99}";
        producer.sendMessage("order-events", orderEvent);
        producer.close();
    }

    @Test
    @Description("Test Kafka user events")
    @Severity(SeverityLevel.NORMAL)
    public void testUserEvents() {
        KafkaProducerClient producer = new KafkaProducerClient();
        String userEvent = "{\"userId\":\"user123\",\"action\":\"login\",\"timestamp\":\"2024-01-01T00:00:00Z\"}";
        producer.sendMessage("user-events", userEvent);
        producer.close();
    }

    @Test
    @Description("Test Kafka payment events")
    @Severity(SeverityLevel.NORMAL)
    public void testPaymentEvents() {
        KafkaProducerClient producer = new KafkaProducerClient();
        String paymentEvent = "{\"paymentId\":\"pay123\",\"status\":\"completed\",\"amount\":50.00}";
        producer.sendMessage("payment-events", paymentEvent);
        producer.close();
    }

    @Test
    @Description("Test Kafka consumer subscription")
    @Severity(SeverityLevel.NORMAL)
    public void testKafkaConsumer() {
        KafkaConsumerClient consumer = new KafkaConsumerClient("test-group");
        consumer.subscribe("test-topic");
        consumer.pollMessages();
        consumer.close();
    }

    @Test
    @Description("Test Kafka inventory events")
    @Severity(SeverityLevel.NORMAL)
    public void testInventoryEvents() {
        KafkaProducerClient producer = new KafkaProducerClient();
        String inventoryEvent = "{\"productId\":\"prod123\",\"quantity\":10,\"action\":\"stock_update\"}";
        producer.sendMessage("inventory-events", inventoryEvent);
        producer.close();
    }
}
