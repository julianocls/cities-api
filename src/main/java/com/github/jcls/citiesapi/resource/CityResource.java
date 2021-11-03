package com.github.jcls.citiesapi.resource;

import com.github.jcls.citiesapi.domain.City;
import com.github.jcls.citiesapi.domain.Country;
import com.github.jcls.citiesapi.repository.CityRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("cities")
public class CityResource {

    private final CityRepository repository;

    public CityResource(final CityRepository repository) {
        this.repository = repository;
    }

  /* 1st
  @GetMapping
  public List<City> cities() {
      return repository.findAll();
  }*/

    // 2nd - Pageable
    @GetMapping
    public Page<City> cities(final Pageable page) {
        return repository.findAll(page);
    }

    @GetMapping("/name/{name}")
    public List<City> city(@PathVariable String name) {
        return repository.findByNameContainingIgnoreCase(name);
    }
    
}
