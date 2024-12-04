package com.db.pessoas_enderecos.teste;

import com.db.pessoas_enderecos.controller.PessoaController;
import com.db.pessoas_enderecos.entidade.Pessoa;
import com.db.pessoas_enderecos.repository.PessoaRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.time.LocalDate;
import java.util.Collections;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(PessoaController.class)
public class PessoaControllerTestes {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private PessoaRepository pessoaRepository;

    @BeforeEach
    public void setUp() {
        when(pessoaRepository.findAll()).thenReturn(Collections.emptyList());
    }

    @Test
    public void testCriarPessoa() throws Exception {
        String pessoaJson = "{\n" +
                "    \"nome\": \"Ana\",\n" +
                "    \"cpf\": \"12345678900\",\n" +
                "    \"dataNascimento\": \"1995-01-01\"\n" +
                "}";

        Pessoa pessoa = new Pessoa("Ana", "12345678900", LocalDate.of(1995, 1, 1), null);
        when(pessoaRepository.save(any(Pessoa.class))).thenReturn(pessoa);

        mockMvc.perform(post("/pessoas")
                        .contentType("application/json")
                        .content(pessoaJson))
                .andExpect(status().isCreated())
                .andExpect(MockMvcResultMatchers.jsonPath("$.nome").value("Ana"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.cpf").value("12345678900"));
    }

    @Test
    public void testListarPessoas() throws Exception {
        Pessoa pessoa = new Pessoa("Carlos", "12345678901", LocalDate.of(1990, 5, 15), null);
        when(pessoaRepository.findAll()).thenReturn(Collections.singletonList(pessoa));

        mockMvc.perform(get("/pessoas"))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].nome").value("Carlos"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].cpf").value("12345678901"));
    }
}
