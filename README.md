
# ☕ Challenge Java — Spring Boot API

Este repositório contém o desenvolvimento de uma **API RESTful** com **Spring Boot**, voltada para a gestão de **Motos** e **Usuários**, com recursos modernos como validações, filtros dinâmicos, cache, DTOs e muito mais.

---

## 👨‍💻 Autores

- **Eduardo Barriviera** – RM555309  
- **Thiago Lima Freitas** – RM556795  
- **Bruno Centurion Fernandes** – RM556531  

---

## 🛵 Sistema de Gestão de Motos e Usuários

A API foi projetada para fornecer funcionalidades robustas de CRUD com:

- ✅ **Validação** com Bean Validation  
- 🔍 **Paginação, ordenação e filtros dinâmicos**  
- 🔄 **DTOs (Data Transfer Objects)**  
- ⚡ **Cache de listagem** com Caffeine  
- 🚫 **Tratamento global de exceções**

---

## 🚀 Tecnologias Utilizadas

- **Java 17+**
- **Spring Boot**  
  - Spring Web  
  - Spring Data JPA  
  - Spring Validation  
  - Spring Cache (Caffeine)  
- **Banco de Dados H2** (pode ser adaptado para outros SGBDs)
- **Maven**
- **JPA / Hibernate**

---

## 📦 Como Rodar o Projeto

### 1. Clonar o repositório

```bash
git clone https://github.com/seu-usuario/seu-repositorio.git
cd seu-repositorio
```

### 2. Executar a aplicação

```bash
./mvnw spring-boot:run
```

---

## 📚 Funcionalidades

### 🔧 Motos

- `GET /api/motos`  
  Lista motos com **paginação**, **ordenação** e **filtros** (modelo, cor)

- `POST /api/motos`  
  Cria uma nova moto

- `PUT /api/motos/{id}`  
  Atualiza uma moto existente

- `DELETE /api/motos/{id}`  
  Remove uma moto

- ✅ Validação com Bean Validation  
- ⚡ Cache de listagem com Caffeine  

---

### 👤 Usuários

- `GET /api/usuarios`  
  Lista usuários com **paginação** e **filtros** (nome, email)

- `POST /api/usuarios`  
  Cria um novo usuário

- `PUT /api/usuarios/{id}`  
  Atualiza um usuário

- `DELETE /api/usuarios/{id}`  
  Remove um usuário

- ✅ Validação de **e-mail**, **nome** e **senha**  
- ⚡ Cache de listagem com Caffeine  
