package com.example.Playlist.controller;

import com.example.Playlist.dto.ArtistDto;
import com.example.Playlist.service.ArtistService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/artist")
public class ArtistController {
    private final ArtistService artistService;
    @GetMapping
    public ResponseEntity<?> getAll(){
        return new ResponseEntity<>(artistService.getAll(), HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable(name = "id") Long id){
        return new ResponseEntity<>(artistService.getById(id),HttpStatus.OK);
    }
    @PostMapping()
    public ResponseEntity<?> add(@RequestBody ArtistDto artistDto){
        artistService.add(artistDto);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable(name = "id") Long id, @RequestBody ArtistDto artistDto){
        artistService.update(id, artistDto);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable(name = "id") Long id){
        artistService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}