package com.example.catalogo.entities;

import jakarta.persistence.*;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Getter
@Setter
@Entity
@Table(name="tb_filme")

public class Filme implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer Id;

    private String titulo;
    @Column(name="ds_sinopse", length = 500)
    private String sinopse;

    @ManyToOne
    @JsonBackReference
    private Genero genero;
}