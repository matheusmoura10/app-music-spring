package com.musicapp.application.service.spotify.responses;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;

@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
public class Tracks implements Serializable {

    private static final long serialVersionUID = 1L;

    @JsonProperty("album")
    private Album album;

    @JsonProperty("artists")
    private List<Artist> artists;

    @JsonProperty("disc_number")
    private int discNumber;

    @JsonProperty("duration_ms")
    private long durationMs;

    @JsonProperty("explicit")
    private boolean explicit;

    @JsonProperty("href")
    private String href;

    @JsonProperty("id")
    private String id;

    @JsonProperty("is_local")
    private boolean isLocal;

    @JsonProperty("name")
    private String name;

    @JsonProperty("popularity")
    private int popularity;

    @JsonProperty("preview_url")
    private String previewUrl;

    @JsonProperty("track_number")
    private int trackNumber;

    @JsonProperty("type")
    private String type;

    @JsonProperty("uri")
    private String uri;
}
