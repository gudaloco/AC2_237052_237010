package com.example.ac2_237052_237010;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.ac2_237052_237010.models.Funcionario;
import com.example.ac2_237052_237010.models.Projeto;
import com.example.ac2_237052_237010.models.Setor;
import com.example.ac2_237052_237010.repositories.FuncionarioRepository;
import com.example.ac2_237052_237010.repositories.ProjetoRepository;
import com.example.ac2_237052_237010.repositories.SetorRepository;

import java.time.LocalDate;

@SpringBootApplication
public class Ac2237052237010Application {

	public static void main(String[] args) {
		SpringApplication.run(Ac2237052237010Application.class, args);

    }

    @Bean
    CommandLineRunner runner(SetorRepository setorRepository,
                             FuncionarioRepository funcionarioRepository,
                             ProjetoRepository projetoRepository) {
        return args -> {
            Setor s1 = Setor.builder().nome("Desenvolvimento").build();
            Setor s2 = Setor.builder().nome("RH").build();
            setorRepository.save(s1);
            setorRepository.save(s2);

            Funcionario f1 = Funcionario.builder().nome("Ana").setor(s1).build();
            Funcionario f2 = Funcionario.builder().nome("Bruno").setor(s1).build();
            Funcionario f3 = Funcionario.builder().nome("Carla").setor(s2).build();
            funcionarioRepository.save(f1);
            funcionarioRepository.save(f2);
            funcionarioRepository.save(f3);

            Projeto p1 = Projeto.builder()
                    .descricao("Sistema X")
                    .dataInicio(LocalDate.now().minusDays(10))
                    .dataFim(LocalDate.now().plusDays(20))
                    .build();

            Projeto p2 = Projeto.builder()
                    .descricao("Portal Y")
                    .dataInicio(LocalDate.now().minusDays(5))
                    .dataFim(LocalDate.now().plusDays(60))
                    .build();

            p1.getFuncionarios().add(f1);
            p1.getFuncionarios().add(f2);
            p2.getFuncionarios().add(f3);

            // manter relação bidirecional
            f1.getProjetos().add(p1);
            f2.getProjetos().add(p1);
            f3.getProjetos().add(p2);

            projetoRepository.save(p1);
            projetoRepository.save(p2);
        };
    }
}
