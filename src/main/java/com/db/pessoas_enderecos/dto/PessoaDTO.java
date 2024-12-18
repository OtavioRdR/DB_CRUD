package com.db.pessoas_enderecos.dto;

import jakarta.validation.constraints.NotNull;

public class PessoaDTO {

    @NotNull
    private String nome;

    @NotNull
    private Integer idade;  // O tipo pode ser Integer ou int

    @NotNull
    private String email;  // Adicionando o campo email ao DTO

    // Getters e setters
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
