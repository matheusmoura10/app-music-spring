package com.musicapp.domain.playlist;

import com.musicapp.application.service.spotify.responses.ResponsePlaylist;

public interface PlaylistService {

    ResponsePlaylist searchPlaylists(String query);

}
