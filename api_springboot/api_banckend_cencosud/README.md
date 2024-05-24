# SQUAD-13
### Projeto da disciplina de Residência em Software II.
---
### Utilização da API

1. Acesse o `src/main/resources/application.properties` e insira a URL, nome de usuário e senha do banco de dados a ser utilizado.
2. Acesse o arquivo `APIBackendCenconcud` na pasta `src/main/java/com/cenconsud/api_backend_cenconsud` e, em seguida, inicie o projeto.
3. Acesse esta URL para verificar o relatório dos métodos CRUD do projeto: http://localhost:8080/swagger-ui.html
4. Insira essas URLs no Postman ou em outro gerenciador de desenvolvimento de API para interagir com o banco de dados cadastrado anteriormente.

---

## Métodos para Consulta e Cadastro

- **POST:** http://localhost:8080/post/products
- **GET:** http://localhost:8080/get/products/{id}
- **GET ALL:** http://localhost:8080/all/products
- **PUT:** http://localhost:8080/put/products/{id}
- **DELETE:** http://localhost:8080/del/products/{id}
