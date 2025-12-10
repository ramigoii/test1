package com.example.Playlist.mapper;

import com.example.Playlist.dto.PlaylistDto;
import com.example.Playlist.model.Playlist;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PlaylistMapper {
    @Mapping(target = "nameDto", source = "name")
    @Mapping(target = "descriptionDto", source = "description")
    PlaylistDto toDto(Playlist playlist);

    @Mapping(target = "name", source = "nameDto")
    @Mapping(target = "description", source = "descriptionDto")
    Playlist toEntity(PlaylistDto playlistDto);

    List<PlaylistDto> toDtoList(List<Playlist> playlists);
}