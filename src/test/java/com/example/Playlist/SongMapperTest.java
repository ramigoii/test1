package com.example.Playlist;

import com.example.Playlist.dto.SongDto;
import com.example.Playlist.mapper.SongMapper;
import com.example.Playlist.model.Song;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
@ActiveProfiles("test")
public class SongMapperTest {

    @Autowired
    private SongMapper songMapper;

    @Test
    void toDtoTest() {
        Song entity = new Song(1L, "Song 1", "2023", null, null);

        SongDto dto = songMapper.toDto(entity);

        Assertions.assertNotNull(dto);
        Assertions.assertNotNull(dto.getId());
        Assertions.assertNotNull(dto.getTitleDto());
        Assertions.assertNotNull(dto.getYearDto());

        Assertions.assertEquals(entity.getId(), dto.getId());
        Assertions.assertEquals(entity.getTitle(), dto.getTitleDto());
        Assertions.assertEquals(entity.getYear(), dto.getYearDto());
    }

    @Test
    void toEntityTest() {
        SongDto dto = new SongDto(1L, "Song 1", "2023");

        Song entity = songMapper.toEntity(dto);

        Assertions.assertNotNull(entity);
        Assertions.assertNotNull(entity.getId());
        Assertions.assertNotNull(entity.getTitle());
        Assertions.assertNotNull(entity.getYear());

        Assertions.assertEquals(dto.getId(), entity.getId());
        Assertions.assertEquals(dto.getTitleDto(), entity.getTitle());
        Assertions.assertEquals(dto.getYearDto(), entity.getYear());
    }

    @Test
    void toDtoListTest() {
        List<Song> entities = new ArrayList<>();
        entities.add(new Song(1L, "S1", "2020", null, null));
        entities.add(new Song(2L, "S2", "2021", null, null));
        entities.add(new Song(3L, "S3", "2022", null, null));

        List<SongDto> dtos = songMapper.toDtoList(entities);

        Assertions.assertNotNull(dtos);
        Assertions.assertEquals(entities.size(), dtos.size());

        for (int i = 0; i < entities.size(); i++) {
            Song ent = entities.get(i);
            SongDto dto = dtos.get(i);

            Assertions.assertEquals(ent.getId(), dto.getId());
            Assertions.assertEquals(ent.getTitle(), dto.getTitleDto());
            Assertions.assertEquals(ent.getYear(), dto.getYearDto());
        }
    }
}
