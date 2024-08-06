package com.musicapp.application.service.spotify;

import java.util.concurrent.locks.ReentrantLock;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.musicapp.application.exception.NotAuthenticated;
import com.musicapp.domain.core.AuthService;
import com.musicapp.infra.http.BaseHttp;

import jakarta.annotation.PostConstruct;

@Service
public class SpotifyAuthService extends BaseHttp implements AuthService {

    private static final String TOKEN_URL = "https://accounts.spotify.com/api/token";

    @Value("${api.spotify.client.id}")
    private String clientId;

    @Value("${api.spotify.client.secret}")
    private String clientSecret;

    private String accessToken;
    private final ReentrantLock lock = new ReentrantLock();
    private final ObjectMapper objectMapper = new ObjectMapper();

    public SpotifyAuthService(RestTemplate restTemplate) {
        super(restTemplate);
    }

    @PostConstruct
    public void init() {
        authenticate();
    }

    @Override
    public String getAccessToken() {
        return accessToken;
    }

    @Override
    public void authenticate() {
        lock.lock();
        try {

            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
            headers.setBasicAuth(clientId, clientSecret);
            String body = "grant_type=client_credentials";

            ResponseEntity<String> response = this.makeRequest(TOKEN_URL, HttpMethod.POST, body, headers);

            if (response.getStatusCode().is2xxSuccessful()) {
                JsonNode jsonResponse = objectMapper.readTree(response.getBody());
                accessToken = jsonResponse.path("access_token").asText();
            } else {
                throw new NotAuthenticated("Error authenticating with Spotify API");
            }

        } catch (Exception e) {
            throw new NotAuthenticated("Error authenticating with Spotify API");
        } finally {
            lock.unlock();
        }
    }

    public RestTemplate getRestTemplate() {
        return restTemplate;
    }

}
