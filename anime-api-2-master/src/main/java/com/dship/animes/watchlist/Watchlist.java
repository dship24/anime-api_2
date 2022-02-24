package com.dship.animes.watchlist;

import com.dship.animes.person.Person;
import com.dship.animes.anime.Anime;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Watchlist {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    private String name;

    @ManyToMany
    @JoinTable(
            name = "animes_in_watchlist",
            joinColumns = @JoinColumn(name = "watchlist_id"),
            inverseJoinColumns = @JoinColumn(name = "anime_id")
    )
    Set<Anime> animes_in_watchlist = new HashSet<>();

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "person_id", referencedColumnName = "id")
    private Person person;

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Anime> getAnimes_in_watchlist() {
        return animes_in_watchlist;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

}
