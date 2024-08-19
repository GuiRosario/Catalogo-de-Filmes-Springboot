package com.example.catalogo.services;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

import com.example.catalogo.entities.Filme;
import com.example.catalogo.entities.Genero;
import com.example.catalogo.repositories.CatalogoRepository;
import com.example.catalogo.repositories.GeneroRepository;

@Slf4j
@Service
public class FilmeService {
    @Autowired
    private CatalogoRepository repository;
    private GeneroRepository generoRepository;

    public Filme salvar(Filme filme){
        return repository.save(filme);
    }

    public Filme alterar(Filme filme){
        Optional <Filme> optionalFilme = consultarPorId(filme.getId());
        if(optionalFilme.isPresent()){
            System.out.println("ID FILME" + consultarPorId(filme.getId()));
            filme = repository.save(filme);
        }else{
            System.out.println("Filme nao encontrado!");
            throw new IllegalArgumentException("Filme not found");
        }
        return filme;
    }

    public List<Filme> listar(){
        return repository.findAll();
    }

    public void excluir(Integer id){
        Optional <Filme> optionalFilme = consultarPorId(id);
        if(optionalFilme.isPresent()){
            repository.deleteById(id);
        }else{
            System.out.println("Erro ao realizar Exclusao");
            throw new IllegalArgumentException("Filme not found");
        }
    }

    public Optional<Filme> consultarPorId(Integer id){
        try{
            Optional<Filme> filme = repository.findById(id);
            return filme;
        } catch(Exception e){
            System.out.printf("Erro ao retornar o filme ", e);
        }
        return null;
    }
}
