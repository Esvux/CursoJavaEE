CREATE TABLE IF NOT EXISTS role(
   id SERIAL PRIMARY KEY,
   role_name VARCHAR(100) NOT NULL
);

CREATE TABLE IF NOT EXISTS account(
   id SERIAL PRIMARY KEY,
   email VARCHAR(40) NOT NULL,
   username VARCHAR(15) NOT NULL,
   password VARCHAR(255) NOT NULL,
   firstname VARCHAR(100),
   lastname VARCHAR(100),
   active BOOLEAN,
   created TIMESTAMP,
   updated TIMESTAMP
);

CREATE TABLE IF NOT EXISTS account_role(
   id SERIAL PRIMARY KEY,
   account_id INTEGER,
   role_id INTEGER,
   FOREIGN KEY (account_id) REFERENCES account(id),
   FOREIGN KEY (role_id) REFERENCES role(id)
);

CREATE OR REPLACE VIEW view_account_role AS (
   SELECT account_role.account_id, account_role.role_id, account.username, account.password, role.role_name
   FROM account_role, account, role
   WHERE account_role.account_id = account.id
   AND account_role.role_id = role.id
);

INSERT INTO role VALUES (1, 'admin'), (2, 'normal_user');
INSERT INTO account (email, username, password, firstname, lastname, active) VALUES ('esvin@mail.com', 'esvin', '10/w7o2juYBrGMh32/KbveULW9jk2tejpyUAD+uC6PE=', 'Esvin', 'González', TRUE);
INSERT INTO account (email, username, password, firstname, lastname, active) VALUES ('demo@mail.com', 'demo', '10/w7o2juYBrGMh32/KbveULW9jk2tejpyUAD+uC6PE=', 'Demo', 'User', TRUE);
INSERT INTO account_role (account_id, role_id) VALUES (1, 1);
INSERT INTO account_role (account_id, role_id) VALUES (2, 2);

SELECT * FROM view_account_role;