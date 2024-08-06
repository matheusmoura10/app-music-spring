package com.musicapp.application.service.spotify.responses;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;

@Getter
public class ResponseTracks implements Serializable {

    private static final long serialVersionUID = 1L;

    @JsonProperty("tracks")
    private ResponsePagination<Tracks> tracks;
}
