package com.musicapp.application.service.spotify.responses;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;

@Getter
public class ResponsePagination<T> {
    @JsonProperty("href")
    private String href;

    @JsonProperty("items")
    private List<T> items;

    @JsonProperty("limit")
    private int limit;

    @JsonProperty("next")
    private String next;

    @JsonProperty("offset")
    private int offset;

    @JsonProperty("previous")
    private String previous;

    @JsonProperty("total")
    private int total;
}