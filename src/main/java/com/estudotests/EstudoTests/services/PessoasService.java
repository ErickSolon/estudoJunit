package com.estudotests.EstudoTests.services;

import com.estudotests.EstudoTests.models.Pessoas;
import com.estudotests.EstudoTests.repositories.PessoasRepository;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PessoasService {
    private final PessoasRepository pessoasRepository;

    public Optional<List<Pessoas>> findAll() {
        var pessoas = pessoasRepository.findAllPessoas();
        return pessoas;
    }

    @SneakyThrows
    public Optional<Pessoas> findById(Long id) {
       var pessoa = pessoasRepository.findPessoasByid(id).orElseThrow(() -> new Exception("Pessoa não encontrada"));
       return Optional.ofNullable(pessoa);
    }

    public Pessoas save(Pessoas pessoas) {
        var pessoaCriada = pessoasRepository.save(pessoas);
        return pessoaCriada;
    }
}
