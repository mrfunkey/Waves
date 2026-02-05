package com.funkey.waves.entities.song;

import com.funkey.waves.entities.album.Album;
import com.funkey.waves.entities.playlist.Playlist;
import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "songs")
public class Song {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String artist;

    @ManyToMany(mappedBy = "songs")
    private Set<Playlist> playlists = new HashSet<>();


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "album_id")
    private Album album;

    public Song() {
    }

    public Song(String name, String artist, Album album) {
        this.name = name;
        this.artist = artist;
        this.album = album;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public Album getAlbum() {
        return album;
    }

    public void setAlbum(Album album) {
        this.album = album;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Song song = (Song) o;
        return Objects.equals(id, song.id) && Objects.equals(name, song.name) && Objects.equals(artist, song.artist) && Objects.equals(album, song.album);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, artist, album);
    }



}
