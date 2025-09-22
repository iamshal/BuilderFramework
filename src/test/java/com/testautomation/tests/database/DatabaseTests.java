package com.testautomation.tests.database;

import com.testautomation.database.DatabaseManager;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.annotations.Test;

import java.sql.ResultSet;

public class DatabaseTests {

    @Test
    @Description("Test database connection and query")
    @Severity(SeverityLevel.NORMAL)
    public void testDatabaseConnection() throws Exception {
        DatabaseManager dbManager = new DatabaseManager();
        dbManager.connect();
        ResultSet resultSet = dbManager.executeQuery("SELECT 1 as test");
        assert resultSet.next();
        dbManager.close();
    }

    @Test
    @Description("Test user table validation")
    @Severity(SeverityLevel.NORMAL)
    public void testUserTableValidation() throws Exception {
        DatabaseManager dbManager = new DatabaseManager();
        dbManager.connect();
        ResultSet resultSet = dbManager.executeQuery("SELECT COUNT(*) as user_count FROM users");
        assert resultSet.next();
        dbManager.close();
    }

    @Test
    @Description("Test product table validation")
    @Severity(SeverityLevel.NORMAL)
    public void testProductTableValidation() throws Exception {
        DatabaseManager dbManager = new DatabaseManager();
        dbManager.connect();
        ResultSet resultSet = dbManager.executeQuery("SELECT COUNT(*) as product_count FROM products");
        assert resultSet.next();
        dbManager.close();
    }

    @Test
    @Description("Test order table validation")
    @Severity(SeverityLevel.NORMAL)
    public void testOrderTableValidation() throws Exception {
        DatabaseManager dbManager = new DatabaseManager();
        dbManager.connect();
        ResultSet resultSet = dbManager.executeQuery("SELECT COUNT(*) as order_count FROM orders");
        assert resultSet.next();
        dbManager.close();
    }

    @Test
    @Description("Test cart table validation")
    @Severity(SeverityLevel.NORMAL)
    public void testCartTableValidation() throws Exception {
        DatabaseManager dbManager = new DatabaseManager();
        dbManager.connect();
        ResultSet resultSet = dbManager.executeQuery("SELECT COUNT(*) as cart_count FROM cart_items");
        assert resultSet.next();
        dbManager.close();
    }

    @Test
    @Description("Test category table validation")
    @Severity(SeverityLevel.NORMAL)
    public void testCategoryTableValidation() throws Exception {
        DatabaseManager dbManager = new DatabaseManager();
        dbManager.connect();
        ResultSet resultSet = dbManager.executeQuery("SELECT COUNT(*) as category_count FROM categories");
        assert resultSet.next();
        dbManager.close();
    }

    @Test
    @Description("Test data integrity validation")
    @Severity(SeverityLevel.NORMAL)
    public void testDataIntegrityValidation() throws Exception {
        DatabaseManager dbManager = new DatabaseManager();
        dbManager.connect();
        ResultSet resultSet = dbManager.executeQuery("SELECT * FROM products WHERE price > 0");
        assert resultSet.next();
        dbManager.close();
    }

    @Test
    @Description("Test foreign key constraints")
    @Severity(SeverityLevel.NORMAL)
    public void testForeignKeyConstraints() throws Exception {
        DatabaseManager dbManager = new DatabaseManager();
        dbManager.connect();
        ResultSet resultSet = dbManager.executeQuery("SELECT * FROM orders o JOIN users u ON o.user_id = u.id LIMIT 1");
        dbManager.close();
    }
}
