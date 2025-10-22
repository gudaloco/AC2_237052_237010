package com.example.ac2_237052_237010.models;

import java.util.ArrayList;
import java.util.List;



import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Funcionario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nome;

   @ManyToOne
   @JoinColumn(name = "setor_id")
   private Setor setor;

   @ManyToMany(mappedBy = "funcionarios")
   private List<Projeto> projetos = new ArrayList<>();
}