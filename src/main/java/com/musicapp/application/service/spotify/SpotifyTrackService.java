package com.musicapp.application.service.spotify;

import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.musicapp.application.exception.CustomJsonProcessingException;
import com.musicapp.application.exception.NotAuthenticated;
import com.musicapp.application.service.spotify.responses.ResponseTracks;
import com.musicapp.domain.song.SongService;
import com.musicapp.infra.http.BaseHttp;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class SpotifyTrackService extends BaseHttp implements SongService {

    private static final String SEARCH_URL_TEMPLATE = "https://api.spotify.com/v1/search?q=%s&type=track";

    private final SpotifyAuthService authService;
    private final ObjectMapper objectMapper;

    public SpotifyTrackService(SpotifyAuthService authService, ObjectMapper objectMapper) {
        super(authService.getRestTemplate());
        this.authService = authService;
        this.objectMapper = objectMapper;
    }

    @Override
    public ResponseTracks searchSongs(String query) {
        String url = buildSearchUrl(query);
        String token = authService.getAccessToken();
        ResponseEntity<String> response = makeRequest(url, HttpMethod.GET, createHeaders(token));

        return parseResponse(response);
    }

    private String buildSearchUrl(String query) {
        return String.format(SEARCH_URL_TEMPLATE, query);
    }

    private ResponseTracks parseResponse(ResponseEntity<String> response) {
        if (response.getStatusCode().is2xxSuccessful()) {
            try {
                return objectMapper.readValue(response.getBody(), ResponseTracks.class);
            } catch (JsonProcessingException e) {
                throw new CustomJsonProcessingException("Error processing response from Spotify API", e);
            }
        } else {
            throw new NotAuthenticated("Error authenticating with Spotify API");
        }
    }
}