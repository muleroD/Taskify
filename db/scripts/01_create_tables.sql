CREATE SCHEMA IF NOT EXISTS "public";

CREATE TABLE "user"
(
    id         SERIAL PRIMARY KEY,
    name       VARCHAR(255)        NOT NULL,
    email      VARCHAR(255) UNIQUE NOT NULL,
    password   CHAR(60)            NOT NULL,
    role       VARCHAR(10)         NOT NULL DEFAULT 'USER',
    created_at TIMESTAMP           NOT NULL DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE project
(
    id          SERIAL PRIMARY KEY,
    name        VARCHAR(255) NOT NULL,
    description VARCHAR(255)
);

CREATE TABLE task
(
    id          SERIAL PRIMARY KEY,
    name        VARCHAR(255) NOT NULL,
    description VARCHAR(255),
    due_date    TIMESTAMP,
    priority    INT,
    project_id  INT          NOT NULL REFERENCES project (id),
    status      VARCHAR(255)
);

ALTER TABLE task
    ADD CONSTRAINT fk_project_id FOREIGN KEY (project_id) REFERENCES project (id);
