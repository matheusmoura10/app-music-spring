package com.musicapp.domain.song;

import com.musicapp.application.service.spotify.responses.ResponseTracks;

public interface SongService {

    ResponseTracks searchSongs(String query);
}
