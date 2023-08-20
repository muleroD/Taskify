CREATE SCHEMA IF NOT EXISTS "public";

CREATE TABLE "role"
(
    id   SERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL UNIQUE
);

insert into "role" (name)
values ('ADMIN');

insert into "role" (name)
values ('USER');

CREATE TABLE user_roles
(
    user_id SERIAL REFERENCES "user" (id),
    role_id SERIAL REFERENCES "role" (id),
    PRIMARY KEY (user_id, role_id)
);

CREATE TABLE "user"
(
    id         SERIAL PRIMARY KEY,
    name       VARCHAR(255)        NOT NULL,
    email      VARCHAR(255) UNIQUE NOT NULL,
    password   CHAR(60)            NOT NULL,
    role_id    INTEGER             NOT NULL REFERENCES "role" (id),
    created_at TIMESTAMP           NOT NULL DEFAULT CURRENT_TIMESTAMP
);