# 📦 Pessoas Endereços - CRUD de Pessoas 🏢

Este projeto foi desenvolvido pela **DB** para gerenciar informações de pessoas e seus respectivos endereços de maneira simples e eficiente. Utilizando o poderoso framework **Spring Boot**, criamos uma API RESTful que permite gerenciar dados de pessoas de forma ágil e organizada. O banco de dados utilizado é o **H2**, ideal para testes e desenvolvimento rápido. 

Com este sistema, a **DB** busca otimizar o gerenciamento de dados, oferecendo uma interface simples e funcional para operações básicas de CRUD (Criar, Ler, Atualizar e Deletar).

## 🚀 Funcionalidades

O sistema oferece um **CRUD completo** para gerenciamento de pessoas. As principais operações são:

- **Listar Pessoas**: Retorna todas as pessoas cadastradas no sistema.
- **Criar Pessoa**: Permite a criação de uma nova pessoa no banco de dados.
- **Atualizar Pessoa**: Atualiza as informações de uma pessoa já cadastrada.
- **Excluir Pessoa**: Deleta uma pessoa do banco de dados.

## ⚙️ Tecnologias Usadas

Este projeto foi construído utilizando as seguintes tecnologias:

- **Spring Boot 3.x**: Framework robusto para desenvolvimento de aplicações Java.
- **Spring Data JPA**: Para manipulação de dados com Hibernate.
- **H2 Database**: Banco de dados em memória, ideal para testes e desenvolvimento rápido.
- **Maven**: Gerenciador de dependências e build automation.
- **JUnit**: Ferramenta para testes automatizados, garantindo a qualidade do código.

## 🔧 Como Rodar o Projeto

### Pré-requisitos

Antes de rodar o projeto, é necessário ter os seguintes programas instalados em sua máquina:

- **JDK 23** ou superior.
- **Maven** (para gerenciar dependências e executar o projeto).

### Passos

Siga os passos abaixo para rodar o projeto localmente:

1. **Clone o repositório** para o seu ambiente local:
   ```bash
   git clone https://github.com/seu-usuario/pessoas-enderecos.git
Entre no diretório do projeto:

bash
Copiar código
cd pessoas-enderecos
Compile e execute o projeto utilizando o Maven:

bash
Copiar código
mvn spring-boot:run
Acesse a API através do endereço http://localhost:8080/pessoas.

🖥️ Testando o CRUD
Após rodar o projeto, você pode testar as funcionalidades utilizando ferramentas como Postman ou Insomnia. Aqui estão as rotas disponíveis na API:

GET /pessoas
Retorna todas as pessoas cadastradas no sistema.

POST /pessoas
Cria uma nova pessoa. Você precisa enviar um corpo da requisição com as informações da pessoa, como nome, CPF e data de nascimento.

PUT /pessoas/{id}
Atualiza as informações de uma pessoa existente. Informe o id da pessoa e o corpo da requisição com as novas informações.

DELETE /pessoas/{id}
Deleta uma pessoa pelo id.

Exemplo de Uso com Postman:
Criar Pessoa:
Método: POST
URL: http://localhost:8080/pessoas
Corpo (JSON):

json
Copiar código
{
    "nome": "João Silva",
    "cpf": "123.456.789-00",
    "dataNascimento": "1990-05-15"
}
Atualizar Pessoa:
Método: PUT
URL: http://localhost:8080/pessoas/1
Corpo (JSON):

json
Copiar código
{
    "nome": "João Silva Atualizado",
    "cpf": "123.456.789-00",
    "dataNascimento": "1990-05-15"
}
Excluir Pessoa:
Método: DELETE
URL: http://localhost:8080/pessoas/1

🎨 Melhorias Futuras
Embora o projeto já seja funcional, há várias melhorias que podem ser implementadas no futuro:

Validações de Entrada: Garantir que os dados inseridos sejam válidos e consistentes.
Segurança: Implementar autenticação e autorização para proteger a API.
Banco de Dados Real: Integrar com um banco de dados real, como MySQL ou PostgreSQL, em vez de usar o banco em memória H2.
Interface de Usuário: Desenvolver uma interface gráfica para facilitar a interação com o sistema.
🧑‍💻 Contribuições
Este projeto é mantido pela equipe da DB, mas estamos abertos a contribuições! Se você deseja melhorar este sistema ou corrigir algum erro, siga estas etapas:

Faça um fork deste repositório.
Crie uma nova branch (git checkout -b nova-feature).
Realize as mudanças e faça o commit delas (git commit -am 'Adiciona nova feature').
Envie o pull request.
Todas as contribuições são bem-vindas, seja para melhorar a performance, segurança ou usabilidade do sistema.

📧 Contato
Se você tiver dúvidas ou quiser discutir sobre o projeto, entre em contato com a equipe de desenvolvimento da DB:

Email: suporte@db.com
GitHub: https://github.com/seu-usuario/pessoas-enderecos
A equipe DB está sempre disponível para ajudar e discutir novas ideias! Vamos crescer juntos! 💡🚀

markdown
Copiar código

### O que foi adicionado:
1. **Menção à DB**: A empresa foi mencionada em diversas partes, destacando a autoria do projeto.
2. **Explicações detalhadas**: Adicionei informações sobre como testar o CRUD com exemplos de uso no Postman.
3. **Exemplo de corpo de requisição**: Para facilitar o uso, há exemplos de JSON para os métodos `POST` e `PUT`.
4. **Melhorias Futuras**: Menção a melhorias possíveis, como a adição de validações e a troca do banco de dados.
5. **Contribuições**: Como contribuir com o projeto, com explicações sobre como fazer um fork, criar branches, e enviar pull requests.
6. **Contato**: Informações fictícias para contato, caso necessário.

### Como usar:
1. Crie o arquivo `README.md` no diretório raiz do seu projeto.
2. Cole o conteúdo acima.
3. Salve o arquivo.
4. Adicione, commit e envie o arquivo para o seu repositório GitHub:

```bash
git add README.md
git commit -m "Adiciona README com detalhes do projeto"
git push origin main
