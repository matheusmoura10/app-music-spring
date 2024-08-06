package com.musicapp.application.service.spotify.responses;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ResponsePlaylist implements Serializable {

    private static final long serialVersionUID = 1L;

    @JsonProperty("playlists")
    private ResponsePagination<Playlist> playlists;
}
