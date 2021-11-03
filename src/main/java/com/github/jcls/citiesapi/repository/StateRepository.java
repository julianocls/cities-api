package com.github.jcls.citiesapi.repository;

import com.github.jcls.citiesapi.domain.State;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StateRepository extends JpaRepository<State, Long> {
}
