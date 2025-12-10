package com.example.Playlist.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PlaylistDto {
    private Long id;
    private String nameDto;
    private String descriptionDto;
}
