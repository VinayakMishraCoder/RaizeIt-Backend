package com.raiseit.backend.utils;

import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.Map;

@Component
public class RestApiClient {

    private final RestTemplate restTemplate;

    public RestApiClient() {
        this.restTemplate = new RestTemplate();
    }

    private URI buildUri(String baseUrl, String path, Map<String, String> queryParams) {
        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(baseUrl + path);
        if (queryParams != null) {
            queryParams.forEach(builder::queryParam);
        }
        return builder.build().encode().toUri();
    }

    private HttpHeaders buildHeaders(Map<String, String> headers) {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        if (headers != null) {
            headers.forEach(httpHeaders::set);
        }
        return httpHeaders;
    }

    public <T> T get(String baseUrl, String path, Map<String, String> headers, Map<String, String> queryParams, Class<T> responseType) {
        URI uri = buildUri(baseUrl, path, queryParams);
        HttpEntity<Void> entity = new HttpEntity<>(buildHeaders(headers));
        ResponseEntity<T> response = restTemplate.exchange(uri, HttpMethod.GET, entity, responseType);
        return response.getBody();
    }

    public <T, R> R post(String baseUrl, String path, Map<String, String> headers, Map<String, String> queryParams, T requestBody, Class<R> responseType) {
        URI uri = buildUri(baseUrl, path, queryParams);
        HttpEntity<T> entity = new HttpEntity<>(requestBody, buildHeaders(headers));
        ResponseEntity<R> response = restTemplate.exchange(uri, HttpMethod.POST, entity, responseType);
        return response.getBody();
    }

    public <T, R> R put(String baseUrl, String path, Map<String, String> headers, Map<String, String> queryParams, T requestBody, Class<R> responseType) {
        URI uri = buildUri(baseUrl, path, queryParams);
        HttpEntity<T> entity = new HttpEntity<>(requestBody, buildHeaders(headers));
        ResponseEntity<R> response = restTemplate.exchange(uri, HttpMethod.PUT, entity, responseType);
        return response.getBody();
    }

    public <R> R delete(String baseUrl, String path, Map<String, String> headers, Map<String, String> queryParams, Class<R> responseType) {
        URI uri = buildUri(baseUrl, path, queryParams);
        HttpEntity<Void> entity = new HttpEntity<>(buildHeaders(headers));
        ResponseEntity<R> response = restTemplate.exchange(uri, HttpMethod.DELETE, entity, responseType);
        return response.getBody();
    }
}

