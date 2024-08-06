package com.musicapp.application.service.spotify.responses;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TracksInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    @JsonProperty("href")
    private String href;

    @JsonProperty("total")
    private int total;

}