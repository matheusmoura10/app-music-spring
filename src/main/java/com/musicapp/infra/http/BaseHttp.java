package com.musicapp.infra.http;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public abstract class BaseHttp {

    @Autowired
    protected final RestTemplate restTemplate;

    public BaseHttp(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    protected ResponseEntity<String> makeRequest(String url, HttpMethod method) {
        return restTemplate.exchange(url, method, null, String.class);
    }

    protected ResponseEntity<String> makeRequest(String url, HttpMethod method, Object body) {
        return restTemplate.exchange(url, method, new HttpEntity<>(body), String.class);
    }

    protected ResponseEntity<String> makeRequest(String url, HttpMethod method, HttpHeaders headers) {
        return restTemplate.exchange(url, method, new HttpEntity<>(headers), String.class);
    }

    protected ResponseEntity<String> makeRequest(String url, HttpMethod method, Object body, HttpHeaders headers) {
        return restTemplate.exchange(url, method, new HttpEntity<>(body, headers), String.class);
    }

    protected HttpHeaders createHeaders(String token) {
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "Bearer " + token);
        return headers;
    }
}