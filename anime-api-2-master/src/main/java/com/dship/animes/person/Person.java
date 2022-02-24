package com.dship.animes.person;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.dship.animes.watchlist.Watchlist;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonIgnore
    @OneToMany(mappedBy = "person")
    private Set<Watchlist> watchlists;

    private String name;

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Watchlist> getWatchlists() {
        return this.watchlists;
    }

}
