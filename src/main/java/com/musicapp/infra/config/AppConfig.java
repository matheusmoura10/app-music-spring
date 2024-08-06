package com.musicapp.infra.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import com.musicapp.application.service.deezer.DeezerService;
import com.musicapp.application.service.spotify.SpotifyService;
import com.musicapp.domain.core.SearchService;

@Configuration
public class AppConfig {

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @Value("${music.service}")
    private String searchService;

    @Bean("searchService")
    public SearchService<?, ?> searchService(SpotifyService spotifyService, DeezerService deezerService) {
        if ("spotifyService".equals(searchService)) {
            return spotifyService;
        } else {
            return deezerService;
        }
    }

}
