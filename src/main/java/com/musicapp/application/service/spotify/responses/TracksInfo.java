package com.musicapp.application.service.spotify.responses;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TracksInfo {
    @JsonProperty("href")
    private String href;

    @JsonProperty("total")
    private int total;

}