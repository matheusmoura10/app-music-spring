package com.musicapp.application.service.spotify;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.musicapp.application.service.spotify.responses.ResponsePlaylist;
import com.musicapp.application.service.spotify.responses.ResponseTracks;
import com.musicapp.domain.core.SearchService;

@Service("spotifyService")
public class SpotifyService implements SearchService<ResponsePlaylist, ResponseTracks> {

    private final SpotifyPlayListService playListService;
    private final SpotifyTrackService trackService;

    public SpotifyService(SpotifyPlayListService playListService, SpotifyTrackService trackService) {
        this.playListService = playListService;
        this.trackService = trackService;
    }

    @Override
    @Cacheable(value = "playlists_spotify", key = "#query", condition = "#query != 'metallica'")
    public ResponsePlaylist searchPlayList(String query) {

        return playListService.searchPlaylists(query);
    }

    @Override
    @Cacheable(value = "tracks_spotify", key = "#query")
    public ResponseTracks searchTrack(String query) {
        return trackService.searchSongs(query);
    }

}
