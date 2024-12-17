package com.db.pessoas_enderecos.service;

import com.db.pessoas_enderecos.dto.PessoaDTO;
import com.db.pessoas_enderecos.entity.Pessoa;
import  com.db.pessoas_enderecos.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PessoaService {

    @Autowired
    private PessoaRepository pessoaRepository;

    public Pessoa criarPessoa(PessoaDTO pessoaDTO) {
        Pessoa pessoa = new Pessoa();
        pessoa.setNome(pessoaDTO.getNome());
        pessoa.setEmail(pessoaDTO.getEmail());
        return pessoaRepository.save(pessoa);
    }

    public List<Pessoa> listarPessoas() {
        return pessoaRepository.findAll();
    }

    public Optional<Pessoa> buscarPessoaPorId(Long id) {
        return pessoaRepository.findById(id);
    }
}
