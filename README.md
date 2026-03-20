<div align="center">

# 💻 ACDX V2 — Back-end

> API back-end desenvolvida para fins de estudo, integração com front-end e prática de desenvolvimento full stack.

![Status](https://img.shields.io/badge/Status-Em%20Andamento-yellow?style=for-the-badge)
![Tipo](https://img.shields.io/badge/Projeto-Estudo-blue?style=for-the-badge)

---

![Java](https://img.shields.io/badge/Java-Back--end-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white)
![Spring Boot](https://img.shields.io/badge/Spring_Boot-API-6DB33F?style=for-the-badge&logo=springboot&logoColor=white)
![Maven](https://img.shields.io/badge/Maven-Build-C71A36?style=for-the-badge&logo=apachemaven&logoColor=white)
![REST API](https://img.shields.io/badge/REST-API-005571?style=for-the-badge)
![JPA](https://img.shields.io/badge/JPA-Persist%C3%AAncia-59666C?style=for-the-badge)
![MySQL](https://img.shields.io/badge/MySQL-Banco_de_Dados-4479A1?style=for-the-badge&logo=mysql&logoColor=white)

</div>

---

## 📌 Sobre o Projeto

Este repositório contém o **back-end** da aplicação, desenvolvido com foco em aprendizado prático, organização em camadas e integração com uma interface web.

O projeto foi criado como parte de um processo de estudo em desenvolvimento full stack, com o objetivo de aplicar conceitos como criação de API, regras de negócio, persistência de dados, integração entre sistemas e boas práticas de organização de código.

O front-end da aplicação está disponível no repositório:

👉 **Front-end:** [https://github.com/AndersonJJR/ACDX V2-Front-End](https://github.com/AndersonJJR/ACDX_V2-Front-End)

---

## 🚧 Status do Projeto

| Item | Situação |
|------|----------|
| Tipo | Estudo |
| Status | Em andamento |
| Objetivo | Aprendizado e evolução prática |
| Integração | Front-end + Back-end |

---

## 🛠️ Tecnologias Utilizadas

### Back-end
- Java
- Spring Boot
- Spring Web
- Spring Data JPA
- Maven
- API REST
- Spring Security
- JWT
- OAuth2
- Lombok
- Validation

### Banco de Dados
- MySQL

### Ferramentas e Apoio
- Git e GitHub
- Postman ou Insomnia
- IDE Java (IntelliJ IDEA / VS Code / Eclipse)
- Ethereal

---

## 🧱 Arquitetura do Projeto

A aplicação segue uma estrutura típica de projetos back-end com separação de responsabilidades, facilitando manutenção, testes e evolução do código.

```bash
meu_projeto/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── ...                
│   │   └── resources/
│   │       ├── application.properties
│   │       └── ...
│   └── test/
│       └── java/                  
├── mvnw
├── mvnw.cmd
├── pom.xml
└── README.md

```
---

## 🎯 Objetivos do Projeto
### Este projeto foi desenvolvido com os seguintes objetivos:

- Praticar desenvolvimento back-end com Java.

- Criar uma API estruturada e organizada.

- Trabalhar com persistência de dados.

- Integrar o back-end com um front-end Angular.

- Aplicar conceitos de arquitetura em camadas.

- Evoluir habilidades em desenvolvimento full stack.

---

## ⚙️ Pré-requisitos
### Antes de executar o projeto, você precisa ter instalado em sua máquina:

- Java 17 ou superior

- Maven 3.8 ou superior

- MySQL

- Git

---

## 🚀 Como Executar o Projeto

### Clonar o repositório

```bash
git clone https://github.com/AndersonJJR/meu_projeto.git
cd meu_projeto
```

---

## Configurar o banco de dados
### Crie um banco de dados no MySQL para a aplicação.

- Exemplo:

```sql
CREATE DATABASE meu_projeto_db;
```

---

## Configurar as variáveis no application.properties

- Exemplo base:

```text
spring.datasource.url=jdbc:mysql://${DB_HOST}/${DB_NAME}
spring.datasource.username=${DB_USERNAME}
spring.datasource.password=${DB_PASSWORD}

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.format_sql=true
```

---

## 🔌 Integração com o Front-end

- Este back-end foi pensado para funcionar em conjunto com o projeto front-end disponível em:

👉 (https://github.com/AndersonJJR/ACDX_V2-Front-End)

### Fluxo esperado da aplicação:

- O front-end consome os endpoints da API.

- O back-end processa regras de negócio.

- Os dados são persistidos no banco de dados.

- As respostas são devolvidas em formato JSON para a interface.

- Caso necessário, ajuste configurações de CORS para permitir a comunicação entre front-end e back-end em ambiente local.

```java
@CrossOrigin(origins = "http://localhost:4200")
```

---

## 📚 Aprendizados Aplicados
### Durante o desenvolvimento deste projeto, foram praticados conceitos como:

- Estruturação de APIs REST

- Separação em camadas

- Persistência com JPA

- Integração com banco de dados

- Tratamento de requisições HTTP

- Integração entre front-end e back-end

- Organização de projeto com Maven

## 👤 Autor

<div align="center">

<img src="https://avatars.githubusercontent.com/u/206952189?v=4" width="100px" style="border-radius: 50%;" alt="Foto do autor"/>

**Anderson JJR**

[![GitHub](https://img.shields.io/badge/GitHub-AndersonJJR-181717?style=for-the-badge&logo=github&logoColor=white)](https://github.com/AndersonJJR)

[![LinkedIn](https://img.shields.io/badge/LinkedIn-Anderson-0A66C2?style=for-the-badge&logo=linkedin&logoColor=white)](https://www.linkedin.com/in/andersonchavesjunior/)

</div>

---

<div align="center">
  <p>Feito por Anderson Júnior</p>
</div>
