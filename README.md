# 🧑‍🤝‍🧑 Pessoas e Endereços API

Uma API RESTful para gerenciar pessoas e seus endereços, desenvolvida com Spring Boot e Hibernate. Este projeto permite criar, ler, atualizar e excluir informações sobre pessoas e seus endereços.

## 🚀 Funcionalidades

- **Criar Pessoa**: Adicione novas pessoas ao sistema.
- **Listar Pessoas**: Recupere uma lista de todas as pessoas cadastradas.
- **Buscar Pessoa por ID**: Encontre uma pessoa específica usando seu ID.
- **Atualizar Pessoa**: Modifique as informações de uma pessoa existente.
- **Excluir Pessoa**: Remova uma pessoa do sistema.

## 🛠️ Tecnologias Utilizadas

- [Spring Boot](https://spring.io/projects/spring-boot) - Framework para desenvolvimento de aplicações Java.
- [Hibernate](https://hibernate.org/) - ORM para mapeamento objeto-relacional.
- [H2 Database](https://www.h2database.com/) - Banco de dados em memória para testes.
- [JUnit](https://junit.org/junit5/) - Framework para testes unitários.
- [Rest Assured](https://rest-assured.io/) - Biblioteca para testes de APIs REST.

## 📦 Instalação

1. **Clone o repositório**:
   ```bash
   git clone https://github.com/OtavioRdR/pessoas-enderecos.git
Navegue até o diretório do projeto:

cd pessoas-enderecos

Compile o projeto:

./mvnw clean install

Execute a aplicação:

./mvnw spring-boot:run

📖 Uso
A API está disponível em http://localhost:8080/pessoas. Aqui estão alguns exemplos de como usar a API:

Criar uma nova pessoa

curl -X POST http://localhost:8080/pessoas \
-H "Content-Type: application/json" \
-d '{"nome": "João Silva", "idade": 30, "email": "joao@example.com"}'
curl -X GET http://localhost:8080/pessoas

Buscar uma pessoa por ID

curl -X GET http://localhost:8080/pessoas/1

Atualizar uma pessoa

curl -X PUT http://localhost:8080/pessoas/1 \
-H "Content-Type: application/json" \
-d '{"nome": "João Silva", "idade": 31, "email": "joao.novo@example.com"}'


Excluir uma pessoa

curl -X DELETE http://localhost:8080/pessoas/1


🧪 Testes
Para executar os testes, use o seguinte comando:

./mvnw test

📄 Licença
Este projeto está licenciado sob a MIT License.

🤝 Contribuições
Contribuições são bem-vindas! Sinta-se à vontade para abrir uma issue ou enviar um pull request.

📫 Contato
Se você tiver alguma dúvida ou sugestão, entre em contato:

Seu Nome - seu-email@example.com
GitHub - seu-usuario
