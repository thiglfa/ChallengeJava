# **CP de Java — Spring Boot API**

## Autores:
- Eduardo Barriviera — RM 555309
- Thiago Lima Freitas — RM 556795

## Descrição
Este projeto é uma aplicação Java desenvolvida com Spring Boot, utilizando JPA para persistência de dados e o banco de dados em memória H2.

## Tecnologias utilizadas

- Java 17+
- Spring Boot
- Spring Data JPA
- H2 Database
  
## **Endpoints da API**

### - UsuárioController
  
| Método | Endpoint             | Ação                     |
| ------ | -------------------- | ------------------------ |
| POST   | `/api/usuarios`      | Criar novo usuário       |
| GET    | `/api/usuarios/{id}` | Buscar usuário por ID    |
| GET    | `/api/usuarios`      | Listar todos os usuários |
| PUT    | `/api/usuarios/{id}` | Atualizar usuário        |
| DELETE | `/api/usuarios/{id}` | Deletar usuário          |

### - MotoController
  
| Método | Endpoint          | Ação                  |
| ------ | ----------------- | --------------------- |
| POST   | `/api/motos`      | Criar nova moto       |
| GET    | `/api/motos`      | Listar todas as motos |
| GET    | `/api/motos/{id}` | Buscar moto por ID    |
| PUT    | `/api/motos/{id}` | Atualizar moto        |
| DELETE | `/api/motos/{id}` | Deletar moto          |
