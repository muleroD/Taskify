CREATE SCHEMA IF NOT EXISTS "public";

CREATE TABLE "user"
(
    id         SERIAL PRIMARY KEY,
    name       VARCHAR(255)        NOT NULL,
    email      VARCHAR(255) UNIQUE NOT NULL,
    password   CHAR(60)            NOT NULL,
    created_at TIMESTAMP           NOT NULL DEFAULT CURRENT_TIMESTAMP
);

DO
$$
    DECLARE
        first_name TEXT;
        last_name  TEXT;
        email      VARCHAR;
        password   VARCHAR;
    BEGIN
        INSERT INTO "user" (name, email, password)
        VALUES ('Richard Mulero', 'richard.mulero@mail.com', md5(random()::text));

        FOREACH first_name IN ARRAY ARRAY ['João', 'Maria', 'Pedro', 'Ana', 'Carlos']
            LOOP
                FOREACH last_name IN ARRAY ARRAY ['Silva', 'Santos', 'Pereira', 'Oliveira', 'Souza']
                    LOOP
                        email := lower(first_name) || '.' || lower(last_name) || '@mail.com';
                        password := md5(random()::text);
                        INSERT INTO "user" (name, email, password)
                        VALUES (first_name || ' ' || last_name, email, password);
                    END LOOP;
            END LOOP;
    END;
$$;