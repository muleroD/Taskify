CREATE SCHEMA IF NOT EXISTS "public";

CREATE TABLE "user"
(
    id        SERIAL PRIMARY KEY,
    name      VARCHAR(255)        NOT NULL,
    email     VARCHAR(255) UNIQUE NOT NULL,
    password  CHAR(60)            NOT NULL,
    create_at TIMESTAMP           NOT NULL DEFAULT CURRENT_TIMESTAMP
);
