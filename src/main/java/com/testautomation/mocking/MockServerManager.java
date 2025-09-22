package com.testautomation.mocking;

import org.mockserver.client.MockServerClient;
import org.mockserver.model.HttpRequest;
import org.mockserver.model.HttpResponse;
import static org.mockserver.model.HttpRequest.request;
import static org.mockserver.model.HttpResponse.response;

public class MockServerManager {
    private MockServerClient mockServerClient;

    public MockServerManager(String host, int port) {
        mockServerClient = new MockServerClient(host, port);
    }

    public void setupMockResponse(String path, String responseBody) {
        mockServerClient.when(
                request()
                        .withMethod("GET")
                        .withPath(path)
        ).respond(
                response()
                        .withStatusCode(200)
                        .withBody(responseBody)
        );
    }

    public void stop() {
        mockServerClient.stop();
    }
}
