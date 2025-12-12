package com.example.Playlist;

import com.example.Playlist.dto.PlaylistDto;
import com.example.Playlist.service.PlaylistService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;
import java.util.Random;

@SpringBootTest
@ActiveProfiles("test")
public class PlaylistServiceTest {

    @Autowired
    private PlaylistService playlistService;

    private PlaylistDto createOne() {
        PlaylistDto dto = new PlaylistDto();
        dto.setNameDto("name");
        dto.setDescriptionDto("description1");
        return playlistService.add(dto);
    }

    @Test
    void getAllTest() {
        createOne();
        List<PlaylistDto> dtos = playlistService.getAll();
        Assertions.assertNotNull(dtos);
        Assertions.assertNotEquals(0, dtos.size());
        for (int i = 0; i < dtos.size(); i++) {
            PlaylistDto dto = dtos.get(i);
            Assertions.assertNotNull(dto);
            Assertions.assertNotNull(dto.getId());
            Assertions.assertNotNull(dto.getNameDto());
            Assertions.assertNotNull(dto.getDescriptionDto());
        }
    }

    @Test
    void getByIdTest() {
        createOne();
        Random random = new Random();
        int ind = random.nextInt(playlistService.getAll().size());
        Long someId = playlistService.getAll().get(ind).getId();
        PlaylistDto dto = playlistService.getById(someId);
        Assertions.assertNotNull(dto);
        Assertions.assertNotNull(dto.getId());
        Assertions.assertNotNull(dto.getNameDto());
        Assertions.assertNotNull(dto.getDescriptionDto());

        PlaylistDto check = playlistService.getById(-1L);
        Assertions.assertNull(check);
    }

    @Test
    void addTest() {
        PlaylistDto dto = createOne();
        PlaylistDto created = playlistService.add(dto);
        Assertions.assertNotNull(created);
        Assertions.assertNotNull(created.getId());
        Assertions.assertNotNull(created.getNameDto());
        Assertions.assertNotNull(created.getDescriptionDto());

        Assertions.assertEquals(dto.getNameDto(), created.getNameDto());
        Assertions.assertEquals(dto.getDescriptionDto(), created.getDescriptionDto());

        PlaylistDto getDto = playlistService.getById(created.getId());
        Assertions.assertNotNull(getDto);
        Assertions.assertNotNull(getDto.getId());
        Assertions.assertNotNull(getDto.getNameDto());
        Assertions.assertNotNull(getDto.getDescriptionDto());

        Assertions.assertEquals(created.getNameDto(), getDto.getNameDto());
        Assertions.assertEquals(created.getDescriptionDto(), getDto.getDescriptionDto());
    }

    @Test
    void updateTest() {
        createOne();
        Random random = new Random();
        int ind = random.nextInt(playlistService.getAll().size());
        Long someId = playlistService.getAll().get(ind).getId();

        PlaylistDto dto = createOne();
        dto.setId(someId);
        PlaylistDto before = playlistService.update(someId, dto);
        Assertions.assertNotNull(before);
        Assertions.assertNotNull(before.getId());
        Assertions.assertNotNull(before.getNameDto());
        Assertions.assertNotNull(before.getDescriptionDto());

        Assertions.assertEquals(before.getNameDto(), dto.getNameDto());
        Assertions.assertEquals(before.getDescriptionDto(), dto.getDescriptionDto());

        PlaylistDto after = playlistService.getById(someId);
        Assertions.assertNotNull(after);
        Assertions.assertNotNull(after.getId());
        Assertions.assertNotNull(after.getNameDto());
        Assertions.assertNotNull(after.getDescriptionDto());

        Assertions.assertEquals(before.getId(), after.getId());
        Assertions.assertEquals(before.getNameDto(), after.getNameDto());
        Assertions.assertEquals(before.getDescriptionDto(), after.getDescriptionDto());
    }

    @Test
    void deleteTest() {
        createOne();
        Random random = new Random();
        int ind = random.nextInt(playlistService.getAll().size());
        Long someId = playlistService.getAll().get(ind).getId();
        Assertions.assertTrue(playlistService.delete(someId));
        Assertions.assertNull(playlistService.getById(someId));
    }
}

