CREATE TABLE t_artist(
    artist_id BIGSERIAL PRIMARY KEY,
    t_name VARCHAR(255),
    t_genre VARCHAR(255)
);

CREATE TABLE t_playlist(
    playlist_id BIGSERIAL PRIMARY KEY,
    t_name VARCHAR(255),
    t_description VARCHAR(255)
);

CREATE TABLE t_song(
    song_id BIGSERIAL PRIMARY KEY,
    t_title VARCHAR(255),
    t_year VARCHAR(255),
    artist_id BIGINT,
    CONSTRAINT fk_song_artist
        FOREIGN KEY (artist_id) REFERENCES t_artist(artist_id)
            ON DELETE SET NULL
);

CREATE TABLE t_song_playlists (
    song_id BIGINT NOT NULL,
    playlist_id BIGINT NOT NULL,

    PRIMARY KEY (song_id, playlist_id),

    CONSTRAINT fk_song_playlist_song
       FOREIGN KEY (song_id) REFERENCES t_song(song_id)
           ON DELETE CASCADE,

    CONSTRAINT fk_song_playlist_playlist
        FOREIGN KEY (playlist_id) REFERENCES t_playlist(playlist_id)
            ON DELETE CASCADE
);

CREATE TABLE t_user (
    user_id BIGSERIAL PRIMARY KEY,
    t_username VARCHAR(255),
    t_email VARCHAR(255) NOT NULL UNIQUE,
    t_password VARCHAR(255) NOT NULL
);

CREATE TABLE t_permission (
    permission_id BIGSERIAL PRIMARY KEY,
    t_name VARCHAR(255) NOT NULL UNIQUE
);

CREATE TABLE t_user_permissions (
    user_id BIGINT NOT NULL,
    permissions_id BIGINT NOT NULL,

    CONSTRAINT fk_user_permissions_user
        FOREIGN KEY (user_id) REFERENCES t_user(user_id)
            ON DELETE CASCADE,

    CONSTRAINT fk_user_permissions_permission
        FOREIGN KEY (permissions_id) REFERENCES t_permission(permission_id)
            ON DELETE CASCADE,

    PRIMARY KEY (user_id, permissions_id)
);