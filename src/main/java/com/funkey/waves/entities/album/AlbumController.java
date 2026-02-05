package com.funkey.waves.entities.album;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/albums")
public class AlbumController {

    private final AlbumService albumService;

    public AlbumController(AlbumService albumService) {
        this.albumService = albumService;
    }

    @GetMapping
    public List<Album> findAll() {
        return albumService.getAllAlbums();
    }

    @PostMapping
    public Album  saveAlbum(@RequestBody Album album) {
        return albumService.saveAlbum(album);
    }
}
