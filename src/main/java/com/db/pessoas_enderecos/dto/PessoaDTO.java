package com.db.pessoas_enderecos.dto;

import jakarta.validation.constraints.NotNull;

public class PessoaDTO {

    @NotNull
    private String nome;

    @NotNull
    private Integer idade;

    @NotNull
    private String email;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getIdade() {
        return idade;
    }

    public void setIdade(Integer idade) {
        this.idade = idade;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
