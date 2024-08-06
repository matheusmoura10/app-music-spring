package com.musicapp.application.service.spotify.responses;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;

@Getter
public class Image implements Serializable {

    private static final long serialVersionUID = 1L;

    @JsonProperty("height")
    private int height;

    @JsonProperty("url")
    private String url;

    @JsonProperty("width")
    private int width;
}