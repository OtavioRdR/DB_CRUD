package com.db.pessoas_enderecos.repository;

import com.db.pessoas_enderecos.entity.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PessoaRepository extends JpaRepository<Pessoa, Long> {
}
