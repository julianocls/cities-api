package com.github.jcls.citiesapi.repository;

import com.github.jcls.citiesapi.domain.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CountryRepository extends JpaRepository<Country, Long> {

    public Country findByPortugueseNameIgnoreCase(String name);
}
