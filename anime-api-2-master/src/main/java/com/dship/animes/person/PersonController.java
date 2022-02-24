package com.dship.animes.person;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/people")
public class PersonController {

    @Autowired
    PersonRepository personRepository;

    @GetMapping
    List<Person> getPeople() {
        return personRepository.findAll();
    }

    @PostMapping
    Person createPerson(@RequestBody Person person) {
        return personRepository.save(person);
    }
}
