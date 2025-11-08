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
- - [Postman](https://www.postman.com/downloads/) **ou** o plugin **REST Client** [Obsidian](https://obsidian.md/) para requisição e resposta

### 1️⃣ Clone o repositório
```bash
git clone https://github.com/seu-usuario/nome-do-repositorio.git
cd nome-do-repositorio ```

2️⃣ Suba os containers
```bash
docker-compose up -d

A API estará disponível em:
👉 http://localhost:8080
O banco MySQL estará rodando na porta 3310.

### Criar uma tarefa
POST http://localhost:8080/app/tasks
Content-Type: application/json

{
  "description": "Aprender Spring Boot"
}

### Listar tarefas
GET http://localhost:8080/app/tasks
