<h1 align="center">
  Calculadora para Precificação de Produtos e de Gastos com Matérias-Primas
</h1>

<p align="center">
 <img src="https://img.shields.io/static/v1?label=LinkedIn&message=@lucas-frsabatini&color=0e76a8&labelColor=000000" alt="@lucas-fsabatini"><br/>
 <img alt="Docker Pulls" src="https://img.shields.io/docker/pulls/lucassabatini/calculadora_precificacao?label=Docker Pulls">
</p>

O projeto é uma API desenvolvida com o objetivo de fornecer uma interface para o cálculo realizado na **precificação de produtos** para posterior venda e para o cálculo de **gastos com as matérias-primas** utilizadas em seus produtos.
#
Ela fornece as principais operações de Criação, Leitura, Atualização e Exclusão (CRUD) no banco de dados para cada matéria-prima, além de um serviço de segurança com autorização e autenticação para os usuários cadastrados.

## Tecnologias
 
- [Spring Boot](https://spring.io/projects/spring-boot)
- [Spring MVC](https://docs.spring.io/spring-framework/reference/web/webmvc.html)
- [Spring Data JPA](https://spring.io/projects/spring-data-jpa)
- [Spring Security](https://spring.io/projects/spring-security) e [JWT](https://jwt.io/introduction)
- [MySQL](https://dev.mysql.com/downloads/)
- [Lombok](https://projectlombok.org/)
- [Swagger OpenAPI](https://swagger.io/resources/open-api/)

## Práticas adotadas

- API RESTful
- Consultas com Spring Data JPA
- Injeção de Dependências
- Tratamento de respostas de erro
- Lombok para redução de código boilerplate
- Registro e Autenticação de usuários com Spring Security e JSON Web Tokens (JWT)
- Content Negotiation para a produção e consumo de dados nos formatos JSON, XML e YMAL
- Hypermedia As the Engine Of Application State (HATEOAS)
- Documentação com Swagger OpenAPI

## Como Executar

### Docker

*Caso possua o Docker instalado, você pode baixar apenas o arquivo compose.yml e executar os comando abaixo:*

- Entre no diretório em que salvou o arquivo compose.yml
- Abra o terminal e digite:
```
docker compose up -d
```

- Aguarde até a inicialização estar completa. Você pode conferir com o comando:
```
docker ps -a
```
- Quando as portas estiverem setadas, será possível utilizar a aplicação na porta 80 e o banco de dados na porta 3308.
- Você pode conferir mais informações de acesso no próprio arquivo compose.yml e informações sobre a API na UI do Swagger acessando:
```
http://localhost/swagger-ui/index.html
```

### Maven

*Não se esqueça de configurar o arquivo application.properties com as informações do seu banco de dados.*

- Clonar repositório git
- Entrar na pasta "/CalculadoraPrecificacaoPC/"
- Construir o projeto:
```
./mvnw clean package
```
- Executar a aplicação:
```
java -jar target/CalculadoraPrecificacaoPC-1.0.jar
```

- Caso tenha o Apache Maven instalado e configurado, você pode apenas clonar o repositório e executar diretamente através do comando:

```
mvn spring-boot:run
```

## API Endpoints

Para fazer as requisições HTTP abaixo, foi utilizada a ferramenta [Postman](https://www.postman.com/). Na pasta [PostmanCollections](https://github.com/LucasSabatini/CalculadoraParaPrecificacao/tree/master/PostmanCollections), você irá encontrar o arquivo para a Collection e outro para o Environment, ambos no formato JSON, com todas as requisições já prontas para uso, apenas importe-as no seu Postman.
A autenticação é feita através do endpoint /auth/api/register que retornará um Token a ser autenticado através do endpoint /auth/api/authenticate. Após isso, o token será setado automaticamente como uma variável do Postman a ser utilizado em todas as requisições realizadas. Caso haja algum erro, confira a aba Authorization do Postman e selecione a opção Bearer Token caso não esteja selecionada:

### Camada de Usuário

*Confira as respostas das requisições retornando o status 2xx (sucesso)*

- Registrar Usuário

<img src="https://github.com/LucasSabatini/CalculadoraParaPrecificacao/blob/master/RecursosPostman/RegisterUser.png">

- Autenticar Usuário

<img src="https://github.com/LucasSabatini/CalculadoraParaPrecificacao/blob/master/RecursosPostman/AuthenticateUser.png">

- Consultar Todos os Usuários

<img src="https://github.com/LucasSabatini/CalculadoraParaPrecificacao/blob/master/RecursosPostman/GetAllUsers.png">

- Atualizar Usuário

<img src="https://github.com/LucasSabatini/CalculadoraParaPrecificacao/blob/master/RecursosPostman/UpdateUser.png">

- Remover Usuário

<img src="https://github.com/LucasSabatini/CalculadoraParaPrecificacao/blob/master/RecursosPostman/DeleteUser.png">

### Camada das Matérias-Primas

- Nova Matéria-Prima

<img src="https://github.com/LucasSabatini/CalculadoraParaPrecificacao/blob/master/RecursosPostman/AddRawMaterial.png">

- Consultar Todas as Matérias-Primas

<img src="https://github.com/LucasSabatini/CalculadoraParaPrecificacao/blob/master/RecursosPostman/GetAllRawMaterials.png">

- Consultar as Matérias-Primas do Usuário logado

<img src="https://github.com/LucasSabatini/CalculadoraParaPrecificacao/blob/master/RecursosPostman/GetAllRawMaterialsOfUser.png">

- Consultar Matéria-Prima por Id

- <img src="https://github.com/LucasSabatini/CalculadoraParaPrecificacao/blob/master/RecursosPostman/GetRawMaterialById.png">

- Atualizar Matéria-Prima

<img src="https://github.com/LucasSabatini/CalculadoraParaPrecificacao/blob/master/RecursosPostman/UpdateRawMaterial.png">

- Remover Matéria-Prima

<img src="https://github.com/LucasSabatini/CalculadoraParaPrecificacao/blob/master/RecursosPostman/DeleteRawMaterial.png">
