INSERT INTO t_artist (t_name, t_genre)
VALUES
    ('Imagine Dragons', 'Rock'),
    ('Billie Eilish', 'Pop'),
    ('The Weeknd', 'R&B');
INSERT INTO t_playlist (t_name, t_description)
VALUES
    ('Workout Hits', 'Energetic songs for the gym'),
    ('Chill Vibes', 'Relax and chill music'),
    ('Top 2024', 'Best hits of 2024');
INSERT INTO t_song (t_title, t_year, artist_id)
VALUES
    ('Believer', '2017', 1),
    ('Bad Guy', '2019', 2),
    ('Blinding Lights', '2020', 3),
    ('Thunder', '2017', 1),
    ('Everything I Wanted', '2020', 2);
INSERT INTO t_song_playlists (song_id, playlist_id)
VALUES
    (1, 1),
    (4, 1),
    (2, 2),
    (5, 2),
    (3, 3),
    (1, 3),
    (2, 3);
INSERT INTO t_permission (t_name)
VALUES
    ('ROLE_ADMIN'),
    ('ROLE_USER');

