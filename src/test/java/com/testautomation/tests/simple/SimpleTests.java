package com.testautomation.tests.simple;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.annotations.Test;

public class SimpleTests {

    @Test
    @Description("Simple test without external dependencies - CI/CD Demo")
    @Severity(SeverityLevel.NORMAL)
    public void testSimpleCalculation() {
        int result = 2 + 2;
        assert result == 4;
        System.out.println("✅ GitLab CI/CD Pipeline Test - Simple calculation passed!");
    }

    @Test
    @Description("Test string operations - CI/CD Demo")
    @Severity(SeverityLevel.NORMAL)
    public void testStringOperations() {
        String testString = "Hello World";
        assert testString.length() == 11;
        assert testString.contains("World");
        System.out.println("✅ GitLab CI/CD Pipeline Test - String operations passed!");
    }

    @Test
    @Description("Test array operations")
    @Severity(SeverityLevel.NORMAL)
    public void testArrayOperations() {
        int[] numbers = {1, 2, 3, 4, 5};
        assert numbers.length == 5;
        assert numbers[0] == 1;
        assert numbers[4] == 5;
    }

    @Test
    @Description("Test object creation")
    @Severity(SeverityLevel.NORMAL)
    public void testObjectCreation() {
        String name = "Test User";
        int age = 25;
        assert name.equals("Test User");
        assert age > 0;
    }
}
