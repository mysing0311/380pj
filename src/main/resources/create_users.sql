CREATE TABLE users (
    username VARCHAR(50) NOT NULL,
    password VARCHAR(50) NOT NULL,
    PRIMARY KEY (username)
);

CREATE TABLE user_roles (
    user_role_id INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
    username VARCHAR(50) NOT NULL,
    role VARCHAR(50) NOT NULL,
    PRIMARY KEY (user_role_id),
    FOREIGN KEY (username) REFERENCES users(username)
);

INSERT INTO users VALUES ('michael', 'michaelpw');
INSERT INTO user_roles(username, role) VALUES ('michael', 'ROLE_USER');
INSERT INTO user_roles(username, role) VALUES ('michael', 'ROLE_ADMIN');

INSERT INTO users VALUES ('naomi', 'naomipw');
INSERT INTO user_roles(username, role) VALUES ('naomi', 'ROLE_ADMIN');

INSERT INTO users VALUES ('david', 'davidpw');
INSERT INTO user_roles(username, role) VALUES ('david', 'ROLE_USER');

INSERT INTO users VALUES ('long', 'longpw');
INSERT INTO user_roles(username, role) VALUES ('long', 'ROLE_USER');
