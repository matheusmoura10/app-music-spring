package com.musicapp.application.service.deezer;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.musicapp.domain.core.SearchService;

@Service("deezerService")
@Primary
public class DeezerService implements SearchService<String, String> {

    @Override
    @Cacheable(value = "playlists_deezer", key = "#query")
    public String searchPlayList(String query) {
        return "Deezer playlist:" + query;
    }

    @Override
    @Cacheable(value = "tracks_deezer", key = "#query")
    public String searchTrack(String query) {
        return "Deezer track:" + query;
    }

}
