package com.example.ac2_237052_237010.models;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Setor {
   @Id 
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   
   private Integer id;
   private String nome; 

   @OneToMany(mappedBy = "setor", cascade = CascadeType.ALL)
   private List<Funcionario> funcionarios; 
}