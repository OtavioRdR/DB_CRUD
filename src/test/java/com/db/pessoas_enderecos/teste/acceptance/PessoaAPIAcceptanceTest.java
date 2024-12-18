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

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class PessoaAPIAcceptanceTest {

    @LocalServerPort
    private int port;

    @Autowired
    private PessoaRepository pessoaRepository;

    @BeforeEach
    void setUp() {
        pessoaRepository.deleteAll();

        Pessoa pessoa = new Pessoa();
        pessoa.setNome("Nome Teste");
        pessoa.setIdade(25);
        pessoa.setEmail("teste@example.com");
        pessoaRepository.save(pessoa);
    }

    @Test
    void testAtualizarPessoa_Sucesso() {
        String jsonBody = "{\"nome\": \"Otavio Rosa\", \"idade\": 30}";

        given()
                .port(port)
                .contentType("application/json")
                .body(jsonBody)
                .when()
                .put("/pessoas/1")
                .then()
                .statusCode(200)
                .body("nome", equalTo("Otavio Rosa"))
                .body("idade", equalTo(30));
    }

    @Test
    void testAtualizarPessoa_FalhaPessoaNaoEncontrada() {
        String jsonBody = "{\"nome\": \"Otavio Rosa\", \"idade\": 30}";

        given()
                .port(port)
                .contentType("application/json")
                .body(jsonBody)
                .when()
                .put("/pessoas/999")
                .then()
                .statusCode(404)
                .body("message", equalTo("Pessoa com ID 999 não encontrada"));
    }
}