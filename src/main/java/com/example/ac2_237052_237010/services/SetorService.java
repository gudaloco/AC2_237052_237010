package com.example.ac2_237052_237010.services;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.ac2_237052_237010.dtos.DadosSetorDTO;
import com.example.ac2_237052_237010.models.Setor;
import com.example.ac2_237052_237010.repositories.SetorRepository;

import java.util.stream.Collectors;

@Service
public interface SetorService {
    private final SetorRepository setorRepository;

    public SetorService(SetorRepository setorRepository) {
        this.setorRepository = setorRepository;
    }

    public Setor criarSetor(Setor setor) {
        return setorRepository.save(setor);
    }

    @Transactional(readOnly = true)
    public DadosSetorDTO buscarSetorPorId(Integer id) {
        Setor s = setorRepository.findByIdWithFuncionarios(id)
                .orElseThrow(() -> new IllegalArgumentException("Setor não encontrado: " + id));

        return ((Object) DadosSetorDTO.builder())
                .id(s.getId())
                .nome(s.getNome())
                .funcionarios(s.getFunciorios()
                        .stream()
                        .map(f -> new com.exemplo.projetos.dto.FuncionarioResumoDTO())
                        .collect(Collectors.toList())
                ).build();
    }
}
