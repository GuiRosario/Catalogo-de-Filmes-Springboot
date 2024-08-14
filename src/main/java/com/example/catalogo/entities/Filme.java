package com.example.catalogo.entities;

import jakarta.persistence.*;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@Entity
@Table(name="tb_filme")

public class Filme implements Serializable{
    @Id
    @GeneratedValue
    private Integer Id;

    private String titulo;
    @Column(name="ds_sinopse", length = 500)
    private String sinopse;

    @ManyToOne
    private Genero genero;
}