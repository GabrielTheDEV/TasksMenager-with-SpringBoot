# 📝 Task API

API REST para gerenciamento de tarefas, desenvolvida com **Spring Boot**, **MySQL** e **Docker Compose**.

---

## 🚀 Tecnologias
- **Java 17+**
- **Spring Boot**
- **Spring Data JPA**
- **MySQL**
- **Docker**
- **Docker Compose**

---

## ⚙️ Como executar o projeto

### Pré-requisitos
- Ter o Docker e Docker Compose instalados em sua máquina.
- - [Postman](https://www.postman.com/downloads/)( Preferencia ) para requisição e resposta

### 1️⃣ Clone o repositório
```bash
git clone https://github.com/GabrielTheDEV/TasksMenager-with-SpringBoot
```
2️⃣ Suba os containers
```bash
docker-compose up --build
```
A API estará disponível em:
```bash
👉 http://localhost:8080
```
O banco MySQL estará rodando na porta 3310.

### Criar uma tarefa
```bash
POST http://localhost:8080/app/tasks
Content-Type: application/json
{
  "description": "Descrição da Tarefa"
}
```
### Listar tarefas
```bash
GET http://localhost:8080/app/tasks
```
### Buscar tarefa pelo Id
```bash
GET http://localhost:8080/app/tasks/id
```
### Filtrar tarefas concluidas
```bash
GET http://localhost:8080/app/tasks?completed=true
```
### Filtra tarefas incompletas
```bash
GET http://localhost:8080/app/tasks?completed=false
```
### Deletar Tarefa
```bash
DELETE http://localhost:8080/app/tasks/id
```
### Atualizar tarefa
```bash
POST http://localhost:8080/app/tasks/id
Content-Type: application/json
{
  "description": "Nova descrição"
}
```
### Marcar como Concluido
```bash
PATCH http://localhost:8080/app/tasks/id/completed
```
### Marcar como Incompleto]
```bash
PATCH http://localhost:8080/app/tasks/id/incomplete
```
