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

    private static final String SEARCH_URL = "https://api.spotify.com/v1/search?q=%s&type=track";

    private final SpotifyAuthService authService;

    private final ObjectMapper objectMapper = new ObjectMapper();

    public SpotifyTrackService(SpotifyAuthService authService) {
        super(authService.getRestTemplate());
        this.authService = authService;
    }

    @Override
    public ResponseTracks searchSongs(String query) {
        String url = String.format(SEARCH_URL, query);
        String token = authService.getAccessToken();
        ResponseEntity<String> response = makeRequest(url, HttpMethod.GET, createHeaders(token));

        if (response.getStatusCode().is2xxSuccessful()) {
            try {
                return objectMapper.readValue(response.getBody(),
                        ResponseTracks.class);
            } catch (JsonProcessingException e) {
                throw new CustomJsonProcessingException("Error processing response from Spotify API", e);
            }

        } else {
            throw new NotAuthenticated("Error authenticating with Spotify API");
        }

    }

}
