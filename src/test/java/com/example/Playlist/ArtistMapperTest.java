package com.example.Playlist;

import com.example.Playlist.dto.ArtistDto;
import com.example.Playlist.mapper.ArtistMapper;
import com.example.Playlist.model.Artist;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
@ActiveProfiles("test")
public class ArtistMapperTest {
    @Autowired
    private ArtistMapper artistMapper;

    @Test
    void toDtoTest(){
        Artist ent = new Artist(1L,"name1","genre1");
        ArtistDto dto = artistMapper.toDto(ent);
        Assertions.assertNotNull(dto);
        Assertions.assertNotNull(dto.getId());
        Assertions.assertNotNull(dto.getNameDto());
        Assertions.assertNotNull(dto.getGenreDto());

        Assertions.assertEquals(ent.getId(),dto.getId());
        Assertions.assertEquals(ent.getName(),dto.getNameDto());
        Assertions.assertEquals(ent.getGenre(),dto.getGenreDto());
    }
    @Test
    void toEntityTest(){
        ArtistDto dto = new ArtistDto(1L,"name1","genre1");
        Artist ent = artistMapper.toEntity(dto);
        Assertions.assertNotNull(ent);
        Assertions.assertNotNull(ent.getId());
        Assertions.assertNotNull(ent.getName());
        Assertions.assertNotNull(ent.getGenre());

        Assertions.assertEquals(dto.getId(),ent.getId());
        Assertions.assertEquals(dto.getNameDto(),ent.getName());
        Assertions.assertEquals(dto.getGenreDto(),ent.getGenre());
    }
    @Test
    void toDtoListTest(){
        List<Artist> ents = new ArrayList<>();
        ents.add(new Artist(1L,"name1","genre1"));
        ents.add(new Artist(2L,"name2","genre2"));
        ents.add(new Artist(3L,"name3","genre3"));

        List<ArtistDto> dtos = artistMapper.toDtoList(ents);
        Assertions.assertNotNull(dtos);
        Assertions.assertNotEquals(0,dtos.size());
        Assertions.assertEquals(ents.size(),dtos.size());
        for(int i = 0;i<ents.size();i++){
            Artist ent = ents.get(i);
            ArtistDto dto = artistMapper.toDto(ent);
            Assertions.assertNotNull(dto);
            Assertions.assertNotNull(dto.getId());
            Assertions.assertNotNull(dto.getNameDto());
            Assertions.assertNotNull(dto.getGenreDto());

            Assertions.assertEquals(ent.getId(),dto.getId());
            Assertions.assertEquals(ent.getName(),dto.getNameDto());
            Assertions.assertEquals(ent.getGenre(),dto.getGenreDto());
        }
    }
}
