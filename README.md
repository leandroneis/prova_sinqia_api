
# Prova Sinqia API
> Sistema de cadastro de participantes.

O sistema permite efetuar cadastro de participante no sistema.

### Detalhes da API RESTful
A API RESTful contém as seguintes características:  
* Projeto criado com Spring Boot e Java 8
* Banco de dados MySQL com JPA e Spring Data JPA
* Autenticação e autorização com Spring Security e tokens JWT (JSON Web Token)
* Migração de banco de dados com Flyway

### Como executar a aplicação
Certifique-se de ter o Maven instalado e adicionado ao PATH de seu sistema operacional.
```
Abrir o projeto e executar o comando mvn spring-boot:run
```

## Endpoints

No link está a relação de todos os endpoints.
[Postman Docs](https://documenter.getpostman.com/view/2925386/TVzXDG49) 



## Banco de Dados
Foi utilizado o banco de dados Mysql. Para rodar o sistema necessário existir o usuário: root e a senha: root.
Se desejar abra o projeto e altere no arquivo application.properties os campos:
 - spring.datasource.username=root
 - spring.datasource.password=root