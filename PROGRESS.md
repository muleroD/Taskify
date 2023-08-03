# Progresso do Projeto

Este arquivo é usado para acompanhar o andamento das etapas sendo finalizadas no projeto.

## Configurações Iniciais

- [x] Configuração do projeto com Spring Initializr
- [x] Definição das dependências e versões
- [X] Configuração do banco de dados (PostgreSQL)
- [X] Mapeamento das entidades e relacionamentos (JPA)
- [X] Implementação das classes de repositório (DAO)

## Fluxos de Negócio e Etapas

### Autenticação de Usuários

- [ ] Os usuários podem se registrar e fazer login no sistema.
- [ ] O sistema deve verificar as credenciais do usuário e fornecer um token de autenticação válido para
  acessar recursos protegidos.

### Gerenciamento de Projetos

- [ ] Os usuários podem criar projetos e atribuí-los a uma equipe.
- [ ] Os projetos podem ter informações como título, descrição e prazo.
- [ ] Os usuários podem adicionar membros da equipe aos projetos.

### Gerenciamento de Tarefas

- [ ] Os usuários podem criar tarefas e atribuí-las a um projeto.
- [ ] As tarefas podem ter informações como título, descrição, prazo e status.
- [ ] Os usuários podem adicionar membros da equipe às tarefas.
- [ ] Os usuários podem alterar o status de uma tarefa. Os status podem ser `TODO`, `IN_PROGRESS` e `DONE`.
- [ ] Os usuários podem visualizar todas as tarefas atribuídas a eles ou a um projeto específico.

### Comentários e Notificações

- [ ] Os usuários podem comentar em tarefas.
- [ ] Os usuários podem receber notificações quando um novo comentário for adicionado a uma tarefa.
- [ ] Os usuários podem receber notificações quando uma tarefa for atribuída a eles.

### Relatórios e Estatísticas

- [ ] Os usuários podem gerar relatórios sobre o andamento do projeto, como tarefas concluídas,
  tarefas pendentes e membros da equipe mais produtivos.
- [ ] Os usuários podem visualizar estatísticas sobre o andamento do projeto, como o número de tarefas
  concluídas, o número de tarefas pendentes e o número de membros da equipe mais produtivos.

## Contribuição

Contribuições são bem-vindas! Sinta-se à vontade para abrir uma solicitação de pull ou relatar problemas.

## Licença

Este projeto está licenciado sob a [MIT License](LICENSE).