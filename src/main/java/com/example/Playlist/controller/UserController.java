package com.example.Playlist.controller;

import com.example.Playlist.model.User;
import com.example.Playlist.service.ArtistService;
import com.example.Playlist.service.MyUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/auth")
public class UserController {
    private final MyUserService myUserService;
    private final ArtistService artistService;

    @GetMapping
    public String get123(){
        return "test";
    }
    @PostMapping("/register")
    public void register(@RequestBody User model){
        myUserService.registr(model);
    }
    @GetMapping("/artist")
    @PreAuthorize("hasAuthority('ROLE_USER')")
    public ResponseEntity<?> getAll(){
        return new ResponseEntity<>(artistService.getAll(), HttpStatus.OK);
    }
}
