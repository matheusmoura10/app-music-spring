
package com.musicapp.application.service;

import org.springframework.stereotype.Service;

import com.musicapp.domain.core.SearchService;

@Service
public class SearchServiceImpl<P, T> implements SearchService<P, T> {

    private final SearchService<P, T> searchService;

    public SearchServiceImpl(SearchService<P, T> searchService) {
        this.searchService = searchService;
    }

    @Override
    public P searchPlayList(String query) {
        return searchService.searchPlayList(query);
    }

    @Override
    public T searchTrack(String query) {
        return searchService.searchTrack(query);
    }

}