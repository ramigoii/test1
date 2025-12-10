package com.example.Playlist.service;

import com.example.Playlist.dto.SongDto;
import com.example.Playlist.model.Song;

import java.util.List;

public interface SongService {
    List<SongDto> getAll();
    SongDto getById(Long id);
    SongDto add(SongDto songDto);
    SongDto update(Long id, SongDto songDto);
    Boolean delete(Long id);
}
