package com.db.pessoas_enderecos.repository;

import com.db.pessoas_enderecos.entidade.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EnderecoRepository extends JpaRepository<Endereco, Long> {
}
