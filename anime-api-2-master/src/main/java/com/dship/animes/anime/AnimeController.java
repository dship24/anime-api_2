package com.dship.animes.anime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/animes")
public class AnimeController {

    @Autowired
    AnimeRepository animeRepository;

    @GetMapping
    List<Anime> getAnimes() {
        return animeRepository.findAll();
    }

    @PostMapping
    Anime createAnime(@RequestBody Anime anime) {
        return animeRepository.save(anime);
    }
}