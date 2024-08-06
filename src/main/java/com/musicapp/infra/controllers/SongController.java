package com.musicapp.infra.controllers;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.musicapp.domain.core.SearchService;

@RestController
@RequestMapping("/songs")
public class SongController {

    private final SearchService searchService;

    public SongController(@Qualifier("searchService") SearchService searchService) {
        this.searchService = searchService;
    }

    @GetMapping("/search")
    public ResponseEntity<?> searchTrack(@RequestParam String query) {
        return ResponseEntity.ok(searchService.searchTrack(query));
    }

    @GetMapping("/search-playlist")
    public ResponseEntity<?> searchPlayList(@RequestParam String query) {
        return ResponseEntity.ok(searchService.searchPlayList(query));
    }

}
