package com.funkey.waves.entities.playlist;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/playlists")
public class PlaylistController {

    private final PlaylistService playlistService;

    public  PlaylistController(PlaylistService playlistService) {
        this.playlistService = playlistService;
    }

    @GetMapping
    public List<Playlist> findAll() {
        return playlistService.getAllPlaylists();
    }

    @PostMapping
    public Playlist savePlaylist(@RequestBody Playlist playlist) {
        return  playlistService.savePlaylist(playlist);
    }



}
