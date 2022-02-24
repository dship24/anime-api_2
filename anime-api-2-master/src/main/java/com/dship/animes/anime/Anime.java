package com.dship.animes.anime;

import com.dship.animes.watchlist.Watchlist;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Anime {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    private String name;

    @JsonIgnore
    @ManyToMany(mappedBy = "animes_in_watchlist")
    private Set<Watchlist> watchlists = new HashSet<>();

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Watchlist> getSubjects() {
        return watchlists;
    }

}
