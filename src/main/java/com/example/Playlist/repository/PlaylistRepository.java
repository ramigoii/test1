package com.example.Playlist.repository;

import com.example.Playlist.model.Playlist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlaylistRepository  extends JpaRepository<Playlist, Long> {
}
