# **CP de Java — Spring Boot API**

## Autores:
- Eduardo Barriviera — RM 555309
- Thiago Lima Freitas — RM 556795
- Bruno centurion Fernandes - RM556531


# 🛵 Sistema de Gestão de Motos e Usuários

Este projeto é uma API REST desenvolvida com **Spring Boot** para gerenciamento de **Motos** e **Usuários**, com recursos modernos como **validação com Bean Validation**, **paginação e ordenação**, **filtros dinâmicos**, uso de **DTOs**, **cache** com Caffeine e **tratamento centralizado de erros**.

---

## 🚀 Tecnologias Utilizadas

- Java 17+
- Spring Boot
  - Spring Web
  - Spring Data JPA
  - Spring Validation
  - Spring Cache (Caffeine)
- Banco de dados H2 (pode ser adaptado para outros)
- Maven
- JPA / Hibernate

---

## 📦 Como Rodar o Projeto

1. Clone o repositório:

```bash
git clone https://github.com/seu-usuario/seu-repositorio.git
cd seu-repositorio
```bash
2. Rode o projeto:
./mvnw spring-boot:run

📚 Funcionalidades
🔧 Moto
GET /api/motos – Listar com paginação, ordenação e filtros (modelo, cor)

POST /api/motos – Criar nova moto

PUT /api/motos/{id} – Atualizar moto

DELETE /api/motos/{id} – Remover moto

Validação com Bean Validation

Cache de listagem com Caffeine

👤 Usuário
GET /api/usuarios – Listar com paginação e filtros (nome, email)

POST /api/usuarios – Criar novo usuário

PUT /api/usuarios/{id} – Atualizar usuário

DELETE /api/usuarios/{id} – Remover usuário

Validação de e-mail, nome e senha

Cache de listagem com Caffeine

