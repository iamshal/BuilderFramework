package com.testautomation.mocking;

import com.github.tomakehurst.wiremock.WireMockServer;
import com.github.tomakehurst.wiremock.client.WireMock;
import static com.github.tomakehurst.wiremock.core.WireMockConfiguration.options;

public class WireMockServerManager {
    private WireMockServer wireMockServer;

    public void startServer(int port) {
        wireMockServer = new WireMockServer(options().port(port));
        wireMockServer.start();
        WireMock.configureFor("localhost", port);
    }

    public void stopServer() {
        if (wireMockServer != null) {
            wireMockServer.stop();
        }
    }

    public void setupMockResponse(String url, String response) {
        WireMock.stubFor(WireMock.get(WireMock.urlEqualTo(url))
                .willReturn(WireMock.aResponse()
                        .withStatus(200)
                        .withHeader("Content-Type", "application/json")
                        .withBody(response)));
    }
}
