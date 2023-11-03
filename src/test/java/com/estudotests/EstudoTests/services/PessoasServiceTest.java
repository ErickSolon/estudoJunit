package com.estudotests.EstudoTests.services;

import com.estudotests.EstudoTests.models.Pessoas;
import com.estudotests.EstudoTests.repositories.PessoasRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.context.ActiveProfiles;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
@ActiveProfiles("test")
class PessoasServiceTest {

    @Mock
    PessoasRepository pessoasRepository;

    @InjectMocks
    PessoasService pessoasService;

    @Test
    void save() throws Exception {
        Pessoas pessoa = new Pessoas();
        pessoa.setId(1L);
        pessoa.setNome("Nome Teste");
        pessoa.setSobrenome("Sobrenome Teste");

        // Chama o método save do service
        pessoasService.save(pessoa);

        // Verifica se o método save do repository foi chamado exatamente uma vez com a pessoa correta
        verify(pessoasRepository, times(1)).save(pessoa);
    }
}
