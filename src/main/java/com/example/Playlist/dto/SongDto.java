package com.example.Playlist.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SongDto {
    private Long id;
    private String titleDto;
    private String yearDto;
}
