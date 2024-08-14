package com.example.catalogo.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.catalogo.entities.Filme;
import com.example.catalogo.repositories.CatalogoRepository;
import com.example.catalogo.services.FilmeService;

@RestController
@RequestMapping("/catalogo")
@Controller
public class FilmeController {
    @Autowired
    private FilmeService filmeService;

    @GetMapping
    public List<Filme> getAllFilmes(){
        return filmeService.listar();
    }

    @GetMapping("/{id}")
    public Optional<Filme> getFilmeById(@PathVariable Integer id){
        return filmeService.consultarPorId(id);
    }

    @PostMapping
    public Filme createFilme(@RequestBody Filme filme){
        return filmeService.salvar(filme);
    }
    
}
