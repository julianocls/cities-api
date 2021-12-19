package com.github.jcls.citiesapi.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.dom4j.tree.AbstractEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;

@Entity
public class Usuario extends AbstractEntity {

    @Id
    private Long id;

    @NotEmpty
    @Column(unique = true)
    private String username;

    @NotEmpty
    @JsonIgnore
    private String password;

    @NotEmpty
    private String nome;

    @NotEmpty
    private boolean admin;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public boolean isAdmin() {
        return admin;
    }

    public void setAdmin(boolean admin) {
        this.admin = admin;
    }
}
