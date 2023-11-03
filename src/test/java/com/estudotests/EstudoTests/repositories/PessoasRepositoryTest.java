package com.estudotests.EstudoTests.repositories;

import com.estudotests.EstudoTests.models.Pessoas;
import jakarta.persistence.EntityManager;
import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.stereotype.Repository;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@ActiveProfiles("test")
class PessoasRepositoryTest {
    @Autowired
    private PessoasRepository pessoasRepository;

    @Autowired
    EntityManager entityManager;

    private Pessoas save(Pessoas pessoas) {
        entityManager.merge(pessoas);
        return pessoas;
    }

    @Test
    void findAllPessoas() {
        Pessoas pessoa = new Pessoas();
        pessoa.setId(1L);
        pessoa.setNome("Nome Teste");
        pessoa.setSobrenome("Sobrenome Teste");
        this.save(pessoa);
        Optional<List<Pessoas>> pessoasOptional = pessoasRepository.findAllPessoas();
        assertThat(pessoasOptional.isPresent()).isTrue();
    }

    @Test
    void findPessoasByid() {
        Pessoas pessoa = new Pessoas();
        pessoa.setId(1L);
        pessoa.setNome("Nome Teste");
        pessoa.setSobrenome("Sobrenome Teste");
        this.save(pessoa);
        Optional<Pessoas> pessoasOptional = pessoasRepository.findPessoasByid(1L);
        assertThat(pessoasOptional.isPresent()).isTrue();
    }
}