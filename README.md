# CourseApp - Sistema de Pedidos com Spring Boot
<img src="https://cdn.jsdelivr.net/gh/devicons/devicon/icons/java/java-original.svg" width="60" alt="Java logo"> <img src="https://cdn.jsdelivr.net/gh/devicons/devicon/icons/spring/spring-original.svg" width="60" alt="Spring logo"> <img src="https://cdn.jsdelivr.net/gh/devicons/devicon/icons/mysql/mysql-original.svg" width="60" alt="MySQL logo">

---

# Cenário

O projeto é uma aplicação de e-commerce simplificado que gerencia:

Usuários (clientes que realizam pedidos)

Produtos (itens disponíveis para compra)

Categorias (classificação dos produtos)

Pedidos (Orders) feitos pelos usuários

Itens de Pedido (OrderItem) que relacionam produtos com pedidos

Pagamentos (Payment) vinculados a um pedido

Exemplo de fluxo:

Um usuário é cadastrado no sistema.

Ele realiza um pedido contendo um ou mais produtos.

Cada pedido pode ter um pagamento associado.

Os dados são persistidos no banco de dados relacional (MySQL).

---

#Arquitetura Utilizada

O projeto segue a Arquitetura em Camadas (Layered Architecture):

Entities (Domínio) → representam as tabelas do banco (User, Product, Order, Payment, Category, etc.).

Repositories → fazem a comunicação com o banco (CRUD e consultas).

Services → camada de regras de negócio, responsável por orquestrar as operações.

Resources (Controllers REST) → expõem os endpoints da API para o cliente.

Config → configurações iniciais e instanciamento de dados para testes.

# Fluxo:
Cliente (HTTP Request) → Resource → Service → Repository → Banco de Dados

---

# Tecnologias Utilizadas

Java 17+

Spring Boot 3.x

Spring Web (APIs REST)

Spring Data JPA (persistência)

Hibernate (ORM)

MySQL (banco relacional)

Maven (gerenciador de dependências)

---

# Endpoints Principais
Usuários

GET /users → listar todos

GET /users/{id} → buscar usuário por id

POST /users → criar novo usuário

DELETE /users/{id} → deletar usuário

Produtos

GET /products → listar produtos

GET /products/{id} → buscar produto por id

Pedidos

GET /orders → listar pedidos

GET /orders/{id} → buscar pedido por id

---

# Benchmarks / Objetivos

Aprendizado prático de Spring Boot e arquitetura em camadas.

Simulação de um sistema de pedidos inspirado em e-commerce.

Organização modular e escalável para manutenção futura.
