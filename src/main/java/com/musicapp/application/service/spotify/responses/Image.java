package com.musicapp.application.service.spotify.responses;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;

@Getter
public class Image {
    @JsonProperty("height")
    private int height;

    @JsonProperty("url")
    private String url;

    @JsonProperty("width")
    private int width;

    // Getters and setters
}