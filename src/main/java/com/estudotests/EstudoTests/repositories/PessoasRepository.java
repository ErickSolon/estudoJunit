package com.estudotests.EstudoTests.repositories;

import com.estudotests.EstudoTests.models.Pessoas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface PessoasRepository extends JpaRepository<Pessoas, Long> {
    @Query(nativeQuery = true, value = "SELECT * FROM pessoas")
    Optional<List<Pessoas>> findAllPessoas();

    @Query(nativeQuery = true, value = "SELECT * FROM pessoas WHERE id = ?1")
    Optional<Pessoas> findPessoasByid(Long id);
}
