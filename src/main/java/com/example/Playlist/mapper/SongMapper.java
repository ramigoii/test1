package com.example.Playlist.mapper;

import com.example.Playlist.dto.SongDto;
import com.example.Playlist.model.Song;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface SongMapper {
    @Mapping(target = "titleDto", source = "title")
    @Mapping(target = "yearDto", source = "year")
    SongDto toDto(Song song);

    @Mapping(target = "title", source = "titleDto")
    @Mapping(target = "year", source = "yearDto")
    Song toEntity(SongDto songDto);

    List<SongDto> toDtoList(List<Song> songs);
}