CREATE TABLE IF NOT EXISTS todo (
    id SERIAL PRIMARY KEY,
    title VARCHAR(255) NOT NULL,
    is_completed BOOLEAN NOT NULL DEFAULT FALSE
);

INSERT INTO todo (title, is_completed) VALUES ('First Task', false);
INSERT INTO todo (title, is_completed) VALUES ('Second Task', true);
INSERT INTO todo (title, is_completed) VALUES ('Third Task', false);
