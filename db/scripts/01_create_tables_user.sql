CREATE SCHEMA IF NOT EXISTS "public";

CREATE TABLE "profile"
(
    id         SERIAL PRIMARY KEY,
    name       VARCHAR(255) NOT NULL,
    birth_date TIMESTAMP    NOT NULL,
    bio        VARCHAR(255),
    created_at TIMESTAMP    NOT NULL DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE "user"
(
    id         SERIAL PRIMARY KEY,
    profile_id INT                 NOT NULL REFERENCES profile (id),
    email      VARCHAR(255) UNIQUE NOT NULL,
    password   CHAR(60)            NOT NULL,
    role       VARCHAR(10),
    status     VARCHAR(10),
    created_at TIMESTAMP           NOT NULL DEFAULT CURRENT_TIMESTAMP,
    last_login TIMESTAMP
);