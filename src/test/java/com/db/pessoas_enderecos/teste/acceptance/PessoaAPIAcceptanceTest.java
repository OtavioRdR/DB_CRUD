package com.db.pessoas_enderecos.teste.acceptance;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.beans.factory.annotation.Autowired;
import com.db.pessoas_enderecos.repository.PessoaRepository;
import com.db.pessoas_enderecos.entity.Pessoa;
import com.db.pessoas_enderecos.dto.PessoaDTO;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class PessoaAPIAcceptanceTest {

    @LocalServerPort
    private int port;

    @Autowired
    private PessoaRepository pessoaRepository;

    @BeforeEach
    void setUp() {
        // Limpa o banco de dados antes de cada teste
        pessoaRepository.deleteAll();

        // Cria uma pessoa para os testes
        Pessoa pessoa = new Pessoa();
        pessoa.setNome("Nome Teste");
        pessoa.setIdade(25);
        pessoa.setEmail("teste@example.com");
        pessoaRepository.save(pessoa);
    }

    @Test
    void testAtualizarPessoa_Sucesso() {
        String jsonBody = "{\"nome\": \"João Silva\", \"idade\": 30}";

        given()
                .port(port)
                .contentType("application/json")
                .body(jsonBody)
                .when()
                .put("/pessoas/1") // Certifique-se de que o ID corresponde ao que foi salvo
                .then()
                .statusCode(200)
                .body("nome", equalTo("João Silva"))
                .body("idade", equalTo(30));
    }

    @Test
    void testAtualizarPessoa_FalhaPessoaNaoEncontrada() {
        String jsonBody = "{\"nome\": \"João Silva\", \"idade\": 30}";

        given()
                .port(port)
                .contentType("application/json")
                .body(jsonBody)
                .when()
                .put("/pessoas/999") // ID que não existe
                .then()
                .statusCode(404)
                .body("message", equalTo("Pessoa com ID 999 não encontrada"));
    }
}