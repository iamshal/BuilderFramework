package com.testautomation.api;

import com.testautomation.config.Config;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class ApiClient {
    private RequestSpecification request;

    public ApiClient() {
        RestAssured.baseURI = Config.API_BASE_URL;
        request = RestAssured.given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON);
    }

    public Response get(String endpoint) {
        return request.get(endpoint);
    }

    public Response post(String endpoint, Object body) {
        return request.body(body).post(endpoint);
    }

    public Response put(String endpoint, Object body) {
        return request.body(body).put(endpoint);
    }

    public Response delete(String endpoint) {
        return request.delete(endpoint);
    }

    public ApiClient setAuth(String token) {
        request.header("Authorization", "Bearer " + token);
        return this;
    }
}
