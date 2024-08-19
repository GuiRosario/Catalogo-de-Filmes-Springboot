package com.example.catalogo.controllers;

import java.security.CodeSigner;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.catalogo.entities.Genero;
import com.example.catalogo.entities.Filme;
import com.example.catalogo.repositories.GeneroRepository;
import com.example.catalogo.services.GeneroService;

@RestController
@RequestMapping("/catalogo/genero")
@Controller
public class GeneroController {
    @Autowired
    private GeneroService generoService;


    @GetMapping
    public List<Genero> listarGenero(){
        return generoService.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Genero> verGenero(@PathVariable Integer id){
        return generoService.findById(id);
    }

    @PostMapping
    public Genero createGenero(@RequestBody Genero genero){
        return generoService.save(genero);
    }

    @GetMapping("/filmes/{id}")
    public ResponseEntity<?> filmesPorGenero(@PathVariable Integer id){
        List<Filme> filmes = generoService.filmesPorGenero(id);
        return ResponseEntity.ok(filmes);
    }

    @PutMapping
    public ResponseEntity<?> atualizarGenero(@RequestBody Genero genero){
        try {
            Genero generoAtualizado = generoService.updateGenero(genero);
            return ResponseEntity.ok(generoAtualizado);
        }catch (IllegalArgumentException e) {
            System.out.println("Erro 409:" + e.getMessage());
            return ResponseEntity.badRequest().body("Genero não encontrado.");
        } catch (Exception e) {
            System.out.println("Erro 500:" + e.getMessage());
            return ResponseEntity.internalServerError().body("Erro interno no servidor.");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletarGenero(@PathVariable Integer id){
        try{
            generoService.deleteGenero(id);
            return ResponseEntity.ok("Genero deletado com sucesso.");
        }catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body("Genero nao encontrado.");
        }catch (Exception e) {
            return ResponseEntity.internalServerError().body("Erro interno no servidor.");
        }
    }
    
}
