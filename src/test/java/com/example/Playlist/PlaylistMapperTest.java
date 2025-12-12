package com.example.Playlist;

import com.example.Playlist.dto.PlaylistDto;
import com.example.Playlist.mapper.PlaylistMapper;
import com.example.Playlist.model.Playlist;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
@ActiveProfiles("test")
public class PlaylistMapperTest {

    @Autowired
    private PlaylistMapper playlistMapper;

    @Test
    void toDtoTest() {
        Playlist entity = new Playlist(1L, "Playlist 1", "Description 1");

        PlaylistDto dto = playlistMapper.toDto(entity);

        Assertions.assertNotNull(dto);
        Assertions.assertNotNull(dto.getId());
        Assertions.assertNotNull(dto.getNameDto());
        Assertions.assertNotNull(dto.getDescriptionDto());

        Assertions.assertEquals(entity.getId(), dto.getId());
        Assertions.assertEquals(entity.getName(), dto.getNameDto());
        Assertions.assertEquals(entity.getDescription(), dto.getDescriptionDto());
    }

    @Test
    void toEntityTest() {
        PlaylistDto dto = new PlaylistDto(1L, "Playlist 1", "Description 1");

        Playlist entity = playlistMapper.toEntity(dto);

        Assertions.assertNotNull(entity);
        Assertions.assertNotNull(entity.getId());
        Assertions.assertNotNull(entity.getName());
        Assertions.assertNotNull(entity.getDescription());

        Assertions.assertEquals(dto.getId(), entity.getId());
        Assertions.assertEquals(dto.getNameDto(), entity.getName());
        Assertions.assertEquals(dto.getDescriptionDto(), entity.getDescription());
    }

    @Test
    void toDtoListTest() {
        List<Playlist> entities = new ArrayList<>();
        entities.add(new Playlist(1L, "P1", "D1"));
        entities.add(new Playlist(2L, "P2", "D2"));
        entities.add(new Playlist(3L, "P3", "D3"));

        List<PlaylistDto> dtos = playlistMapper.toDtoList(entities);

        Assertions.assertNotNull(dtos);
        Assertions.assertEquals(entities.size(), dtos.size());

        for (int i = 0; i < entities.size(); i++) {
            Playlist entity = entities.get(i);
            PlaylistDto dto = dtos.get(i);

            Assertions.assertEquals(entity.getId(), dto.getId());
            Assertions.assertEquals(entity.getName(), dto.getNameDto());
            Assertions.assertEquals(entity.getDescription(), dto.getDescriptionDto());
        }
    }
}
