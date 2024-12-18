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
        pessoaDTO.setNome("João Silva");
        pessoaDTO.setEmail("joao.silva@example.com");
    }

    @Test
    void testAtualizarPessoa() {
        // Crie a instância de Pessoa para retornar do mock
        Pessoa pessoaMock = new Pessoa();
        pessoaMock.setId(pessoaId);
        pessoaMock.setNome("João Silva");
        pessoaMock.setIdade(30); // Defina a idade

        // Configurando o mock para o método atualizarPessoa
        when(pessoaService.atualizarPessoa(eq(pessoaId), any())).thenReturn(pessoaMock);

        // Chamada ao método no controller
        ResponseEntity<Pessoa> response = pessoaController.atualizarPessoa(pessoaId, pessoaDTO);

        // Verificar se o código de resposta é 200 (OK)
        assertEquals(200, response.getStatusCode().value());

        // Verificar se a pessoa retornada é a esperada
        Pessoa pessoaRetornada = response.getBody();
        assertNotNull(pessoaRetornada);
        assertEquals(pessoaId, pessoaRetornada.getId());
        assertEquals("João Silva", pessoaRetornada.getNome());
        assertEquals(30, pessoaRetornada.getIdade()); // Verificando a idade

        // Verifique se o serviço foi chamado com os parâmetros corretos
        verify(pessoaService, times(1)).atualizarPessoa(eq(pessoaId), any());
    }
}
