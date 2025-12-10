package com.example.Playlist.service.serviceImpl;

import com.example.Playlist.dto.SongDto;
import com.example.Playlist.mapper.SongMapper;
import com.example.Playlist.model.Song;
import com.example.Playlist.repository.SongRepository;
import com.example.Playlist.service.SongService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class SongServiceImpl implements SongService {
    private SongMapper songMapper;
    private SongRepository songRepository;

    @Override
    public List<SongDto> getAll() {
        return songMapper.toDtoList(songRepository.findAll());
    }

    @Override
    public SongDto getById(Long id) {
        return songMapper.toDto(songRepository.findById(id).orElse(null));
    }

    @Override
    public SongDto add(SongDto songDto) {
        return songMapper.toDto(songRepository.save(songMapper.toEntity(songDto)));
    }

    @Override
    public SongDto update(Long id, SongDto songDto) {
        Song dto = songMapper.toEntity(songDto);
        Song ent = songRepository.findById(id).orElse(null);

        ent.setId(dto.getId());
        ent.setTitle(dto.getTitle());
        ent.setYear(dto.getYear());
        return songMapper.toDto(songRepository.save(ent));

    }

    @Override
    public Boolean delete(Long id) {
        songRepository.deleteById(id);
        Song song = songRepository.findById(id).orElse(null);
        if(Objects.isNull(song)){
            return true;
        }
        return false;
    }
}
