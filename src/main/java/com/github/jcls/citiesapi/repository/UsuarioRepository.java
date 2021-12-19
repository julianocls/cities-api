package com.github.jcls.citiesapi.repository;

import com.github.jcls.citiesapi.domain.Usuario;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface UsuarioRepository extends PagingAndSortingRepository<Usuario, Long> {

    public Usuario findByUsername(String username);

}
