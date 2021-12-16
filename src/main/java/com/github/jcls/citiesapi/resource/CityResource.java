package com.github.jcls.citiesapi.resource;

import com.github.jcls.citiesapi.domain.City;
import com.github.jcls.citiesapi.repository.CityRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("cities")
public class CityResource {

    private final CityRepository repository;

    public CityResource(CityRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public ResponseEntity<Page<City>> cities(final Pageable page) {
        Optional<Page<City>> optional = Optional.of(repository.findAll(page));
        return optional.map(
                    c -> ResponseEntity.ok().body(c)
                ).orElseGet(
                        () -> ResponseEntity.notFound().build()
                );
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<List<City>> city(@PathVariable String name) {
        Optional<List<City>> optional = repository.findByNameContainingIgnoreCase(name);
        return optional.map(
                c -> ResponseEntity.ok().body(c)
                ).orElseGet(
                        () -> ResponseEntity.notFound().build()
                );
    }

}
