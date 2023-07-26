# Usa uma imagem base do PostgreSQL
FROM postgres:latest

# Copia os scripts para o diretório de scripts da imagem do PostgreSQL
COPY scripts /docker-entrypoint-initdb.d/

# Define uma variável de ambiente para configurar o PostgreSQL
ENV POSTGRES_DB task_manager

# Exponha a porta padrão do PostgreSQL
EXPOSE 5432