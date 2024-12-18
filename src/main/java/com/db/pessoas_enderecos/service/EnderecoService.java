package com.db.pessoas_enderecos.service;

import com.db.pessoas_enderecos.dto.EnderecoDTO;
import com.db.pessoas_enderecos.entity.Endereco;
import com.db.pessoas_enderecos.entity.Pessoa;
import com.db.pessoas_enderecos.exception.ResourceNotFoundException;
import com.db.pessoas_enderecos.repository.EnderecoRepository;
import com.db.pessoas_enderecos.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EnderecoService {

    @Autowired
    private EnderecoRepository enderecoRepository;

    @Autowired
    private PessoaRepository pessoaRepository;

    // Criar um novo endereço a partir de um DTO
    public Endereco criarEndereco(EnderecoDTO enderecoDTO) {
        // Buscar a pessoa pelo ID
        Pessoa pessoa = pessoaRepository.findById(enderecoDTO.getPessoaId())
                .orElseThrow(() -> new ResourceNotFoundException("Pessoa não encontrada com id: " + enderecoDTO.getPessoaId()));

        // Criar o endereço e associar a pessoa
        Endereco endereco = new Endereco();
        endereco.setLogradouro(enderecoDTO.getLogradouro());
        endereco.setNumero(enderecoDTO.getNumero());
        endereco.setCidade(enderecoDTO.getCidade());
        endereco.setEstado(enderecoDTO.getEstado());
        endereco.setPessoa(pessoa);

        return enderecoRepository.save(endereco);
    }

    // Listar todos os endereços
    public List<Endereco> listarEnderecos() {
        return enderecoRepository.findAll();
    }

    // Listar endereços por ID da pessoa
    public List<Endereco> listarEnderecosPorPessoaId(Long pessoaId) {
        return enderecoRepository.findByPessoaId(pessoaId);
    }

    // Buscar um endereço pelo ID
    public Endereco buscarEnderecoPorId(Long id) {
        return enderecoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Endereço não encontrado com id: " + id));
    }

    // Deletar um endereço pelo ID
    public void deletarEndereco(Long id) {
        if (!enderecoRepository.existsById(id)) {
            throw new ResourceNotFoundException("Endereço não encontrado com id: " + id);
        }
        enderecoRepository.deleteById(id);
    }
}
