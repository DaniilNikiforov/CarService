--liquibase formatted sql

--changeset author:2021-05-01-create-table-roles
CREATE TABLE roles(
	id INT UNSIGNED PRIMARY KEY NOT NULL,
	name VARCHAR(15)
)

--rollback drop table roles;