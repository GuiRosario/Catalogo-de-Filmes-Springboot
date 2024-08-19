package com.example.catalogo.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

import com.example.catalogo.entities.Genero;
import com.example.catalogo.entities.Filme;
import com.example.catalogo.repositories.GeneroRepository;

@Slf4j
@Service
public class GeneroService {
    @Autowired
    private GeneroRepository generoRepository;

    public void testGeneroRepository() {
        System.out.println(generoRepository != null ? "GeneroRepository is injected" : "GeneroRepository is null");
    }

    public List<Genero> findAll() {
        return generoRepository.findAll();
    }

    public Optional<Genero> findById(Integer id) {
        return generoRepository.findById(id);
    }

    public Genero save(Genero genero) {
        return generoRepository.save(genero);
    }

    public void deleteById(Integer id) {
        generoRepository.deleteById(id);
    }

    public List<Filme> filmesPorGenero(Integer id){
        Optional<Genero> generoOptional = findById(id);
        if(generoOptional.isPresent()){
            Genero genero = generoOptional.get();
            return genero.getFilmes();
        }else{
            return new ArrayList<>();
        }
    }

    public Genero updateGenero(Genero genero) {
        Optional<Genero> generoOptional = findById(genero.getId());
        if(generoOptional.isPresent()){
            genero = generoRepository.save(genero);
        }else{
            throw new IllegalArgumentException("Genero not found");
        }
        return genero;
    }

    public void deleteGenero(Integer id) {
        Optional<Genero> generoOptional = findById(id);
        if(generoOptional.isPresent()){
            generoRepository.deleteById(id);
        }else{
            throw new IllegalArgumentException("Genero not found");
        }
    }
}
