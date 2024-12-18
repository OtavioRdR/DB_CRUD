package com.db.pessoas_enderecos.teste.integration;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import com.db.pessoas_enderecos.controller.PessoaController;
import com.db.pessoas_enderecos.dto.PessoaDTO;
import com.db.pessoas_enderecos.entity.Pessoa;
import com.db.pessoas_enderecos.service.PessoaService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;
import org.springframework.http.ResponseEntity;

public class PessoaControllerTest {

    @Mock
    private PessoaService pessoaService;

    @InjectMocks
    private PessoaController pessoaController;

    private Long pessoaId;
    private PessoaDTO pessoaDTO;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        pessoaId = 1L;
        pessoaDTO = new PessoaDTO();
        pessoaDTO.setNome("Otavio Rosa");
        pessoaDTO.setEmail("otavio.rosa@example.com");
    }

    @Test
    void testAtualizarPessoa() {
        Pessoa pessoaMock = new Pessoa();
        pessoaMock.setId(pessoaId);
        pessoaMock.setNome("Otavio Rosa");
        pessoaMock.setIdade(30);

        when(pessoaService.atualizarPessoa(eq(pessoaId), any())).thenReturn(pessoaMock);

        ResponseEntity<Pessoa> response = pessoaController.atualizarPessoa(pessoaId, pessoaDTO);

        assertEquals(200, response.getStatusCode().value());

        Pessoa pessoaRetornada = response.getBody();
        assertNotNull(pessoaRetornada);
        assertEquals(pessoaId, pessoaRetornada.getId());
        assertEquals("Otavio Rosa", pessoaRetornada.getNome());
        assertEquals(30, pessoaRetornada.getIdade()); // Verificando a idade

        verify(pessoaService, times(1)).atualizarPessoa(eq(pessoaId), any());
    }
}
