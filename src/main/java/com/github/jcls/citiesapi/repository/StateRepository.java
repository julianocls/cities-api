package com.github.jcls.citiesapi.repository;

import com.github.jcls.citiesapi.domain.State;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface StateRepository extends JpaRepository<State, Long> {

    public Optional<List<State>> findByNameContainingIgnoreCase(String name);

}
