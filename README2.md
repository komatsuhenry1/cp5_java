# Projeto Spring Boot - Sistema de Gerenciamento de Brinquedos

Este projeto foi desenvolvido para uma empresa de brinquedos infantis (até 12 anos), com base no **Spring Security MVC** e o **framework Spring Boot**, utilizando **Java** e **Maven**. Ele oferece uma aplicação web para gerenciar um inventário de brinquedos com operações CRUD (Create, Read, Update, Delete), além de controle de acesso e autenticação. Utilizamos o **PostgreSQL** para persistência de dados e o **Lombok** para reduzir a quantidade de código boilerplate.

## Índice
- [Descrição do Projeto](#descrição-do-projeto)
- [Funcionalidades](#funcionalidades)
- [Tecnologias Utilizadas](#tecnologias-utilizadas)
- [Configuração do Projeto](#configuração-do-projeto)
- [Screenshots e Exemplos](#screenshots-e-exemplos)
- [Deploy](#deploy)

## Descrição do Projeto

O projeto consiste em um sistema de gerenciamento de brinquedos que permite ao usuário realizar operações de CRUD em uma tabela de brinquedos no banco de dados. Além disso, há um sistema de autenticação que direciona os usuários para telas de login e registro de acordo com seu status.

### Objetivos:
- Gerenciamento de brinquedos (CRUD) via interface web.
- Autenticação e autorização de usuários utilizando **Spring Security**.
- Tela de login personalizada e fluxo de registro (Sign Up).
- Persistência de dados com **Oracle**.
- Deploy da aplicação em produção.

### Estrutura de Tabelas:
1. **TDS_Sec_MVC_TB_Brinquedos**: Armazena informações dos brinquedos.
2. **TDS_Users_Brinquedos**: Armazena as credenciais dos usuários registrados.

## Funcionalidades

1. **Autenticação e Autorização:**
   - Autenticação com Spring Security.

2. **CRUD de Brinquedos:**
   - **Create**: Adicionar um novo brinquedo.
   - **Read**: Listar todos os brinquedos ou buscar um específico.
   - **Update**: Atualizar dados de um brinquedo.
   - **Delete**: Excluir um brinquedo.

3. **Interface Web:**
   - Tela de gerenciamento de brinquedos com botões para cada operação CRUD.
   - Exibição dos brinquedos com dados buscados diretamente da tabela no PostgreSQL.

## Tecnologias Utilizadas

- **Java 17**
- **Spring Boot 3.x**
- **Spring Security**
- **Spring Data JPA**
- **Maven**
- **Lombok**
- **IntelliJ IDEA** (IDE utilizada para desenvolvimento)

## Configuração do Projeto

### Dependências do `pom.xml`:

```xml
<dependencies>
    <!-- Spring Boot Starter Web -->
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-web</artifactId>
    </dependency>

    <!-- Spring Boot Starter Security -->
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-security</artifactId>
    </dependency>

    <!-- Spring Data JPA -->
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-data-jpa</artifactId>
    </dependency>

    <!-- PostgreSQL Driver -->
    <dependency>
        <groupId>org.postgresql</groupId>
        <artifactId>postgresql</artifactId>
    </dependency>

    <!-- Lombok -->
    <dependency>
        <groupId>org.projectlombok</groupId>
        <artifactId>lombok</artifactId>
        <scope>provided</scope>
    </dependency>

    <!-- Thymeleaf -->
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-thymeleaf</artifactId>
    </dependency>
</dependencies>
```

## Screenshots e Exemplos

## Deploy