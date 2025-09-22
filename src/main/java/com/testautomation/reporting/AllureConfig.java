package com.testautomation.reporting;

import io.qameta.allure.Allure;

public class AllureConfig {
    
    public static void addAttachment(String name, String content) {
        Allure.addAttachment(name, content);
    }
    
    public static void addStep(String stepName) {
        Allure.step(stepName);
    }
}
