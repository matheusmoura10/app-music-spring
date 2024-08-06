package com.musicapp.domain.core;

public interface AuthService {
    void authenticate();

    String getAccessToken();
}
