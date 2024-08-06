package com.musicapp.application.service.spotify.responses;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;

@Getter
public class ResponseTracks {
    @JsonProperty("tracks")
    private ResponsePagination<Tracks> tracks;
}
