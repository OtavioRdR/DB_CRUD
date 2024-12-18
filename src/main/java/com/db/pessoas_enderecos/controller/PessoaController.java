package com.db.pessoas_enderecos.controller;

import com.db.pessoas_enderecos.dto.PessoaDTO;
import com.db.pessoas_enderecos.entity.Pessoa;
import com.db.pessoas_enderecos.service.PessoaService;
import com.db.pessoas_enderecos.exception.PessoaNaoEncontradaException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pessoas")
public class PessoaController {

    @Autowired
    private PessoaService pessoaService;

    // Criar pessoa
    @PostMapping
    public ResponseEntity<Pessoa> criarPessoa(@RequestBody @Valid PessoaDTO pessoaDTO) {
        Pessoa pessoa = pessoaService.criarPessoa(pessoaDTO);
        return ResponseEntity.ok(pessoa);
    }

    // Listar todas as pessoas
    @GetMapping
    public List<Pessoa> listarPessoas() {
        return pessoaService.listarPessoas();
    }

    // Buscar pessoa por ID
    @GetMapping("/{id}")
    public ResponseEntity<Pessoa> buscarPessoaPorId(@PathVariable Long id) {
        return pessoaService.buscarPessoaPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Atualizar pessoa
    @PutMapping("/{id}")
    public ResponseEntity<Pessoa> atualizarPessoa(@PathVariable Long id, @RequestBody @Valid PessoaDTO pessoaDTO) {
        Pessoa pessoaAtualizada = pessoaService.atualizarPessoa(id, pessoaDTO);
        return ResponseEntity.ok(pessoaAtualizada);
    }
}
