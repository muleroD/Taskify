# Progresso do Projeto

Este arquivo é usado para acompanhar o andamento das etapas sendo finalizadas no projeto.

## Etapas Iniciais

- [x] Criar a estrutura básica do projeto usando o Spring Initializr.
- [x] Configurar o projeto com Java 17.
- [x] Escolher o sistema de build Maven.
- [x] Definir as dependências iniciais, incluindo Spring Boot 3.1.1 e outras necessárias.
- [x] Configurar o projeto no GitHub.
- [x] Escolher a Licença MIT para o projeto.

## Configuração do Banco de Dados

- [x] Selecionar o banco de dados PostgreSQL para uso.
- [x] Criar o Dockerfile para configurar o banco de dados PostgreSQL em um contêiner Docker.
- [x] Definir as configurações de conexão com o banco de dados no arquivo de propriedades do Spring.
- [x] Gerar os scripts SQL para a criação das tabelas de banco de dados.

## GraphQL

- [x] Configurar a camada GraphQL no projeto.
- [x] Definir os tipos GraphQL, incluindo User e Query.
- [x] Implementar consultas e mutações GraphQL para os usuários.
- [x] Implementar tratamento de erros para consultas GraphQL.
- [x] Documentar as consultas e mutações GraphQL.

## Autenticação e Autorização

- [x] Implementar o filtro de autenticação JWT.
- [x] Implementar o filtro de autorização JWT para proteger recursos.
- [ ] Definir roles e permissões para os usuários.
- [ ] Implementar autorização baseada em roles.

## Gerenciamento de usuário

### Registro de Usuário

- **Status**: Concluído
- **Descrição**: Implementação do sistema de registro de usuários.
- **Tarefas completas**:
    - [x] Acesso à página de registro.
    - [X] Preenchimento do formulário de registro.
    - [X] Verificação e validação das informações pelos sistemas.
    - [X] Criação de nova conta de usuário.

### Login de Usuário

- **Status**: Concluído
- **Descrição**: Implementação do sistema de login de usuários.
- **Tarefas completas**:
    - [x] Acesso à página de login.
    - [X] Preenchimento do formulário de login.
    - [x] Criar o endpoint de login para autenticação de usuários.
    - [X] Verificação de credenciais válidas pelo sistema.
    - [X] Geração de token de autenticação.

### Recuperação de Senha

- **Status**: Não iniciado
- **Descrição**: Implementação de funcionalidade de recuperação de senha.

### Perfil de Usuário

- **Status**: Não iniciado
- **Descrição**: Implementação de visualização e edição de perfil de usuário.

### Logout de Usuário

- **Status**: Não iniciado
- **Descrição**: Implementação do sistema de logout.

## Gerenciamento de Projetos

### Criação de Projeto

- **Status**: Não iniciado
- **Descrição**: Implementação do fluxo de criação de projetos para usuários autenticados.
- **Tarefas completas**:
    - [ ] Acesso à página de criação de projeto.
    - [ ] Preenchimento de formulário com informações do projeto.
    - [ ] Adição de membros da equipe ao projeto.
    - [ ] Criação do projeto e redirecionamento para a página de detalhes.

### Gerenciamento de Projetos

- **Status**: Não iniciado
- **Descrição**: Desenvolvimento das funcionalidades de gerenciamento de projetos.
- **Tarefas completas**:
    - [ ] Visualização da lista de projetos do usuário.
    - [ ] Seleção e visualização de detalhes do projeto.
    - [ ] Adição e remoção de membros da equipe.
    - [ ] Salvamento de alterações.

### Visualização de Projetos

- **Status**: Não iniciado
- **Descrição**: Implementação das funcionalidades de visualização de projetos acessíveis ao usuário.

### Colaboração em Projetos

- **Status**: Não iniciado
- **Descrição**: Adição de funcionalidades para colaboração em projetos, incluindo a criação de tarefas.

### Atualização de Status de Tarefas

- **Status**: Não iniciado
- **Descrição**: Habilitar a atualização do status das tarefas nos projetos.

### Comentários em Projetos

- **Status**: Não iniciado
- **Descrição**: Desenvolvimento de funcionalidades para adicionar comentários aos projetos e tarefas.