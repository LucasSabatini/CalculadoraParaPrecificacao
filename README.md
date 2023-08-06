<h1 align="center">
  Calculadora para Precificação de Produtos e de Gastos com Matérias-Primas
</h1>

<p align="center">
 <img src="https://img.shields.io/static/v1?label=LinkedIn&message=@lucas-frsabatini&color=0e76a8&labelColor=000000" alt="@lucas-fsabatini"/>
</p>

Este repósitorio foi criado com o propósito de auto-aperfeiçoamento no desenvolvimento de projetos em Java.

O projeto é uma API desenvolvida com o objetivo de fornecer uma interface para o cálculo realizado na **precificação de produtos** para posterior venda e para o cálculo de **gastos com as matérias-primas** utilizadas em seus produtos.
#
A função de cálculo dos gastos com matérias-primas está concluída no backend, mas o intuito é fornecer uma interface de frontend que será desenvolvida futuramente. Esta função tem a capacidade de organizar, em um banco de dados, as matérias-primas adicionadas pelo usuário com o cálculo do gasto final já incluso para cada uma.

São necessários o nome, o preço pago na matéria-prima, o peso usado da matéria-prima na sua receita e o peso total comprado de matéria-prima. Com estas informações, será feito o cálculo equivalente ao gasto desta matéria-prima usada em cada produto e retornado ao usuário, enquanto também é armazenada em seu banco de dados exclusivo.

Esta API fornece as principais operações de Criação, Leitura, Atualização e Exclusão (CRUD) no banco de dados para cada matéria-prima, além de uma serviço de segurança e autenticação.
#
A função de cálculo final para a precificação de um produto ainda não está concluída, mas já está em desenvolvimento. A ideia é semelhante à função relacionada às matérias-primas. Entretanto, cada produto poderá ter uma lista de matérias-primas que o constituem e a ideia é incluir no preço final os gastos administrativos, o percentual de lucro desejado, além de todos os gastos de produção, para que seja retornado ao usuário o preço final recomendado com base nas necessidades de cada usuário.

## Tecnologias
 
- [Spring Boot](https://spring.io/projects/spring-boot)
- [Spring MVC](https://docs.spring.io/spring-framework/reference/web/webmvc.html)
- [Spring Data JPA](https://spring.io/projects/spring-data-jpa)
- [SpringDoc OpenAPI 3](https://springdoc.org/v2/#spring-webflux-support)
- [MySQL](https://dev.mysql.com/downloads/)
- [Lombok](https://projectlombok.org/)
- [JWT](https://jwt.io/introduction)

## Práticas adotadas

- SOLID, DRY, YAGNI, KISS
- API REST
- Consultas com Spring Data JPA
- Injeção de Dependências
- Tratamento de respostas de erro
- Geração automática do Swagger com a OpenAPI 3
- Lombok para redução de código boilerplate
- JSON Web Tokens (JWT) para autenticação e autorização de cada usuário

## Como Executar

- Clonar repositório git
- Construir o projeto:
```
$ ./mvnw clean package
```
- Executar a aplicação:
```
$ java -jar target/todolist-0.0.1-SNAPSHOT.jar
```

A API poderá ser acessada em [localhost:8080](http://localhost:8080).
O Swagger poderá ser visualizado em [localhost:8080/swagger-ui.html](http://localhost:8080/swagger-ui.html)

## API Endpoints

Para fazer as requisições HTTP abaixo, foi utilizada a ferramenta [postman](https://www.postman.com/):

# (ATENÇÃO: colocar prints do postman com os métodos abaixo)
- Criar Tarefa
```
POST
```

- Listar Tarefas
```
GET
```

- Atualizar Tarefa
```
UPDATE
```

- Remover Tarefa
```
DELETE
```