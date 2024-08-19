package com.example.catalogo.repositories;

import com.example.catalogo.entities.Filme;
import com.example.catalogo.entities.Genero;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GeneroRepository extends JpaRepository<Genero,Integer>{
}