package com.example.catalogo.entities;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

import jakarta.persistence.*;

@Getter
@Setter
@Entity
@Table(name="tb_genero")

public class Genero {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer Id;

    private String nome;

    @OneToMany(mappedBy = "genero")
    List<Filme> filmes;
}
