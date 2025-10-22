package com.example.ac2_237052_237010.repositories;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.ac2_237052_237010.models.Projeto;

public interface ProjetoRepository extends JpaRepository<Projeto, Integer>{
    
    @Query
    Optional<Projeto> FindByIdWithFuncionarios(@Param ("id") Integer id);

    List<Projeto> findByDataInicioBetween(LocalDate inicio, LocalDate Fim);

    List<Projeto> findByDataInicioGreaterThanEqualAndDataInicioLessThanEqual(LocalDate inicio, LocalDate fim);
}
