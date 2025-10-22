package com.example.ac2_237052_237010.models;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor 

public class Projeto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String descricao;

    private LocalDate dataInicio;
    private LocalDate dataFim;

    @ManyToMany
    @JoinTable(
        name = "projeto_funcionario",
        joinColumns = @JoinColumn(name =  "projeto_id"),
        inverseJoinColumns = @JoinColumn(name = "funcionario_id")
    ) 
    private List<Funcionario> funcionarios = new ArrayList<>();
}