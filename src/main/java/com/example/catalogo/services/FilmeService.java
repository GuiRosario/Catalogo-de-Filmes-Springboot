package com.example.catalogo.services;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import jakarta.*;
import com.example.catalogo.entities.Filme;
import com.example.catalogo.repositories.CatalogoRepository;

public class FilmeService {
    @Autowired
    private CatalogoRepository repository;

    public Filme salvar(Filme filme){
        filme = repository.save(filme);
        return filme;
    }

    public Filme alterar(Filme filme){
        if(Objects.nonNull(filme.getId())){
            filme = repository.save(filme);
        }else{
            System.out.println("Filme nao encontrado!");
        }
        return filme;
    }

    public List<Filme> listar(){
        return repository.findAll();
    }

    public Boolean excluir(Integer id){
        try{
            repository.deleteById(id);
        } catch (Exception e){
            System.out.printf("Erro ao realizar Exclusao ",e);
            return false;
        }
        return true;
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
