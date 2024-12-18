package com.db.pessoas_enderecos.controller;

import com.db.pessoas_enderecos.entity.Endereco;
import com.db.pessoas_enderecos.dto.EnderecoDTO;
import com.db.pessoas_enderecos.service.EnderecoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/enderecos")
public class EnderecoController {

    @Autowired
    private EnderecoService enderecoService;

    @GetMapping("/{id}")
    public ResponseEntity<Endereco> buscarEnderecoPorId(@PathVariable Long id) {
        Endereco endereco = enderecoService.buscarEnderecoPorId(id);
        return ResponseEntity.ok(endereco);
    }

    @PostMapping
    public ResponseEntity<Endereco> adicionarEndereco(@RequestBody EnderecoDTO enderecoDTO) {
        Endereco enderecoSalvo = enderecoService.criarEndereco(enderecoDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(enderecoSalvo);
    }
}
