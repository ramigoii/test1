package com.example.Playlist;

import com.example.Playlist.dto.ArtistDto;
import com.example.Playlist.service.ArtistService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;
import java.util.Random;

@SpringBootTest
@ActiveProfiles("test")
public class ArtistServiceTest {
    @Autowired
    private ArtistService artistService;

    private ArtistDto createOne(){
        ArtistDto dto = new ArtistDto();
        dto.setNameDto("name");
        dto.setGenreDto("genre1");
        return artistService.add(dto);
    }
    @Test
    void getAllTest(){
        createOne();
        List<ArtistDto> dtos = artistService.getAll();
        Assertions.assertNotNull(dtos);
        Assertions.assertNotEquals(0,dtos.size());
        for(int i = 0;i<dtos.size();i++) {
            ArtistDto dto = dtos.get(i);
            Assertions.assertNotNull(dto);
            Assertions.assertNotNull(dto.getId());
            Assertions.assertNotNull(dto.getNameDto());
            Assertions.assertNotNull(dto.getGenreDto());
        }
    }
    @Test
    void getByIdTest(){
        createOne();
        Random random = new Random();
        int ind = random.nextInt(artistService.getAll().size());
        Long someId = artistService.getAll().get(ind).getId();
        ArtistDto dto = artistService.getById(someId);
        Assertions.assertNotNull(dto);
        Assertions.assertNotNull(dto.getId());
        Assertions.assertNotNull(dto.getNameDto());
        Assertions.assertNotNull(dto.getGenreDto());

        ArtistDto check = artistService.getById(-1L);
        Assertions.assertNull(check);
    }
    @Test
    void addTest(){
        ArtistDto dto = createOne();
        ArtistDto created = artistService.add(dto);
        Assertions.assertNotNull(created);
        Assertions.assertNotNull(created.getId());
        Assertions.assertNotNull(created.getNameDto());
        Assertions.assertNotNull(created.getGenreDto());

        Assertions.assertEquals(dto.getNameDto(),created.getNameDto());
        Assertions.assertEquals(dto.getGenreDto(),created.getGenreDto());
        ArtistDto getDto = artistService.getById(created.getId());
        Assertions.assertNotNull(getDto);
        Assertions.assertNotNull(getDto.getId());
        Assertions.assertNotNull(getDto.getNameDto());
        Assertions.assertNotNull(getDto.getGenreDto());

        Assertions.assertEquals(created.getNameDto(),getDto.getNameDto());
        Assertions.assertEquals(created.getGenreDto(),getDto.getGenreDto());
    }
    @Test
    void updateTest(){
        createOne();
        Random random = new Random();
        int ind = random.nextInt(artistService.getAll().size());
        Long someId = artistService.getAll().get(ind).getId();
        ArtistDto dto = createOne();
        dto.setId(someId);
        ArtistDto before = artistService.update(someId,dto);
        Assertions.assertNotNull(before);
        Assertions.assertNotNull(before.getId());
        Assertions.assertNotNull(before.getNameDto());
        Assertions.assertNotNull(before.getGenreDto());

        Assertions.assertEquals(before.getNameDto(),dto.getNameDto());
        Assertions.assertEquals(before.getGenreDto(),dto.getGenreDto());

        ArtistDto after = artistService.getById(someId);
        Assertions.assertNotNull(after);
        Assertions.assertNotNull(after.getId());
        Assertions.assertNotNull(after.getNameDto());
        Assertions.assertNotNull(after.getGenreDto());

        Assertions.assertEquals(before.getId(), after.getId());
        Assertions.assertEquals(before.getNameDto(), after.getNameDto());
        Assertions.assertEquals(before.getGenreDto(), after.getGenreDto());
    }
    @Test
    void deleteTest(){
        createOne();
        Random random = new Random();
        int ind = random.nextInt(artistService.getAll().size());
        Long someId = artistService.getAll().get(ind).getId();
        Assertions.assertTrue(artistService.delete(someId));
        Assertions.assertNull(artistService.getById(someId));
    }
}
