package com.funkey.waves.entities.album;

import com.funkey.waves.entities.song.Song;
import jakarta.persistence.*;

import java.util.List;
import java.util.Objects;

@Entity
@Table (name = "albums")
public class Album {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String releaseYear;

    @OneToMany(mappedBy = "album", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Song> songs;

    public Album() {
    }

    public Album(String title, String releaseYear) {
        this.title = title;
        this.releaseYear = releaseYear;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Song> getSongs() {
        return songs;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Album album = (Album) o;
        return Objects.equals(id, album.id) && Objects.equals(title, album.title) && Objects.equals(releaseYear, album.releaseYear) && Objects.equals(songs, album.songs);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, releaseYear, songs);
    }

    public void addSong(Song song) {
        this.songs.add(song);

        song.setAlbum(this);
    }
}
