CREATE TABLE categories
(
    id      UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    name    VARCHAR(50) NOT NULL,
    type    VARCHAR(50) NOT NULL,
    user_id UUID        NOT NULL,
    CONSTRAINT fk_user FOREIGN KEY (user_id) REFERENCES users (id),
    CONSTRAINT uk_name_user UNIQUE (name, user_id)
);

CREATE INDEX idx_name ON categories (name);
CREATE INDEX idx_user_id ON categories (user_id);