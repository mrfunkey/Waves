package com.funkey.waves.entities.song;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/songs")
public class SongController {

    private final SongService songService;

    public  SongController(SongService songService) {
        this.songService = songService;
    }

    @GetMapping
    public List<Song> findAll() {
        return songService.getAllSongs();
    }

    @PostMapping
    public Song addSong(@RequestBody Song song) {
        return songService.saveSong(song);
    }

}
