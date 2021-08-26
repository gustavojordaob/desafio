## TÉCNOLOGIAS ESCOLHIDAS
- JAVA 11
- MAVEN
- Spring Boot 2.5.0
- JPA
- BANCO DE DADOS H2
- JUNIT 5
POSTMAN

## PRÉ REQUISITOS PARA RODAR ESSE PROJETO
- JAVA 11
- MAVEN
- Client POSTMAN ou similiares para testar os endpoints

### COMANDO DE EXECUÇÃO

Necessário rodar o comando (dentro do diretório do projeto)

`mvn clean install`

### URLS DOS ENDPOINTS

**GET**
URL do endpoint que retorna uma lista de terminais:

`http://localhost:8080/api/v1/terminal`

**GET**
URL do endpoint que retorna um terminal /{logic}:

`http://localhost:8080/api/v1/terminal/44332211`

**POST**
URL do endpoint que cria um terminal:

`http://localhost:8080/api/v1/terminal`

**PUT**
URL do endpoint que atualiza um terminal:

`http://localhost:8080/api/v1/terminal/44332211`
