package com.example.Playlist.repository;

import com.example.Playlist.model.Song;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SongRepository  extends JpaRepository<Song, Long> {
}