package com.github.jcls.citiesapi.service;

import com.github.jcls.citiesapi.domain.Usuario;
import com.github.jcls.citiesapi.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class CustomUserDetailService implements UserDetailsService {

    private UsuarioRepository usuarioRepository;

    @Autowired
    public CustomUserDetailService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuario usuario = Optional.ofNullable(usuarioRepository.findByUsername(username))
                .orElseThrow( () -> new UsernameNotFoundException("Usuário não encontrado!"));

        System.out.println("Username: "+ usuario.getUsername());

        List<GrantedAuthority> authoritiesListAdmin = AuthorityUtils.createAuthorityList("ROLE_USER", "ROLE_ADMIN");
        List<GrantedAuthority> authoritiesListUser = AuthorityUtils.createAuthorityList("ROLE_USER");

        return new User(usuario.getUsername(), usuario.getPassword(), usuario.isAdmin() ? authoritiesListAdmin : authoritiesListUser);
    }
}
