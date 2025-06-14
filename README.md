# Labvision Backend

Aplicação back-end em Spring Boot para gerenciamento de amostras e medições em laboratório, com persistência em H2 (em memória) durante desenvolvimento e suporte a PostgreSQL para produção.

---

## 📝 Descrição

Este projeto demonstra uma API REST em Spring Boot com:

- **Spring Data JPA** para persistência.
- **H2 Console** habilitado para inspeção do banco durante desenvolvimento.
- **PostgreSQL** como banco para produção.
- **Auditoria** simples em schema dedicado (`AUDIT.AUDIT_LOGS`).
- **Configuração de segurança** flexível: no perfil `dev`, desativa CSRF e libera todos os endpoints; em produção, recomenda-se JWT ou outra estratégia.
- **API** de Usuários, Amostras e Medições.

---

## 🚀 Tecnologias

- Java 17  
- Spring Boot 3.1.6  
- Spring Data JPA  
- H2 Database 2.1.x (dev)  
- PostgreSQL 15+ (prod)  
- Spring Security  
- Maven  

---

## ⚙️ Perfis e configuração

### Perfil `dev` (H2 in-memory)

```properties
# src/main/resources/application-dev.properties
spring.datasource.url=jdbc:h2:mem:labvisiondb;DB_CLOSE_DELAY=-1;DB_CLOSE_ON_EXIT=FALSE
spring.datasource.driverClassName=org.h2.Driver
spring.datasource.username=sa
spring.datasource.password=
spring.jpa.hibernate.ddl-auto=update

# para carregar o schema de auditoria
spring.sql.init.mode=always
spring.sql.init.schema-locations=classpath:schema-h2.sql

# segurança relaxada
spring.security.user.name=dev
spring.security.user.password=dev


### Perfil `prod` (PostgreSQL)

# src/main/resources/application-prod.properties
spring.datasource.url=jdbc:postgresql://<HOST>:5432/labvision
spring.datasource.username=<USER>
spring.datasource.password=<PASS>
spring.jpa.hibernate.ddl-auto=validate
spring.flyway.enabled=true

# Flyway
spring.flyway.locations=classpath:db/migration
```

---

## 📥 Instalação e execução
### Clone no repositorio
```bash
git clone https://github.com/seu-usuario/labvision-backend.git
cd labvision-backend
```
### Compile
```bash
./mvnw clean install
```
### Execute em dev (H2)
```bash
# Linux/macOS
SPRING_PROFILES_ACTIVE=dev ./mvnw spring-boot:run

# Windows PowerShell
$env:SPRING_PROFILES_ACTIVE = "dev"
.\mvnw spring-boot:run
```
### Execute em prod (PostgreSQL)
```bash
$env:SPRING_PROFILES_ACTIVE = "prod"
.\mvnw spring-boot:run
```
### A API ficará disponível em
`http://localhost:8080`

---

## 🔧 H2 Console (dev)
URL: `http://localhost:8080/h2-console`

JDBC URL: `jdbc:h2:mem:labvisiondb;DB_CLOSE_DELAY=-1;DB_CLOSE_ON_EXIT=FALSE`
- **Usuário**: sa
- **Senha**: (vazio)
- **Schema**: selecione PUBLIC

---

## 📦 Endpoints principais

| Método | URL | Descrição | Autorização (dev) |
|--------|-----|-----------|-------------------|
| POST | `/api/users` | Cria novo usuário | livre |
| GET | `/api/users` | Lista todos usuários | livre |
| GET | `/api/users/{id}` | Detalha usuário por ID | livre |
| POST | `/api/auth/login` | Autentica e retorna token JWT | livre |
| POST | `/api/samples` | Cria nova amostra | livre |
| GET | `/api/samples` | Lista amostras | livre |
| POST | `/api/measurements` | Cria nova medição | livre |
| GET | `/api/measurements` | Lista medições | livre |

> **⚠️ Atenção:** Em produção, remova `csrf.disable()` e `permitAll()`, implementando roles e JWT.
