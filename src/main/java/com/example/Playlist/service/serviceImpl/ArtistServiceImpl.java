package com.example.Playlist.service.serviceImpl;

import com.example.Playlist.dto.ArtistDto;
import com.example.Playlist.mapper.ArtistMapper;
import com.example.Playlist.model.Artist;
import com.example.Playlist.repository.ArtistRepository;
import com.example.Playlist.service.ArtistService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class ArtistServiceImpl implements ArtistService {
    private final ArtistMapper artistMapper;
    private final ArtistRepository artistRepository;
    @Override
    public List<ArtistDto> getAll() {
        return artistMapper.toDtoList(artistRepository.findAll());
    }

    @Override
    public ArtistDto getById(Long id) {
        return artistMapper.toDto(artistRepository.findById(id).orElse(null));
    }

    @Override
    public ArtistDto add(ArtistDto artistDto) {
        return artistMapper.toDto(artistRepository.save(artistMapper.toEntity(artistDto)));
    }

    @Override
    public ArtistDto update(Long id, ArtistDto artistDto) {
        Artist dto = artistMapper.toEntity(artistDto);
        Artist ent = artistRepository.findById(id).orElse(null);
        ent.setId(dto.getId());
        ent.setName(dto.getName());
        ent.setGenre(dto.getGenre());
        return artistMapper.toDto(artistRepository.save(ent));    }

    @Override
    public Boolean delete(Long id) {
        artistRepository.deleteById(id);
        Artist artist = artistRepository.findById(id).orElse(null);
        if(Objects.isNull(artist)){
            return true;
        }
        return false;
    }
}
