package com.example.Playlist.service;

import com.example.Playlist.dto.ArtistDto;

import java.util.List;

public interface ArtistService {
    List<ArtistDto> getAll();
    ArtistDto getById(Long id);
    ArtistDto add(ArtistDto artistDto);
    ArtistDto update(Long id, ArtistDto artistDto);
    Boolean delete(Long id);
}
