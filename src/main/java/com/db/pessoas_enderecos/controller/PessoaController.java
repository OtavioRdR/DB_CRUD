package com.db.pessoas_enderecos.controller;

import com.db.pessoas_enderecos.entidade.Pessoa;
import com.db.pessoas_enderecos.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pessoas")
public class PessoaController {

    @Autowired
    private PessoaRepository pessoaRepository;

    @GetMapping
    public List<Pessoa> listarPessoas() {
        return pessoaRepository.findAll();
    }

    @PostMapping
    public ResponseEntity<Pessoa> criarPessoa(@RequestBody Pessoa pessoa) {
        return ResponseEntity.status(201).body(pessoaRepository.save(pessoa));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Pessoa> atualizarPessoa(@PathVariable long id, @RequestBody Pessoa pessoa) {
        return pessoaRepository.findById(id)
                .map(p -> {
                    p.setNome(pessoa.getNome());
                    p.setCpf(pessoa.getCpf());
                    p.setDataNascimento(pessoa.getDataNascimento());
                    return ResponseEntity.ok(pessoaRepository.save(p));
                })
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> excluirPessoa(@PathVariable long id) {
        return pessoaRepository.findById(id)
                .map(p -> {
                    System.out.println("Pessoa encontrada: " + p);  // Log para verificar se a pessoa foi encontrada
                    pessoaRepository.delete(p);  // Exclui a pessoa do banco de dados
                    System.out.println("Pessoa deletada");  // Log para confirmar a exclusão
                    return ResponseEntity.noContent().build();  // Retorna 204 No Content
                })
                .orElseGet(() -> {
                    System.out.println("Pessoa não encontrada para o ID: " + id);  // Log para indicar que a pessoa não foi encontrada
                    return ResponseEntity.notFound().build();  // Retorna 404 Not Found
                });
    }
}
