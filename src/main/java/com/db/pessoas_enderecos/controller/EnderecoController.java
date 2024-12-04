package com.db.pessoas_enderecos.controller;

import com.db.pessoas_enderecos.entidade.Endereco;
import com.db.pessoas_enderecos.repository.EnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/enderecos")
public class EnderecoController {

    @Autowired
    private EnderecoRepository enderecoRepository;

    @PostMapping
    public ResponseEntity<Endereco> criarEndereco(@RequestBody Endereco endereco) {
        return ResponseEntity.status(201).body(enderecoRepository.save(endereco));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Endereco> atualizarEndereco(@PathVariable long id, @RequestBody Endereco endereco) {
        return enderecoRepository.findById(id)
                .map(e -> {
                    e.setRua(endereco.getRua());
                    e.setNumero(endereco.getNumero());
                    e.setBairro(endereco.getBairro());
                    e.setCidade(endereco.getCidade());
                    e.setEstado(endereco.getEstado());
                    e.setCep(endereco.getCep());
                    return ResponseEntity.ok(enderecoRepository.save(e));
                })
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluirEndereco(@PathVariable long id) {
        return enderecoRepository.findById(id)
                .map(e -> {
                    enderecoRepository.delete(e);
                    return ResponseEntity.noContent().<Void>build();
                })
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
}
