package com.example.Playlist.controller;

import com.example.Playlist.dto.SongDto;
import com.example.Playlist.service.SongService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/song")
public class SongController {
    private final SongService songService;
    @GetMapping
    public ResponseEntity<?> getAll(){
        return new ResponseEntity<>(songService.getAll(),HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable(name = "id") Long id){
        return new ResponseEntity<>(songService.getById(id),HttpStatus.OK);
    }
    @PostMapping()
    public ResponseEntity<?> add(@RequestBody SongDto songDto){
        songService.add(songDto);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable(name = "id") Long id, @RequestBody SongDto songDto){
        songService.update(id, songDto);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable(name = "id") Long id){
        songService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
