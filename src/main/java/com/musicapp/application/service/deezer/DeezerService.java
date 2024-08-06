package com.musicapp.application.service.deezer;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.musicapp.domain.core.SearchService;

@Service("deezerService")
@Primary
public class DeezerService implements SearchService<String, String> {

    @Override
    public String searchPlayList(String query) {
        return "Deezer playlist:" + query;
    }

    @Override
    public String searchTrack(String query) {
        return "Deezer track:" + query;
    }

}
