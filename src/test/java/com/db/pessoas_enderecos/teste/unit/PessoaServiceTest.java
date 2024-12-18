package com.db.pessoas_enderecos.teste.unit;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import com.db.pessoas_enderecos.dto.PessoaDTO;
import com.db.pessoas_enderecos.entity.Pessoa;
import com.db.pessoas_enderecos.service.PessoaService;
import com.db.pessoas_enderecos.repository.PessoaRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import java.util.Optional;
import com.db.pessoas_enderecos.exception.PessoaNaoEncontradaException;

class PessoaServiceTest {

    @InjectMocks
    private PessoaService pessoaService;

    @Mock
    private PessoaRepository pessoaRepository;

    PessoaServiceTest() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testAtualizarPessoa_Sucesso() {
        Long pessoaId = 1L;
        PessoaDTO pessoaDTO = new PessoaDTO();
        pessoaDTO.setNome("João Silva");
        pessoaDTO.setEmail("joao.silva@example.com");


        Pessoa pessoaMock = new Pessoa();
        pessoaMock.setId(pessoaId);
        pessoaMock.setNome("Nome Original");
        pessoaMock.setEmail("email.original@example.com");

        when(pessoaRepository.findById(pessoaId)).thenReturn(Optional.of(pessoaMock));
        when(pessoaRepository.save(any())).thenReturn(pessoaMock);


        Pessoa resultado = pessoaService.atualizarPessoa(pessoaId, pessoaDTO);

        assertEquals("Otavio Rosa", resultado.getNome());
        assertEquals("otavio.rosa@example.com", resultado.getEmail());

        verify(pessoaRepository, times(1)).save(any());
    }

    @Test
    void testAtualizarPessoa_FalhaPessoaNaoEncontrada() {
        Long pessoaId = 1L;
        PessoaDTO pessoaDTO = new PessoaDTO();
        pessoaDTO.setNome("João Silva");
        pessoaDTO.setEmail("joao.silva@example.com");

        when(pessoaRepository.findById(pessoaId)).thenReturn(Optional.empty());

        assertThrows(PessoaNaoEncontradaException.class, () -> pessoaService.atualizarPessoa(pessoaId, pessoaDTO));
    }
}
