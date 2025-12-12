package com.example.Playlist.controller;

import com.example.Playlist.dto.PlaylistDto;
import com.example.Playlist.service.PlaylistService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/playlist")
public class PlaylistController {
    private final PlaylistService playlistService;
    @GetMapping
    public ResponseEntity<?> getAll(){
        return new ResponseEntity<>(playlistService.getAll(), HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable(name = "id") Long id){
        return new ResponseEntity<>(playlistService.getById(id),HttpStatus.OK);
    }
    @PostMapping()
    public ResponseEntity<?> add(@RequestBody PlaylistDto playlistDto){
        playlistService.add(playlistDto);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable(name = "id") Long id, @RequestBody PlaylistDto playlistDto){
        playlistService.update(id, playlistDto);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable(name = "id") Long id){
        playlistService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
