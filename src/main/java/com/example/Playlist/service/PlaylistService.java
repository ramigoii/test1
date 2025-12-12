package com.example.Playlist.service;

import com.example.Playlist.dto.PlaylistDto;
import com.example.Playlist.model.Playlist;

import java.util.List;

public interface PlaylistService {
    List<PlaylistDto> getAll();
    PlaylistDto getById(Long id);
    PlaylistDto add(PlaylistDto playlistDto);
    PlaylistDto update(Long id, PlaylistDto playlistDto);
    Boolean delete(Long id);
}
