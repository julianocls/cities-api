package com.github.jcls.citiesapi.resource;

import com.github.jcls.citiesapi.domain.State;
import com.github.jcls.citiesapi.repository.StateRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestControllerAdvice
@RequestMapping("/states")
public class StateResource {

    private final StateRepository repository;

    public StateResource(final StateRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public ResponseEntity<List<State>> states() {
        Optional<List<State>> optional = Optional.of(repository.findAll());

        return optional.map(
                p -> ResponseEntity.ok().body(p)
        ).orElseGet(
                () -> ResponseEntity.notFound().build()
        );
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<List<State>> findById(@PathVariable String name) {
        Optional<List<State>> optional = repository.findByNameContainingIgnoreCase(name);

        return optional.map(
                p -> ResponseEntity.ok().body(p)
        ).orElseGet(
                () -> ResponseEntity.notFound().build()
        );
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<State> findById(@PathVariable Long id) {
        Optional<State> optional = repository.findById(id);

        return optional.map(
                p -> ResponseEntity.ok().body(p)
        ).orElseGet(
                () -> ResponseEntity.notFound().build()
        );
    }

}
