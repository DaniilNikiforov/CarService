--liquibase formatted sql

--changeset author:2021-05-02-insert-data-into-roles_user
INSERT INTO roles (id, name) VALUES (1, "USER");

--rollback DELETE FROM roles WHERE id = 1;

--changeset author:2021-05-02-insert-data-into-roles_admin
INSERT INTO roles (id, name) VALUES (2, "ADMIN");

--rollback DELETE FROM roles WHERE id = 2;
