package com.example.catalogo.services;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.catalogo.entities.Filme;
import com.example.catalogo.repositories.CatalogoRepository;

public class FilmeService {
    @Autowired
    private CatalogoRepository repository;

    public Filme salvar(Filme filme){
        filme = repository.save(filme);
        return filme;
    }
}
