CREATE TABLE users
(
    id         UUID PRIMARY KEY      DEFAULT gen_random_uuid(),
    email      VARCHAR(250) NOT NULL unique,
    password   VARCHAR(100) NOT NULL,
    username   VARCHAR(50)  NOT NULL,
    created_at TIMESTAMP    NOT NULL DEFAULT CURRENT_TIMESTAMP
);