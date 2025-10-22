package com.example.ac2_237052_237010.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import com.example.ac2_237052_237010.models.Funcionario;
import com.example.ac2_237052_237010.models.Projeto;

import java.util.List;
import java.util.Optional;

public interface FuncionarioRepository extends JpaRepository<Funcionario, Integer> {
    
    List<Projeto> findProjetosByFuncionarioId(@Param("funcId") Integer funcionarioId);
    
    Optional<Funcionario>  findByIdWithProjetos(@Param("id") Integer id);
}
