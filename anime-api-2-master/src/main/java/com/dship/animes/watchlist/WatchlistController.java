package com.dship.animes.watchlist;

import com.dship.animes.person.Person;
import com.dship.animes.person.PersonRepository;
import com.dship.animes.anime.Anime;
import com.dship.animes.anime.AnimeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/watchlists")
public class WatchlistController {

    @Autowired
    WatchlistRepository watchlistRepository;

    @Autowired
    AnimeRepository animeRepository;

    @Autowired
    PersonRepository personRepository;

    @GetMapping
    List<Watchlist> getWatchlists() {
        return watchlistRepository.findAll();
    }

    @PostMapping
    Watchlist createWatchlist(@RequestBody Watchlist watchlist) {
        return watchlistRepository.save(watchlist);
    }

    @PutMapping("/{watchlistId}/animes/{animeId}")
    Watchlist addAnimeToWatchlist(
            @PathVariable Long watchlistId,
            @PathVariable Long animeId
    ) {
        Watchlist watchlist = watchlistRepository.findById(watchlistId).get();
        Anime student = animeRepository.findById(animeId).get();
        watchlist.animes_in_watchlist.add(student);
        return watchlistRepository.save(watchlist);
    }

    @PutMapping("/{watchlistId}/person/{personId}")
    Watchlist assignPersonToWatchlist(
            @PathVariable Long watchlistId,
            @PathVariable Long personId
    ) {
        Watchlist watchlist = watchlistRepository.findById(watchlistId).get();
        Person person = personRepository.findById(personId).get();
        watchlist.setPerson(person);
        return watchlistRepository.save(watchlist);
    }
}
