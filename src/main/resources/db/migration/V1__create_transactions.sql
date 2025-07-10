CREATE TABLE transactions
(
    id          UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    amount      DECIMAL NOT NULL,
    description VARCHAR(250),
    date        DATE    NOT NULL DEFAULT CURRENT_DATE,
    user_id     UUID    NOT NULL,
    category_id UUID    NOT NULL,
    FOREIGN KEY (user_id) REFERENCES users (id),
    FOREIGN KEY (category_id) REFERENCES categories (id)
);

CREATE INDEX idx_user ON transactions (user_id);
CREATE INDEX idx_category ON transactions (category_id);