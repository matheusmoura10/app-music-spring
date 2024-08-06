package com.musicapp.domain.core;

public interface SearchService<P, T> {
    P searchPlayList(String query);

    T searchTrack(String query);
}
