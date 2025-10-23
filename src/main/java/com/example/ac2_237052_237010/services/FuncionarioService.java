package com.example.ac2_237052_237010.services;

import com.example.ac2_237052_237010.dtos.DadosProjetoDTO;
import com.example.ac2_237052_237010.models.Funcionario;
import com.example.ac2_237052_237010.models.Setor;
import com.example.ac2_237052_237010.repositories.FuncionarioRepository;
import com.example.ac2_237052_237010.repositories.SetorRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Service
public class FuncionarioService {
    private final FuncionarioRepository funcionarioRepository;
    private final SetorRepository setorRepository;

    public FuncionarioService(FuncionarioRepository funcionarioRepository, SetorRepository setorRepository) {
        this.funcionarioRepository = funcionarioRepository;
        this.setorRepository = setorRepository;
    }

    public Funcionario criarFuncionario(Funcionario f, Integer idSetor) {
        if (idSetor != null) {
            Setor setor = setorRepository.findById(idSetor)
                    .orElseThrow(() -> new NoSuchElementException("Setor não encontrado: " + idSetor));
            f.setSetor(setor);
        }
        return funcionarioRepository.save(f);
    }

    public List<DadosProjetoDTO> buscarProjetosDoFuncionario(Integer idFuncionario) {
        List<com.example.ac2_237052_237010.models.Projeto> projetos = funcionarioRepository.findProjetosByFuncionarioId(idFuncionario);
        return projetos.stream()
                .map(p -> DadosProjetoDTO.builder()
                        .id(p.getId())
                        .descricao(p.getDescricao())
                        .dataInicio(p.getDataInicio())
                        .dataFim(p.getDataFim())
                        .funcionarios(null)
                        .build())
                .collect(Collectors.toList());
    }
}
