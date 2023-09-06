## Fluxo de Usuário

### Registro de Usuário

**Descrição:** O usuário deve conseguir se registrar no sistema para criar uma conta.

**Passos:**

1. Acesse a página de registro.
2. Preencha o formulário de registro com as informações necessárias, incluindo nome, endereço de e-mail e senha.
3. Clique no botão "Registrar".
4. O sistema verifica se as informações são válidas e únicas.
5. Se as informações forem válidas e únicas, o sistema cria uma nova conta de usuário com a role padrão de "Usuário".
6. O usuário recebe uma confirmação de registro bem-sucedido sendo redirecionado para a página de login.

### Login de Usuário

**Descrição:** O usuário registrado deve poder fazer login no sistema.

**Passos:**

1. Acesse a página de login.
2. Preencha o formulário de login com o endereço de e-mail e a senha.
3. Clique no botão "Entrar".
4. O sistema verifica as credenciais do usuário.
5. Se as credenciais forem válidas, o sistema gera um token de autenticação e redireciona o usuário para a página
   inicial.
6. O usuário agora está autenticado e pode acessar recursos protegidos de acordo com sua role.

### Definição de Roles

**Descrição:** O sistema define várias roles para gerenciar as permissões dos usuários.

**Roles:**

- **Usuário**: A role padrão atribuída a todos os usuários registrados.
- **Administrador**: Uma role com permissões avançadas para gerenciar projetos e usuários.
- **Membro da Equipe**: Uma role para colaboradores em projetos, com permissões específicas.
- **Gerente de Projeto**: Uma role para gerenciamento de projetos, com permissões adicionais.

### Perfil de Usuário

**Descrição:** O usuário deve conseguir visualizar e editar seu perfil.

**Passos:**

1. O usuário autenticado acessa sua página de perfil.
2. O sistema exibe as informações do perfil, incluindo nome, endereço de e-mail e outras informações pessoais.
3. O usuário pode editar as informações do perfil, se desejar.
4. As alterações são salvas com sucesso, e as permissões do usuário são mantidas de acordo com sua role.

### Logout de Usuário

**Descrição:** O usuário deve conseguir fazer logout do sistema.

**Passos:**

1. O usuário autenticado acessa a opção de logout.
2. O sistema encerra a sessão do usuário e o redireciona para a página de login.

Esta adição sobre definição de roles garante que as permissões dos usuários sejam gerenciadas de forma eficaz,
permitindo que diferentes tipos de usuários acessem recursos específicos de acordo com suas funções no sistema. As
roles "Administrador", "Membro da Equipe" e "Gerente de Projeto" podem ser personalizadas com permissões específicas
para atender às necessidades do sistema.