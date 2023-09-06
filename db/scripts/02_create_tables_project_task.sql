CREATE TABLE "project"
(
    id          SERIAL PRIMARY KEY,
    name        VARCHAR(255) NOT NULL,
    description VARCHAR(255)
);


CREATE TABLE "user_project"
(
    id         SERIAL PRIMARY KEY,
    user_id    INT       NOT NULL REFERENCES "user" (id),
    project_id INT       NOT NULL REFERENCES project (id),
    joined_at  TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE "task"
(
    id          SERIAL PRIMARY KEY,
    project_id  INT          NOT NULL REFERENCES project (id),
    name        VARCHAR(255) NOT NULL,
    description VARCHAR(255),
    due_date    TIMESTAMP,
    priority    INT,
    status      VARCHAR(255)
);