package com.example.ac2_237052_237010.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import com.example.ac2_237052_237010.models.Setor;

public interface SetorRepository extends JpaRepository<Setor, Integer>{
    
    List<Setor> findAllWithFuncionarios();

    Optional<Setor> findByIdWithFuncionarios(@Param("id") Integer id);
}
