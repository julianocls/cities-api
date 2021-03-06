package com.github.jcls.citiesapi.resource;

import com.github.jcls.citiesapi.domain.Country;
import com.github.jcls.citiesapi.repository.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/countries")
public class CountryResource {

    @Autowired
    private CountryRepository repository;

    @GetMapping
    public Page<Country> contries(Pageable page) {
        return repository.findAll(page);
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<Country> country(@PathVariable String name) {
        Optional<Country> optional = repository.findByPortugueseNameIgnoreCase(name);
        return optional.map(
                p -> ResponseEntity.ok().body(p)
        ).orElseGet(
                () -> ResponseEntity.notFound().build()
        );
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<Country> findById(@PathVariable Long id) {
        Optional<Country> optional = repository.findById(id);
        return optional.map(
                p -> ResponseEntity.ok().body(p)
        ).orElseGet(
                () -> ResponseEntity.notFound().build()
        );
    }

}
