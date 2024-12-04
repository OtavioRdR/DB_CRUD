package com.db.pessoas_enderecos.entity;

import com.db.pessoas_enderecos.enderecos.DadosEndereco;

public record DadosDasPessoas(String nome, String id, String dataNascimento, String cpf, DadosEndereco endereco) {
}
