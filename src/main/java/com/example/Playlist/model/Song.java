package com.example.Playlist.model;

import jakarta.persistence.*;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "t_song")
public class Song {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="t_id")
    private Long id;

    @Column(name="t_title")
    private String title;

    @Column(name="t_year")
    private String year;

    @ManyToOne(fetch = FetchType.LAZY)
    private Artist artist;

    @ManyToMany(fetch = FetchType.LAZY)
    List<Playlist> playlist;

}
