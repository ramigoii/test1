package com.example.Playlist;

import com.example.Playlist.dto.SongDto;
import com.example.Playlist.service.SongService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;
import java.util.Random;

@SpringBootTest
@ActiveProfiles("test")
public class SongServiceTest {

    @Autowired
    private SongService songService;

    private SongDto createOne() {
        SongDto dto = new SongDto();
        dto.setTitleDto("Title");
        dto.setYearDto("2025");
        return songService.add(dto);
    }

    @Test
    void getAllTest() {
        createOne();
        List<SongDto> dtos = songService.getAll();
        Assertions.assertNotNull(dtos);
        Assertions.assertNotEquals(0, dtos.size());
        for (SongDto dto : dtos) {
            Assertions.assertNotNull(dto);
            Assertions.assertNotNull(dto.getId());
            Assertions.assertNotNull(dto.getTitleDto());
            Assertions.assertNotNull(dto.getYearDto());
        }
    }

    @Test
    void getByIdTest() {
        createOne();
        Random random = new Random();
        int ind = random.nextInt(songService.getAll().size());
        Long someId = songService.getAll().get(ind).getId();
        SongDto dto = songService.getById(someId);
        Assertions.assertNotNull(dto);
        Assertions.assertNotNull(dto.getId());
        Assertions.assertNotNull(dto.getTitleDto());
        Assertions.assertNotNull(dto.getYearDto());

        SongDto check = songService.getById(-1L);
        Assertions.assertNull(check);
    }

    @Test
    void addTest() {
        SongDto dto = createOne();
        SongDto created = songService.add(dto);
        Assertions.assertNotNull(created);
        Assertions.assertNotNull(created.getId());
        Assertions.assertNotNull(created.getTitleDto());
        Assertions.assertNotNull(created.getYearDto());

        Assertions.assertEquals(dto.getTitleDto(), created.getTitleDto());
        Assertions.assertEquals(dto.getYearDto(), created.getYearDto());

        SongDto getDto = songService.getById(created.getId());
        Assertions.assertNotNull(getDto);
        Assertions.assertNotNull(getDto.getId());
        Assertions.assertNotNull(getDto.getTitleDto());
        Assertions.assertNotNull(getDto.getYearDto());

        Assertions.assertEquals(created.getTitleDto(), getDto.getTitleDto());
        Assertions.assertEquals(created.getYearDto(), getDto.getYearDto());
    }

    @Test
    void updateTest() {
        createOne();
        Random random = new Random();
        int ind = random.nextInt(songService.getAll().size());
        Long someId = songService.getAll().get(ind).getId();

        SongDto dto = createOne();
        dto.setId(someId);
        SongDto before = songService.update(someId, dto);
        Assertions.assertNotNull(before);
        Assertions.assertNotNull(before.getId());
        Assertions.assertNotNull(before.getTitleDto());
        Assertions.assertNotNull(before.getYearDto());

        Assertions.assertEquals(before.getTitleDto(), dto.getTitleDto());
        Assertions.assertEquals(before.getYearDto(), dto.getYearDto());

        SongDto after = songService.getById(someId);
        Assertions.assertNotNull(after);
        Assertions.assertNotNull(after.getId());
        Assertions.assertNotNull(after.getTitleDto());
        Assertions.assertNotNull(after.getYearDto());

        Assertions.assertEquals(before.getId(), after.getId());
        Assertions.assertEquals(before.getTitleDto(), after.getTitleDto());
        Assertions.assertEquals(before.getYearDto(), after.getYearDto());
    }

    @Test
    void deleteTest() {
        createOne();
        Random random = new Random();
        int ind = random.nextInt(songService.getAll().size());
        Long someId = songService.getAll().get(ind).getId();
        Assertions.assertTrue(songService.delete(someId));
        Assertions.assertNull(songService.getById(someId));
    }
}

