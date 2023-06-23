# Taskify

Aplicação de gerenciamento de tarefas baseada em Java e GraphQL.

## Tecnologias Utilizadas

- Java 17
- Spring Boot 3.1.1
- GraphQL

## Pré-requisitos

- Java 17 instalado
- Maven instalado

## Instalação

### Ambiente de Desenvolvimento

1. Faça o clone deste repositório.
2. Acesse o diretório do projeto: `cd taskify`.
3. Execute o comando de build: `mvn clean install`.
4. Inicie o servidor com hot reload: `mvn spring-boot:run`.

### Ambiente de Produção

1. Copie o arquivo JAR gerado em `target/taskify.jar` para o ambiente de produção.
2. Execute o servidor: `java -jar taskify.jar`.
3. Acesse a aplicação em `http://localhost:8080`.

## Fluxos de Negócio e Etapas

### Fluxo de Cadastro de Tarefas

1. O usuário envia uma requisição GraphQL para criar uma nova tarefa.
2. O servidor processa a requisição e valida os dados recebidos.
3. A tarefa é persistida no banco de dados.
4. O servidor retorna a resposta com a tarefa criada.

### Fluxo de Consulta de Tarefas

1. O usuário envia uma requisição GraphQL para obter a lista de tarefas.
2. O servidor processa a requisição e busca as tarefas no banco de dados.
3. As tarefas são retornadas como resposta da requisição.

## Contribuição

Contribuições são bem-vindas! Sinta-se à vontade para abrir uma solicitação de pull ou relatar problemas.

## Licença

Este projeto está licenciado sob a [MIT License](LICENSE).

## Contato

Para mais informações, entre em contato através do e-mail: mulerolp@gmail.com