package com.testautomation.tests.mocking;

import com.testautomation.mocking.WireMockServerManager;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class MockingTests {
    private WireMockServerManager wireMockServer;

    @BeforeClass
    public void setup() {
        wireMockServer = new WireMockServerManager();
        wireMockServer.startServer(8080);
    }

    @Test
    @Description("Test WireMock server setup")
    @Severity(SeverityLevel.NORMAL)
    public void testWireMockSetup() {
        wireMockServer.setupMockResponse("/api/test", "{\"status\":\"success\"}");
    }

    @AfterClass
    public void tearDown() {
        wireMockServer.stopServer();
    }
}
