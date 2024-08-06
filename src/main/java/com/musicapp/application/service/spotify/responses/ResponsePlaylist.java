package com.musicapp.application.service.spotify.responses;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ResponsePlaylist {
    @JsonProperty("playlists")
    private ResponsePagination<Playlist> playlists;
}
