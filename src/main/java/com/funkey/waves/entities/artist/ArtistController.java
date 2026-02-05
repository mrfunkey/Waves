package com.funkey.waves.entities.artist;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/artists")
public class ArtistController {

    private final ArtistService artistService;

    public ArtistController(ArtistService artistService) {
        this.artistService = artistService;
    }

    @GetMapping
    public List<Artist> findAll() {
        return artistService.getAllArtists();
    }

    @PostMapping
    public Artist addArtist(@RequestBody Artist artist) {
        return artistService.saveArtist(artist);
    }
}
